package com.example.umc.domain.review.service;

import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.member.repository.MemberRepository;
import com.example.umc.domain.review.converter.ReviewConverter;
import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;
import com.example.umc.domain.review.repository.ReviewRepository;
import com.example.umc.domain.store.entity.Store;
import com.example.umc.domain.store.exception.StoreException;
import com.example.umc.domain.store.exception.code.StoreErrorCode;
import com.example.umc.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepositiory;
    private final StoreRepository storeRepository;

    @Transactional
    public Review createReview(ReviewResponseDTO.CreateReview req) {
        Member member = memberRepositiory.findById(req.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재히지 않는 회원입니다."));
        Store store = storeRepository.findById(req.getStoreId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 가게입니다."));

        Review review = Review.builder()
                .content(req.getContent())
                .rating(req.getRating())
                .member(member)
                .store(store)
                .build();

        return reviewRepository.save(review);
    }

    @Override
    public ReviewResponseDTO.ReviewPreViewListDTO findReview(
            String storeName,
            Integer page
    ){
        Store store = storeRepository.findByName(storeName)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(page, 5);
        Page<Review> result = reviewRepository.findAllByStore(store, pageRequest);

        return ReviewConverter.toReviewPreviewListDTO(result);
    }

    @Override
    public ReviewResponseDTO.ReviewPreViewListDTO searchReview(String keyword, String type) {

        Store store = storeRepository.findByName(keyword)
                .orElseThrow(() -> new StoreException(StoreErrorCode.NOT_FOUND));

        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Review> result = reviewRepository.findAllByStore(store, pageRequest);

        return ReviewConverter.toReviewPreviewListDTO(result);
    }
}

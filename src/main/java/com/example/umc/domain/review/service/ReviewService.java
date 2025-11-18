package com.example.umc.domain.review.service;

import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.member.repository.MemberRepositiory;
import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;
import com.example.umc.domain.review.repository.ReviewRepository;
import com.example.umc.domain.store.entity.Store;
import com.example.umc.domain.store.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepositiory memberRepositiory;
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
}

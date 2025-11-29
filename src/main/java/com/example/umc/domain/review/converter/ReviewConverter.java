package com.example.umc.domain.review.converter;


import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public class ReviewConverter {
    public static ReviewResponseDTO.CreateReview createReview(Review review) {
        return ReviewResponseDTO.CreateReview.builder()
                .memberId(review.getMember().getId())
                .storeId(review.getStore().getId())
                .reviewerNickname(review.getMember().getNickname())
                .writtenAt(review.getCreatedAt())
                .rating(review.getRating())
                .content(review.getContent())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO toReviewPreviewListDTO(
            Page<Review> result
    ){
        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .reviewList(result.getContent().stream()
                        .map(ReviewConverter::toReviewPreviewDTO)
                        .toList()
                )
                .listSize(result.getSize())
                .totalPage(result.getTotalPages())
                .totalElements(result.getTotalElements())
                .isFirst(result.isFirst())
                .isLast(result.isLast())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewDTO toReviewPreviewDTO(
            Review review
    ){
        return ReviewResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getRating())
                .body(review.getContent())
                .createdAt(LocalDate.from(review.getCreatedAt()))
                .build();
    }
}
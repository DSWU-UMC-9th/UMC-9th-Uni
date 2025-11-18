package com.example.umc.domain.review.converter;


import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;

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
}
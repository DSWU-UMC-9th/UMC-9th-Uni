package com.example.umc.domain.review.converter;


import com.example.umc.domain.review.dto.ReviewResponseDTO;
import com.example.umc.domain.review.entity.Review;

public class ReviewConverter {
    public static ReviewResponseDTO.CreateReview createReview(Review review) {
        return ReviewResponseDTO.CreateReview.builder()
                .reviewId(review.getId())
                .reviewerNickname(review.getMember().getNickname())
                .writtenAt(review.getCreatedAt())
                .rating((review.getRating()))
                .replyContent(review.getReply().getContent())
                .repliedAt(review.getReply().getCreatedAt())
                .build();
    }
}
package com.example.umc.domain.review.dto;

import lombok.*;

import java.time.LocalDateTime;

public class ReviewResponseDTO {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateReview {
        private Long memberId;
        private Long storeId;
        private String reviewerNickname;
        private LocalDateTime writtenAt;
        private Float rating;
        private String content;
    }
}

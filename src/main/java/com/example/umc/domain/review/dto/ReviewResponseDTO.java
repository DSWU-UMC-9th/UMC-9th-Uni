package com.example.umc.domain.review.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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

    @Builder
    public record ReviewPreViewDTO(
            String ownerNickname,
            Float rating,
            String body,
            LocalDate createdAt
    ){}

    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreViewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}
}

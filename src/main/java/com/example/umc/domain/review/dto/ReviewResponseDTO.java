package com.example.umc.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ReviewResponseDTO {
    private Long reviewId;
    private String reviewerNickname;
    private LocalDateTime writtenAt;
    private Float rating;
    private String content;
    private String replyContent;
    private LocalDateTime repliedAt;
}

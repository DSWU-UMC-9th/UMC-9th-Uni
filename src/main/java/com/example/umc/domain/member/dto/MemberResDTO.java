package com.example.umc.domain.member.dto;

import lombok.Builder;

import java.time.LocalDateTime;

public class MemberResDTO {
    @Builder
    public record RegisterDTO(
            Long memberId,
            LocalDateTime createdAt
    ) {}
}

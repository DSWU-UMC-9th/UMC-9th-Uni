package com.example.umc.domain.member.dto;

import lombok.Builder;

public class MemberResDTO {
    @Builder
    public record RegisterDTO(
            Long memberId,
            String name,
            String nickname,
            String email
    ) {}

    @Builder
    public record LoginDTO(
            Long memberId,
            String nickname,
            String token
    ) {}
}

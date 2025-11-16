package com.example.umc.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MyPageDTO {
    private String nickname;
    private String email;
    private String phoneNum;
    private Integer points;
}

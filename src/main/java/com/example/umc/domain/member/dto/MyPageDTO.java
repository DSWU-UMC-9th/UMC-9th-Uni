package com.example.umc.domain.member.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageDTO {
    private String nickname;
    private String email;
    private String phoneNum;
    private Integer points;
}

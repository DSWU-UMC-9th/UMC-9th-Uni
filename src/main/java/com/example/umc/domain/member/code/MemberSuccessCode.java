package com.example.umc.domain.member.code;

import com.example.umc.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {
    SUCCESS_GET_MYPAGE(HttpStatus.OK, "MEMBER200", "마이페이지를 성공적으로 불러왔습니다."),
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
    }

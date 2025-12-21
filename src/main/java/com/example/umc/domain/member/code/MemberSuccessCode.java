package com.example.umc.domain.member.code;

import com.example.umc.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberSuccessCode implements BaseSuccessCode {
    SUCCESS_GET_MYPAGE(HttpStatus.OK, "MEMBER200", "마이페이지를 성공적으로 불러왔습니다."),
    FOUND(HttpStatus.OK,
            "MEMBER200_1",
            "성공적으로 사용자를 조회했습니다."),

    AUTH_SIGNUP_SUCCESS(HttpStatus.CREATED, "AUTH201_1", "회원가입이 성공적으로 완료되었습니다."),
    AUTH_LOGIN_SUCCESS(HttpStatus.OK, "AUTH200_1", "로그인이 성공적으로 완료되었습니다."),
    AUTH_LOGOUT_SUCCESS(HttpStatus.OK, "AUTH200_2", "로그아웃이 성공적으로 처리되었습니다."),;
    private final HttpStatus status;
    private final String code;
    private final String message;
    }

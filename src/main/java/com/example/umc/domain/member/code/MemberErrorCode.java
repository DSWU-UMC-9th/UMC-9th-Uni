package com.example.umc.domain.member.code;

import com.example.umc.global.apiPayload.code.BaseErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MemberErrorCode implements BaseErrorCode {
    USER_SIGNUP_FAILED(HttpStatus.BAD_REQUEST, "AUTH400_1", "회원가입에 실패했습니다."),
    USER_EMAIL_DUPLICATED(HttpStatus.BAD_REQUEST, "AUTH400_2", "이미 사용 중인 이메일입니다."),
    USER_LOGIN_FAILED(HttpStatus.UNAUTHORIZED, "AUTH401_1", "이메일 또는 비밀번호가 올바르지 않습니다."),
    USER_NOT_LOGGED_IN(HttpStatus.UNAUTHORIZED, "AUTH401_2", "로그인이 필요한 요청입니다."),
    USER_LOGOUT_FAILED(HttpStatus.BAD_REQUEST, "AUTH400_3", "로그아웃에 실패했습니다."),

    ;
    private final HttpStatus status;
    private final String code;
    private final String message;
}

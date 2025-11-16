package com.example.umc.domain.review.code;

import com.example.umc.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ReviewSuccessCode implements BaseSuccessCode {
    REVIEW_CREATE_SUCCESS(HttpStatus.CREATED, "REVIEW201", "리뷰가 성공적으로 등록되었습니다."),
    REVIEW_READ_SUCCESS(HttpStatus.OK, "REVIEW200", "리뷰 리스트를 성공적으로 불러왔습니다."),
    REVIEW_UPDATE_SUCCUESS(HttpStatus.OK, "REVIEW200", "리뷰가 성공적으로 수정되었습니다."),
    REVIEW_DELETE_SUCCUESS(HttpStatus.OK, "REVIEW200", "리뷰가 성공적으로 삭제되었습니다.");

    private final HttpStatus status;
    private final String code;
    private final String message;

}

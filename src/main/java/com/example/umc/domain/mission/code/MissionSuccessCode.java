package com.example.umc.domain.mission.code;

import com.example.umc.global.apiPayload.code.BaseSuccessCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum MissionSuccessCode implements BaseSuccessCode {
    MISSION_UPDATE_SUCDESS(HttpStatus.OK, "MISSION200_1", "미션 상태가 성공적으로 변경되었습니다."),
    SUCCESS_GET_MY_MISSION(HttpStatus.OK, "MISSION200_2", "진행 중인 미션 리스트를 성공적으로 불러왔습니다."),
    ;
    private final HttpStatus status;
    private final String code;
    private final String message;

}

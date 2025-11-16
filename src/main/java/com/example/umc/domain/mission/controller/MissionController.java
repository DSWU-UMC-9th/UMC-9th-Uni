package com.example.umc.domain.mission.controller;

import com.example.umc.domain.mission.code.MissionSuccessCode;
import com.example.umc.domain.mission.converter.MissionConverter;
import com.example.umc.domain.mission.dto.MissionResDTO;
import com.example.umc.domain.mission.entity.MemberMission;
import com.example.umc.domain.mission.service.MissionService;
import com.example.umc.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
public class MissionController {

    private final MissionService missionService;

    @PatchMapping("/{userMissionId}/complete")
    public ApiResponse<MissionResDTO.updateMissionStatus> completeMission(
            @PathVariable Long userMissionId
    ) {
        MemberMission memberMission = missionService.completeMission(userMissionId);

        return ApiResponse.onSuccess(
                MissionSuccessCode.MISSION_UPDATE_SUCDESS,
                MissionConverter.toUpdateMissionStatusResult(memberMission)
        );
    }

    @GetMapping("/{memberId}")
    public ApiResponse<MissionResDTO.MissionPageResult> getMyMissionPage(
            @PathVariable Long memberId
    ) {
        return ApiResponse.onSuccess(
                MissionSuccessCode.SUCCESS_GET_MY_MISSION,
                MissionConverter.toMissionPageResult(
                        missionService.getMyMissionPage(memberId)
                )
        );
    }
}
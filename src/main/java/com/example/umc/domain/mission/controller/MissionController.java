package com.example.umc.domain.mission.controller;

import com.example.umc.domain.mission.code.MissionSuccessCode;
import com.example.umc.domain.mission.converter.MissionConverter;
import com.example.umc.domain.mission.dto.MissionResDTO;
import com.example.umc.domain.mission.entity.MemberMission;
import com.example.umc.domain.mission.service.MissionService;
import com.example.umc.global.annotation.CheckPage;
import com.example.umc.global.apiPayload.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missions")
@RequiredArgsConstructor
@Validated
public class MissionController {

    private final MissionService missionService;

    @Operation(
            summary = "진행중인 미션 진행 완료로 바꾸기"
    )
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

    @Operation(summary = "내 미션 목록 조회")
    @GetMapping("/{memberId}")
    public ApiResponse<MissionResDTO.MyMissionListDTO> getMyMissionPage(
            @PathVariable Long memberId,
            @CheckPage @RequestParam(defaultValue = "1") Integer page)
    {
        MissionResDTO.MyMissionListDTO result = missionService.getMyMissionPage(memberId, page);
        return ApiResponse.onSuccess(MissionSuccessCode.SUCCESS_GET_MY_MISSION, result);
    }

    @Operation(
            summary = "내가 진행 중인 미션 목록 조회"
    )
    @PostMapping("/{missionId}/challenge")
    public ApiResponse<MissionResDTO.ChallengeResult> challengeMission(
            @PathVariable Long missionId,
            @RequestParam("memberId") Long memberId // 실제 환경에서는 인증 정보에서 추출해야 함
    ) {
        MissionResDTO.ChallengeResult result = missionService.challengeMission(memberId, missionId);

        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_CHALLENGE_SUCCESS, result);
    }

    @Operation(summary = "특정 가게의 미션 목록 조회 리스트")
    @GetMapping("/stores/{storeId}")
    public ApiResponse<MissionResDTO.MissionPreViewListDTO> getMissionsByStore(
            @PathVariable Long storeId,
            @CheckPage @RequestParam(name = "page") Integer page // [필수] 커스텀 어노테이션 적용
    ) {
        MissionResDTO.MissionPreViewListDTO result = missionService.getMissionsByStore(storeId, page);
        return ApiResponse.onSuccess(MissionSuccessCode.MISSION_CHALLENGE_SUCCESS, result);
    }
}
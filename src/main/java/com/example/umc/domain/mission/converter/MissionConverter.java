package com.example.umc.domain.mission.converter;

import com.example.umc.domain.mission.dto.MissionPageDTO;
import com.example.umc.domain.mission.dto.MissionResDTO;
import com.example.umc.domain.mission.entity.MemberMission;
import com.example.umc.domain.mission.enums.MissionStatus;

public class MissionConverter {
    public static MissionResDTO.updateMissionStatus toUpdateMissionStatusResult(MemberMission MM) {
        return MissionResDTO.updateMissionStatus.builder()
                .memberMissionId(MM.getId())
                .missionName(MM.getMission().getTitle())
                .status(MM.getStatus().name())
                .EarnedPoint(MM.getEarnedPoints())
                .build();
    }

    public static MissionResDTO.MissionItem toMissionItem(MemberMission mm) {
        return MissionResDTO.MissionItem.builder()
                .memberMissionId(mm.getId())
                .storeId(mm.getMission().getStore().getId())
                .storeName(mm.getMission().getStore().getName())
                .rewardPoint(mm.getMission().getRewardPoint())
                .missionContent(mm.getMission().getContent())
                .status(mm.getStatus().name())          // (예: IN_PROGRESS, COMPLETED)
                .isCompleted(mm.getStatus()== MissionStatus.SUCCESS)       // Boolean
                .endAt(mm.getMission().getEndAt())
                .build();
    }

    public static MissionResDTO.MissionPageResult toMissionPageResult(MissionPageDTO dto) {
        return MissionResDTO.MissionPageResult.builder()
                .inProgressMissions(dto.getInProgressMissions())
                .completedMissions(dto.getCompletedMissions())
                .build();
    }

}

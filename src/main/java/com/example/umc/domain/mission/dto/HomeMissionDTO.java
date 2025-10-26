package com.example.umc.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class HomeMissionDTO {
    private String location;
    private Integer rewardedPoints;

    private Integer completedMissions;
    private Integer totalMissionCount;

    private List<MissionInfoDTO> missionList;
}

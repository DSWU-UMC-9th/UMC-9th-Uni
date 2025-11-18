package com.example.umc.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MissionPageDTO {
    private List<MissionResDTO.MissionItem> inProgressMissions;
    private List<MissionResDTO.MissionItem> completedMissions;
}

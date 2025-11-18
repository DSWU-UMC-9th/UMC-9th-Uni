package com.example.umc.domain.mission.dto;

import com.example.umc.domain.mission.enums.MissionStatus;
import com.example.umc.domain.store.enums.StoreType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MissionInfoDTO {
    private String storeName;
    private Integer rewardPoint;
    private MissionStatus status;
    private String missionDescription;
}

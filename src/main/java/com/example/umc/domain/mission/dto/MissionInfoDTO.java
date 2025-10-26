package com.example.umc.domain.mission.dto;

import com.example.umc.domain.store.enums.StoreType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class MissionInfoDTO {
    private Long missionId;
    private String storeName;
    private StoreType storeType;
    private String deadLine;
    private String condition;
    private Integer rewardPoint;
}

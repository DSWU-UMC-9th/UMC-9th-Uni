package com.example.umc.domain.mission.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

public class MissionResDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class updateMissionStatus {
        private Long memberMissionId;
        private String missionName;
        private String status;
        private Integer EarnedPoint;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionItem {
        private Long memberMissionId;
        private Long storeId;
        private String storeName;
        private Integer rewardPoint;
        private String missionContent;
        private String status;
        private Boolean isCompleted;
        private LocalDateTime endAt;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionListResponse {
        private List<MissionItem> missions;
        private Integer totalCount;
        private Integer completedCount;
        private Integer challengingCount;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionPageDTO {
        private List<MissionItem> inProgressMissions;  // 진행 중
        private List<MissionItem> completedMissions;   // 완료
        private Integer totalCount;
        private Integer completedCount;
        private Integer challengingCount;
    }

    @Builder
    @Getter
    public static class MissionPageResult {
        private List<MissionResDTO.MissionItem> inProgressMissions;
        private List<MissionResDTO.MissionItem> completedMissions;
    }

    @Builder
    @Getter
    public static class ChallengeResult {
        Long memberMissionId;
        String missionTitle;
        String status; // PROGRESSING
    }

    @Builder
    public record MissionPageDTO (
            List<MissionResDTO.MissionItem> inProgressMissions,
            List<MissionResDTO.MissionItem> completedMissions
    ) {}

    @Builder
    public record MissionPreViewListDTO(
            List<MissionResDTO.MissionItem> missionList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}

    @Builder
    public record MyMissionListDTO(
            MissionPageDTO missions, // 목록 데이터 (진행중, 완료 리스트 포함)
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ) {}
}

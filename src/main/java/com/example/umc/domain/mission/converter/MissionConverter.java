package com.example.umc.domain.mission.converter;

import com.example.umc.domain.mission.dto.MissionResDTO;
import com.example.umc.domain.mission.entity.MemberMission;
import com.example.umc.domain.mission.entity.Mission;
import com.example.umc.domain.mission.enums.MissionStatus;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResDTO.MissionPageDTO toMissionPageDTO(
            Page<MemberMission> inProgressPage,
            Page<MemberMission> completedPage) {
        return MissionResDTO.MissionPageDTO.builder()
                .inProgressMissions(inProgressPage.getContent().stream() // 진행 중 목록 변환
                        .map(MissionConverter::toMissionItem)
                        .toList())
                .completedMissions(completedPage.getContent().stream() // 완료 목록 변환
                        .map(MissionConverter::toMissionItem)
                        .toList())
                .build();
    }

    public static MissionResDTO.MyMissionListDTO toMyMissionListDTO(
            Page<MemberMission> inProgressPage,
            Page<MemberMission> completedPage
    ) {
        // 1. 진행 중 리스트 변환
        List<MissionResDTO.MissionItem> inProgressList = inProgressPage.getContent().stream()
                .map(MissionConverter::toMissionItem)
                .toList();

        // 2. 완료 리스트 변환
        List<MissionResDTO.MissionItem> completedList = completedPage.getContent().stream()
                .map(MissionConverter::toMissionItem)
                .toList();

        // 3. 내용물 DTO 생성
        MissionResDTO.MissionPageDTO missionPageDTO = MissionResDTO.MissionPageDTO.builder()
                .inProgressMissions(inProgressList)
                .completedMissions(completedList)
                .build();

        return MissionResDTO.MyMissionListDTO.builder()
                .missions(missionPageDTO) // 여기에는 List가 아니라 단일 객체가 들어갑니다.
                .listSize(inProgressPage.getSize())
                .totalPage(inProgressPage.getTotalPages())
                .totalElements(inProgressPage.getTotalElements())
                .isFirst(inProgressPage.isFirst())
                .isLast(inProgressPage.isLast())
                .build();
    }

    public static MissionResDTO.ChallengeResult toChallengeResult(MemberMission mm) {
        return MissionResDTO.ChallengeResult.builder()
                .memberMissionId(mm.getId())
                .missionTitle(mm.getMission().getTitle())
                .status(mm.getStatus().name())
                .build();
    }

    // 특정 가게 미션 조회
    public static MissionResDTO.MissionPreViewListDTO toMissionPreViewListDTO(Page<Mission> missionPage) {
        List<MissionResDTO.MissionItem> missionItems = missionPage.getContent().stream()
                .map(mission -> MissionResDTO.MissionItem.builder()
                        .storeId(mission.getStore().getId())
                        .storeName(mission.getStore().getName())
                        .rewardPoint(mission.getRewardPoint())
                        .missionContent(mission.getContent())
                        .endAt(mission.getEndAt())
                        .build())
                .collect(Collectors.toList());

        // 빌더 패턴을 사용하여 최종 응답 DTO 생성
        return MissionResDTO.MissionPreViewListDTO.builder()
                .missionList(missionItems)
                .listSize(missionPage.getNumberOfElements())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }
}


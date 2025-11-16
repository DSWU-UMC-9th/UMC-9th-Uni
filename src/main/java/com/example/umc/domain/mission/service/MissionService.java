package com.example.umc.domain.mission.service;

import com.example.umc.domain.mission.converter.MissionConverter;
import com.example.umc.domain.mission.dto.MissionPageDTO;
import com.example.umc.domain.mission.entity.MemberMission;
import com.example.umc.domain.mission.enums.MissionStatus;
import com.example.umc.domain.mission.repository.MemberMissionRepository;
import com.example.umc.domain.mission.repository.MissionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Transactional
    public MemberMission completeMission(Long memberMissionId) {
        MemberMission memberMission = memberMissionRepository.findById(memberMissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 미션을 찾을 수 없습니다."));

        if (memberMission.getStatus() == MissionStatus.SUCCESS) {
            throw new IllegalStateException("이미 완료된 미션입니다.");
        }

        return memberMission;
    }

    // 진행 중인 미션 리스트
    public MissionPageDTO getMyMissionPage(Long memberId) {

        List<MemberMission> inProgress = memberMissionRepository
                .findAllByMemberIdAndStatus(memberId, MissionStatus.PROGRESSING);

        List<MemberMission> completed = memberMissionRepository
                .findAllByMemberIdAndStatus(memberId, MissionStatus.SUCCESS);

        return MissionPageDTO.builder()
                .inProgressMissions(inProgress.stream()
                        .map(MissionConverter::toMissionItem)   // 수정
                        .toList())
                .completedMissions(completed.stream()
                        .map(MissionConverter::toMissionItem)  // 수정
                        .toList())
                .build();
    }
}

package com.example.umc.domain.mission.repository;

import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.mission.dto.MyMissionDTO;
import com.example.umc.domain.mission.entity.MemberMission;
import com.example.umc.domain.mission.entity.Mission;
import com.example.umc.domain.mission.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    List<MemberMission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status);
    boolean existsByMemberAndMissionAndStatus(Member member, Mission mission, MissionStatus status);
}

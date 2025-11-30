package com.example.umc.domain.mission.repository;

import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.mission.entity.MemberMission;
import com.example.umc.domain.mission.entity.Mission;
import com.example.umc.domain.mission.enums.MissionStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    Page<MemberMission> findAllByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable);
    boolean existsByMemberAndMissionAndStatus(Member member, Mission mission, MissionStatus status);
}

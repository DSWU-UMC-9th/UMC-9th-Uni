package com.example.umc.domain.mission.repository;

import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.mission.dto.MissionInfoDTO;
import com.example.umc.domain.mission.entity.Mission;
import com.example.umc.domain.mission.enums.MissionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    @Query("SELECT new com.example.umc.domain.mission.dto.MissionInfoDTO(" +
            "mm.mission.store.name, mm.mission.rewardPoint, mm.status, mm.mission.content) " +
            "FROM MemberMission mm " +
            "WHERE mm.member = :member AND mm.status IN :statuses")
    List<MissionInfoDTO> findChallengingMissionByMemberAndStatus(@Param("member") Member member, @Param("status") MissionStatus status);
}

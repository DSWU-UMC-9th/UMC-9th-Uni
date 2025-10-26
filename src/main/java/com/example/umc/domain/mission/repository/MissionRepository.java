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
            "mm.mission.id, mm.mission.title, mm.mission.store.storeType, " +
            "FUNCTION('DATEDIFF', mm.mission.endAt, CURRENT_TIMESTAMP()), " +
            "mm.mission.content, mm.mission.rewardPoint, TRUE) " +
            "FROM MemberMission mm " +
            "WHERE mm.member = :member AND mm.status = :status")
    List<MissionInfoDTO> findChallengingMissionByMemberAndStatus(@Param("member") Member member, @Param("status") MissionStatus status);

    long countByMember(Member member);
    long countByMemberAndStatus(Member member, MissionStatus status);
}

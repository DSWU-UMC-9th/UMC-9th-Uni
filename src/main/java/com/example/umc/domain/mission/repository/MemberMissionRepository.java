package com.example.umc.domain.mission.repository;

import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.mission.dto.MyMissionDTO;
import com.example.umc.domain.mission.entity.MemberMission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    @Query("SELECT new com.example.umc.domain.mission.dto.MyMissionDTO(" +
            "mm.id, " + "mm.mission.store.id, " + "mm.mission.store.name, " +
            "mm.earnedPoints, " + "mm.mission.content, " + "mm.status, " +
            "CASE WHEN mm.status = 'COMPLETED' THEN TRUE ELSE FALSE END) " +
            "FROM MemberMission mm " +
            "WHERE mm.member = :member ORDER BY mm.id DESC")
    List<MyMissionDTO> findMyMissionByMember(@Param("member")Member member);
}

package com.example.umc.domain.member.repository;

import com.example.umc.domain.member.dto.MyPageDTO;
import com.example.umc.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MemberRepository extends JpaRepository<Member,Long> {
    @Query("SELECT new com.example.umc.domain.member.dto.MyPageDTO(" +
            "m.nickname, m.email, m.phoneNum, m.points) " +
            "FROM Member m " +
            "WHERE m.id = :memberId")
    MyPageDTO findMypageInfo(@Param("memberId") Long memberId);
}

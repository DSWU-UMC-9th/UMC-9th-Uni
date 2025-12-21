package com.example.umc.domain.member.repository;

import com.example.umc.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email); // 로그인 시 유저 찾기
    boolean existsByEmail(String email);
}

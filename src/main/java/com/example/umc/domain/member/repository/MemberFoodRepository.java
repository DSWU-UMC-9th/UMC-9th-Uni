package com.example.umc.domain.member.repository;

import com.example.umc.domain.member.entity.MemberFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberFoodRepository extends JpaRepository<MemberFood,Long> {
}

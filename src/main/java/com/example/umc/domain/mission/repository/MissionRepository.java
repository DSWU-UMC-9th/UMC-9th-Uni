package com.example.umc.domain.mission.repository;

import com.example.umc.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    Page<Mission> findAllByStoreId(Long storeId, Pageable pageable);}

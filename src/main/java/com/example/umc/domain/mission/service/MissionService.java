package com.example.umc.domain.mission.service;

import com.example.umc.domain.mission.dto.MissionResDTO;
import com.example.umc.domain.mission.entity.MemberMission;



public interface MissionService {
    MemberMission completeMission(Long memberMissionId);
    MissionResDTO.MyMissionListDTO getMyMissionPage(Long memberId, Integer page);
    MissionResDTO.ChallengeResult challengeMission(Long memberId, Long missionId);
    MissionResDTO.MissionPreViewListDTO getMissionsByStore(Long storeId, Integer page)
        ;
}

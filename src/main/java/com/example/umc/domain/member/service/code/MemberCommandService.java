package com.example.umc.domain.member.service.code;

import com.example.umc.domain.member.dto.MemberReqDTO;
import com.example.umc.domain.member.dto.MemberResDTO;
import com.example.umc.domain.member.dto.MyPageDTO;

public interface MemberCommandService {
    MemberResDTO.RegisterDTO register(MemberReqDTO.RegisterDTO dto);
    public MyPageDTO getMyPageInfo(Long memberId);
}

package com.example.umc.domain.member.service.code;

import com.example.umc.domain.member.dto.MemberReqDTO;
import com.example.umc.domain.member.dto.MemberResDTO;
import jakarta.servlet.http.HttpSession;

public interface MemberCommandService {
    MemberResDTO.LoginDTO login(MemberReqDTO.LoginDTO dto, HttpSession session);
    MemberResDTO.RegisterDTO register(MemberReqDTO.RegisterDTO dto);
    void logout();
}

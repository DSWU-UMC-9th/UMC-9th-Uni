package com.example.umc.domain.member.controller;

import com.example.umc.domain.member.code.MemberSuccessCode;
import com.example.umc.domain.member.dto.MemberReqDTO;
import com.example.umc.domain.member.dto.MemberResDTO;
import com.example.umc.domain.member.dto.MyPageDTO;
import com.example.umc.domain.member.service.code.MemberCommandService;
import com.example.umc.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private MemberCommandService memberCommandService;

    @PostMapping("/register")
    public ApiResponse<MemberResDTO.RegisterDTO> register(
            @RequestBody MemberReqDTO.RegisterDTO dto
            ) {
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberCommandService.register(dto));
    }

    @GetMapping("/mypage")
    public ApiResponse<MyPageDTO> getMyPageForCurrentUser(Long memberId) {

        MyPageDTO myPageDTO = memberCommandService.getMyPageInfo(memberId);
        return ApiResponse.onSuccess(MemberSuccessCode.SUCCESS_GET_MYPAGE, myPageDTO);
    }
}

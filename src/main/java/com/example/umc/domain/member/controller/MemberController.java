package com.example.umc.domain.member.controller;

import com.example.umc.domain.member.code.MemberSuccessCode;
import com.example.umc.domain.member.dto.MyPageDTO;
import com.example.umc.domain.member.service.MemberService;
import com.example.umc.global.apiPayload.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private MemberService memberService;

    @GetMapping("/mypage")
    public ApiResponse<MyPageDTO> getMyPageForCurrentUser(Long memberId) {

        MyPageDTO myPageDTO = memberService.getMyPageInfo(memberId);
        return ApiResponse.onSuccess(MemberSuccessCode.SUCCESS_GET_MYPAGE, myPageDTO);
    }
}

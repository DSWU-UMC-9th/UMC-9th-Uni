package com.example.umc.domain.member.controller;

import com.example.umc.domain.member.code.MemberSuccessCode;
import com.example.umc.domain.member.dto.MemberReqDTO;
import com.example.umc.domain.member.dto.MemberResDTO;
import com.example.umc.domain.member.service.code.MemberCommandService;
import com.example.umc.global.apiPayload.ApiResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/register")
    public ApiResponse<MemberResDTO.RegisterDTO> register(
            @RequestBody @Valid MemberReqDTO.RegisterDTO dto
            ) {
        return ApiResponse.onSuccess(MemberSuccessCode.FOUND, memberCommandService.register(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<MemberResDTO.LoginDTO>> login(
            @RequestBody MemberReqDTO.LoginDTO dto,
            HttpSession session
    ) {

        MemberResDTO.LoginDTO response = memberCommandService.login(dto, session);

        return ResponseEntity
                .status(MemberSuccessCode.AUTH_LOGIN_SUCCESS.getStatus())
                .body(ApiResponse.onSuccess(MemberSuccessCode.AUTH_LOGIN_SUCCESS, response));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(HttpSession session) {

        memberCommandService.logout(session);

        return ResponseEntity
                .status(MemberSuccessCode.AUTH_LOGOUT_SUCCESS.getStatus())
                .body(ApiResponse.onSuccess(MemberSuccessCode.AUTH_LOGOUT_SUCCESS, "로그아웃 성공"));
    }
    /**
    @GetMapping("/mypage")
    public ApiResponse<MyPageDTO> getMyPageForCurrentUser(Long memberId) {

        MyPageDTO myPageDTO = memberCommandService.getMyPageInfo(memberId);
        return ApiResponse.onSuccess(MemberSuccessCode.SUCCESS_GET_MYPAGE, myPageDTO);
    }
    */
}

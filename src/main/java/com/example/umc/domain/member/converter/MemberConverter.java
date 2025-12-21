package com.example.umc.domain.member.converter;

import com.example.umc.domain.member.dto.MemberReqDTO;
import com.example.umc.domain.member.dto.MemberResDTO;
import com.example.umc.domain.member.entity.Member;

import java.time.LocalDateTime;

public class MemberConverter {

    // 회원가입 응답 DTO로 변환
    public static MemberResDTO.RegisterDTO toJoinDTO(Member member) {
        return MemberResDTO.RegisterDTO.builder()
                .memberId(member.getId())
                .name(member.getName())
                .nickname(member.getNickname())
                .email(member.getEmail())
                .build();
    }

    // 회원가입 요청 DTO -> Entity 변환
    // (비밀번호는 Service에서 암호화한 후 넘겨주어야 합니다)
    public static Member toMember(MemberReqDTO.RegisterDTO dto, String encodedPassword) {
        return Member.builder()
                .name(dto.name())
                .email(dto.email())
                .password(encodedPassword) // 암호화된 비밀번호 주입
                .nickname(dto.nickname())
                .gender(dto.gender())
                .birth(dto.birth())
                .address(dto.address())
                .phoneNum(dto.phonenum())
                .points(0) // 초기 포인트 설정 (필요 시)
                .build();
    }

    // 로그인 응답 DTO로 변환
    public static MemberResDTO.LoginDTO toLoginDTO(Member member) {
        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .build();
    }
}
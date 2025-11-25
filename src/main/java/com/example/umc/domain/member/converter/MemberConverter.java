package com.example.umc.domain.member.converter;

import com.example.umc.domain.member.dto.MemberReqDTO;
import com.example.umc.domain.member.dto.MemberResDTO;
import com.example.umc.domain.member.dto.MyPageDTO;
import com.example.umc.domain.member.entity.Member;

public class MemberConverter {
    public static MemberResDTO.RegisterDTO toJoinDTO(
            Member member
    ){
        return MemberResDTO.RegisterDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(
            MemberReqDTO.RegisterDTO dto
    ){
        return Member.builder()
                .name(dto.name())
                .birth(dto.birth())
                .address(dto.address())
                .gender(dto.gender())
                .build();
    }

    public static MyPageDTO toMyPageDTO(Member member) {
        return new MyPageDTO(
                member.getNickname(),
                member.getEmail(),
                member.getPhoneNum(),
                member.getPoints()
        );
    }
}

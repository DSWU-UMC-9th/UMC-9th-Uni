package com.example.umc.domain.member.service.code;

import com.example.umc.domain.member.code.MemberErrorCode;
import com.example.umc.domain.member.dto.MemberReqDTO;
import com.example.umc.domain.member.dto.MemberResDTO;
import com.example.umc.domain.member.entity.Member;
import com.example.umc.domain.member.exception.MemberException;
import com.example.umc.domain.member.repository.MemberRepository;
import com.example.umc.global.apiPayload.exception.GeneralException;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    // 회원가입
    @Transactional
    public MemberResDTO.RegisterDTO register(MemberReqDTO.RegisterDTO dto) {

        if (memberRepository.existsByEmail(dto.email())) {
            throw new MemberException(MemberErrorCode.USER_SIGNUP_FAILED);
        }

        Member member = Member.builder()
                .name(dto.name())
                .email(dto.email())
                .password(passwordEncoder.encode(dto.password()))
                .nickname(dto.nickname())
                .gender(dto.gender())
                .birth(dto.birth())
                .address(dto.address())
                .phoneNum(dto.phonenum())
                .build();

        Member saved = memberRepository.save(member);

        return MemberResDTO.RegisterDTO.builder()
                .memberId(saved.getId())
                .name(saved.getName())
                .nickname(saved.getNickname())
                .email(saved.getEmail())
                .build();
    }

    // 로그인
    public MemberResDTO.LoginDTO login(MemberReqDTO.LoginDTO dto, HttpSession session) {

        Member member = memberRepository.findByEmail(dto.email())
                .orElseThrow(() -> new MemberException(MemberErrorCode.USER_LOGIN_FAILED));

        if (!passwordEncoder.matches(dto.password(), member.getPassword())) {
            throw new GeneralException(MemberErrorCode.USER_LOGIN_FAILED);
        }

        // 세션 저장
        session.setAttribute("LOGIN_USER", member.getId());

        return MemberResDTO.LoginDTO.builder()
                .memberId(member.getId())
                .nickname(member.getNickname())
                .build();
    }

    // 로그아웃
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
package com.example.umc.global.security;


import com.example.umc.domain.member.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class CustomUserDetails implements UserDetails {

    private final Member member; // 너의 User 엔티티!

    public CustomUserDetails(Member member) {
        this.member = member;
    }

    public Member getUser() {
        return member;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 없으면 빈 리스트 리턴
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

}

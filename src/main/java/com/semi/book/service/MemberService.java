package com.semi.book.service;

import com.semi.book.common.jwt.JwtTokenProvider;
import com.semi.book.domain.Member;
import com.semi.book.dto.TokenInfo;
import com.semi.book.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void join(Member member){
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public TokenInfo login(String memberId, String password) {
        // 1. Login ID/PW 를 기반으로 Authentication 객체 생성
        // 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(memberId, password);
        // 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
        // authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드가 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);
        return tokenInfo;
    }

    @Transactional(readOnly = true)
    public String findId(Member member) {
        Member m = memberRepository.findByNameAndEmail(member.getName(),member.getEmail()).orElse(null);
        if (m == null) {
            return "Wrong Name or Email";
        }
        return m.getUserId();
    }
    @Transactional(readOnly = true)
    public String findPwd(Member member) {
        Member m = memberRepository.findByUserIdAndEmail(member.getUserId(),member.getEmail()).orElse(null);
        if (m == null){
            return "Wrong Id or Email";
        }
        return m.getPassword();
    }


}

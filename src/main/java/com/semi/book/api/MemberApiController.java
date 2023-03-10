package com.semi.book.api;

import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.dto.MemberLoginRequestDTO;
import com.semi.book.dto.MemberMapper;
import com.semi.book.dto.TokenInfo;
import com.semi.book.repository.MemberRepository;
import com.semi.book.repository.mapping.MemberColumnMapping;
import com.semi.book.service.MemberService;
import com.semi.book.service.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberApiController {
    @Autowired
    private final MemberRepository memberRepository;
    @Autowired
    private final MemberService memberService;

    @PostMapping("/post/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDTO memberLoginRequestDto) {
        TokenInfo tokenInfo = null;
        try {
            String memberId = memberLoginRequestDto.getUserId();
            String password = memberLoginRequestDto.getPassword();
            tokenInfo = memberService.login(memberId, password);
        } catch (Exception e) {
            System.out.println(e);
        }
        return tokenInfo;
    }
    @PostMapping("/post/member")
    public String postMember(@RequestBody MemberDTO memberDTO){
        memberDTO.setState("ON");
        memberDTO.setGrade("NORMAL");
        List<String> roles = new ArrayList<>(Arrays.asList("USER"));
        memberDTO.setRoles(roles);
        try {
            Member member = MemberMapper.INSTANCE.dtoToMember(memberDTO);
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e);
            return "0";
        }
        return "1";
    }
    @PostMapping("/post/findId")
    public MemberColumnMapping findId(@RequestBody MemberDTO memberDTO){
        Member member = MemberMapper.INSTANCE.dtoToMember(memberDTO);
        return memberService.findId(member);
    }
    @PostMapping("/post/findPwd")
    public String findPwd(@RequestBody MemberDTO memberDTO){
        Member member = MemberMapper.INSTANCE.dtoToMember(memberDTO);
        return memberService.findPwd(member);
    }

    @GetMapping("/get/token")
    public String getToken(){
        String userId = SecurityUtil.getCurrentMemberId();
        return  userId;
    }
}

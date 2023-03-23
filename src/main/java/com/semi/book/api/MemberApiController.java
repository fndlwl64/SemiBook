package com.semi.book.api;

import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.dto.MemberLoginRequestDTO;
import com.semi.book.dto.MemberMapper;
import com.semi.book.dto.TokenInfo;
import com.semi.book.repository.MemberRepository;
import com.semi.book.service.MemberService;
import com.semi.book.service.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
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
    public ResponseEntity<Boolean> postMember(@RequestBody MemberDTO memberDTO){
        memberDTO.setState("ON");
        memberDTO.setGrade("NORMAL");
        List<String> roles = new ArrayList<>(Arrays.asList("USER"));
        memberDTO.setRoles(roles);
        memberService.join(memberDTO);
        return  ResponseEntity.ok(true);

    }
    @PostMapping("/get/findId")
    public MemberDTO.MemberUserId findId(@RequestBody MemberDTO memberDTO){
        MemberDTO.MemberUserId memberUserId = memberService.findId(memberDTO);
        return memberUserId;
    }
    @PostMapping("/get/findPwd")
    public MemberDTO.MemberPassword findPwd(@RequestBody MemberDTO memberDTO){
        MemberDTO.MemberPassword memberPassword = memberService.findPwd(memberDTO);
        return memberPassword;
    }

    @GetMapping("/get/token")
    public String getToken(){
        String userId = SecurityUtil.getCurrentMemberId();
        return  userId;
    }
}

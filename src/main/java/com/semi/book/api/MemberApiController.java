package com.semi.book.api;

import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.dto.MemberLoginRequestDTO;
import com.semi.book.dto.MemberMapper;
import com.semi.book.dto.TokenInfo;
import com.semi.book.repository.MemberRepository;
import com.semi.book.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
//@EnableWebMvc
public class MemberApiController {
    @Autowired
    private final MemberRepository memberRepository;

    @Autowired
    private final MemberService memberService;

    @PostMapping("/post/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDTO memberLoginRequestDto) {
        String memberId = memberLoginRequestDto.getUserId();
        String password = memberLoginRequestDto.getPassword();
        TokenInfo tokenInfo = memberService.login(memberId, password);
        return tokenInfo;
    }
    @PostMapping("/post/member")
    public String postMember(@RequestBody MemberDTO memberDTO){
        memberDTO.setState("ON");
        memberDTO.setGrade("NORMAL");

        System.out.println(memberDTO.toString());

        try {
            Member member = MemberMapper.INSTANCE.dtoToMember(memberDTO);
            System.out.println(member.toString());
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e);
            return "0";
        }
        return "1";
    }
}

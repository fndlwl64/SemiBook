package com.semi.book.api;

import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberApiController {
    private final MemberRepository memberRepository;
    @PostMapping("/get/member")
    public MemberDTO getMember(@RequestBody MemberDTO memberDTO){
        System.out.println("memberDTO.toString() = " + memberDTO.toString());
        return memberDTO;
    }
    @GetMapping("/get/member/content")
    public List<Member> getMemberContent(){
        return memberRepository.findAll();
    }
}

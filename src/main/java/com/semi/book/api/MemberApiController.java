package com.semi.book.api;

import com.semi.book.domain.Member;
import com.semi.book.dto.MemberDTO;
import com.semi.book.dto.MemberMapper;
import com.semi.book.dto.User;
import com.semi.book.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@RequiredArgsConstructor
//@EnableWebMvc
public class MemberApiController {
    @Autowired
    private final MemberRepository memberRepository;

    @PostMapping("/post/login")
    public String postLogin(@RequestBody User user){
        Member member = memberRepository.findByUserId(user.getUserId());

        if(member == null){
            System.out.println("ID FAIL");
            return "0";
        }

        if(!member.getPassword().equals(user.getPassword())){
            System.out.println("PASSWORD FAIL");
            return "0";
        }

        return "1";
    }
    @PostMapping("/post/member")
    public String postMember(@RequestBody MemberDTO memberDTO){
        memberDTO.setState("ON");
        memberDTO.setGrade("NORMAL");
        try {
            Member member = MemberMapper.INSTANCE.dtoToMember(memberDTO);
            memberRepository.save(member);
        }catch (Exception e){
            System.err.println(e);
            return "0";
        }
        return "1";
    }
}

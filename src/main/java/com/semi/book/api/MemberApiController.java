package com.semi.book.api;

import com.semi.book.dto.MemberDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberApiController {
    @PostMapping("/get/member")
    public MemberDTO getMember(@RequestBody MemberDTO memberDTO){
        System.out.println("memberDTO.toString() = " + memberDTO.toString());
        return memberDTO;
    }
}

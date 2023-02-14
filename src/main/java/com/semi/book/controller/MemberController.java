package com.semi.book.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.semi.book.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {

    @GetMapping("login")
    public String login(){
        return "member/login";
    }
    @GetMapping("join")
    public String join(){
        return "member/join";
    }
    @PostMapping("join")
    public String login(Member member){
        return "redirect:/login";
    }

    @GetMapping("main")
    public String main(){
        return "main/main";
    }
}

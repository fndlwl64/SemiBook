package com.semi.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
    @GetMapping("login")
    public String login(){
        return "member/login.html";
    }
}

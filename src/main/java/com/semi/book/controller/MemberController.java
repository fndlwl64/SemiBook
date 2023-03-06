package com.semi.book.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.semi.book.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/*Html 페이지 요청*/
@Controller
public class MemberController {

    @GetMapping("/user/{name}")
    public String user(@PathVariable("name") String name){
        return "/member/"+name;
    }
    @GetMapping("/web/main/{name}")
    public String main(@PathVariable("name") String name){
        return "/main/"+name;
    }
}

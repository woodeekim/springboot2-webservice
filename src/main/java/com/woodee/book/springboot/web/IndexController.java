package com.woodee.book.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    //글 등록 화면으로 이동
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}

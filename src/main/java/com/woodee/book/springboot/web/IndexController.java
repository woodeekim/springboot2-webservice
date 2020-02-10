package com.woodee.book.springboot.web;

import com.woodee.book.springboot.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    //글 리스트 조회
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts",postsService.findAllDesc());
        return "index";
    }

    //글 등록 화면으로 이동
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }


}

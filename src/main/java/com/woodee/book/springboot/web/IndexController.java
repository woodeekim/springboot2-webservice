package com.woodee.book.springboot.web;

import com.woodee.book.springboot.config.auth.dto.SessionUser;
import com.woodee.book.springboot.domain.user.User;
import com.woodee.book.springboot.service.PostsService;
import com.woodee.book.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    //글 리스트 조회
    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("posts",postsService.findAllDesc());

        SessionUser user = (SessionUser)httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    //글 등록 화면으로 이동
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    //글 수정
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);

        return "posts-update";
    }

}

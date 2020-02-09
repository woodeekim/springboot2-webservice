package com.woodee.book.springboot.web.dto;

import com.woodee.book.springboot.domain.posts.Posts;
import com.woodee.book.springboot.domain.posts.PostsRepository;
import javafx.geometry.Pos;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
public class PostsRepositoryTest {

    @Autowired
    private PostsRepository postsRepository;

    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2020,2,10,0,0,0);
        postsRepository.save(Posts.builder()
            .title("title")
            .content("content")
            .author("author")
            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>createDate="+posts.getCreateDate()+", modifiedDate="+posts.getModifiedDate());
        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);

    }
}

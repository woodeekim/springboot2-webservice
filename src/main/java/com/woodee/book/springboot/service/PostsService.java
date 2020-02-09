package com.woodee.book.springboot.service;


import com.woodee.book.springboot.domain.posts.Posts;
import com.woodee.book.springboot.domain.posts.PostsRepository;
import com.woodee.book.springboot.web.dto.PostsResponseDto;
import com.woodee.book.springboot.web.dto.PostsSaveRequestDto;
import com.woodee.book.springboot.web.dto.PostsUpdateRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    //등록
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    //수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestsDto requestsDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestsDto.getTitle(), requestsDto.getContent());

        return id;
    }

    //조회
    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 사용자가 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }


}

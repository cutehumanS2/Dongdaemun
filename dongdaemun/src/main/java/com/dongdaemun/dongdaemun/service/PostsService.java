package com.dongdaemun.dongdaemun.service;


import com.dongdaemun.dongdaemun.web.dto.PostsSaveRequestDto;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import com.dongdaemun.dongdaemun.domain.posts.PostsRepository;
import com.dongdaemun.dongdaemun.web.dto.PostsListResponseDto;
import com.dongdaemun.dongdaemun.web.dto.PostsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Posts save(PostsSaveRequestDto requestDto){ //Long -> Posts로 바꾸면 되나.. getId() 지우고?
        return postsRepository.save(requestDto.toEntity());
    }

    @Transactional
    public Posts update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return posts.update(requestDto.getTitle(), requestDto.getContent());
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    /*
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }*/

    @Transactional
    public Page<Posts> list(int page){
        return postsRepository.findAll(PageRequest.of(page,3,Sort.by(Sort.Direction.DESC, "id")));
    }

    @Transactional
    public void delete (Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);
    }
}
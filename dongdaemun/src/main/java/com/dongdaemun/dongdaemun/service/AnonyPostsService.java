package com.dongdaemun.dongdaemun.service;

import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPostsRepository;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import com.dongdaemun.dongdaemun.web.dto.PostsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.PostsSaveRequestDto;
import com.dongdaemun.dongdaemun.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class AnonyPostsService {

    private final AnonyPostsRepository anonyPostsRepository;

    @Transactional
    public AnonyPosts save(PostsSaveRequestDto requestDto){ //Long -> Posts로 바꾸면 되나.. getId() 지우고?
        return anonyPostsRepository.save(requestDto.toEntityAnony());
    }

    @Transactional
    public AnonyPosts update(Long id, PostsUpdateRequestDto requestDto){
        AnonyPosts posts = anonyPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return posts.update(requestDto.getTitle(), requestDto.getContent());
    }

    public PostsResponseDto findById (Long id){
        AnonyPosts entity = anonyPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional
    public Page<AnonyPosts> list(int page){
        return anonyPostsRepository.findAll(PageRequest.of(page,3, Sort.by(Sort.Direction.DESC, "id")));
    }

    @Transactional
    public void delete (Long id) {
        AnonyPosts posts = anonyPostsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        anonyPostsRepository.delete(posts);
    }

}
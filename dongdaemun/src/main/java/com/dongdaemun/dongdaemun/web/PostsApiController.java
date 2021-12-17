package com.dongdaemun.dongdaemun.web;

import com.dongdaemun.dongdaemun.config.auth.LoginUser;
import com.dongdaemun.dongdaemun.config.auth.dto.SessionUser;
import com.dongdaemun.dongdaemun.service.PostsService;
import com.dongdaemun.dongdaemun.web.dto.PostsListResponseDto;
import com.dongdaemun.dongdaemun.web.dto.PostsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    /*게시글 수정*/
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    /*게시글 조회*/
    @GetMapping("/postview/{category}/{id}")
    public PostsResponseDto postview(@PathVariable String category, @PathVariable Long id){
        if(category.compareTo("notice")==0) return postsService.findById(id);
        else return null;
    }


    /*
    @GetMapping("/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){

        return postsService.findById(id);
    }

     */

    /*게시글 삭제*/
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}

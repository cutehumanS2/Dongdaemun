package com.dongdaemun.dongdaemun.web.dto.myPage;

import com.dongdaemun.dongdaemun.domain.comments.Comments;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import com.dongdaemun.dongdaemun.web.dto.comments.CommentsResponseDto;
import com.dongdaemun.dongdaemun.web.dto.posts.PostsResponseDto;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class MyProfileAndMyPostsAndMyCommentsResponseDto {

    private MyProfileResponseDto myProfileResponseDto;
    private Page<Posts> postsPage;
    private Page<Comments> commentsPage;

    public MyProfileAndMyPostsAndMyCommentsResponseDto(
            MyProfileResponseDto myProfileResponseDto,
            Page<Posts> postsPage,
            Page<Comments> commentsPage
    ){
        this.myProfileResponseDto=myProfileResponseDto;
        this.postsPage=postsPage;
        this.commentsPage=commentsPage;
    }

    public MyProfileAndMyPostsAndMyCommentsResponseDto(
            MyProfileResponseDto myProfileResponseDto,
            Page<Posts> postsPage,
            boolean isOnlyPosts
    ){
        this.myProfileResponseDto=myProfileResponseDto;
        this.postsPage=postsPage;
    }

    public MyProfileAndMyPostsAndMyCommentsResponseDto(
            MyProfileResponseDto myProfileResponseDto,
            Page<Comments> commentsPage
    ){
        this.myProfileResponseDto=myProfileResponseDto;
        this.commentsPage=commentsPage;
    }

    public MyProfileAndMyPostsAndMyCommentsResponseDto(
            MyProfileResponseDto myProfileResponseDto
    ){
        this.myProfileResponseDto=myProfileResponseDto;
    }

}
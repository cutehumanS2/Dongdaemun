package com.dongdaemun.dongdaemun.web.dto.posts;

import com.dongdaemun.dongdaemun.domain.comments.Comments;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsAndCommentsResponseDto {


    private Posts posts;
    private List<Comments> comments;

    public PostsAndCommentsResponseDto(Posts postsEntity, List<Comments> commentsEntity) {
        this.posts = postsEntity;
        this.comments = commentsEntity;
    }



}

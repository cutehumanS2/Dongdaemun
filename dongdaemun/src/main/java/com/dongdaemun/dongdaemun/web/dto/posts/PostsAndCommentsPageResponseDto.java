package com.dongdaemun.dongdaemun.web.dto.posts;

import com.dongdaemun.dongdaemun.domain.comments.Comments;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class PostsAndCommentsPageResponseDto {

    private Posts posts;
    private Page<Comments> commentsPage;

    public PostsAndCommentsPageResponseDto(Posts postsEntity, Page<Comments> commentsPageEntity) {
        this.posts=postsEntity;
        this.commentsPage=commentsPageEntity;
    }


}

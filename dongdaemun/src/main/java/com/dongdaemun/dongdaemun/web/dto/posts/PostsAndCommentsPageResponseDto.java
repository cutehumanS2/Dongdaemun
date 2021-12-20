package com.dongdaemun.dongdaemun.web.dto.posts;

import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class PostsAndCommentsPageResponseDto {
    private NoticePosts noticePosts;
    private Page<NoticeComments> commentsPage;

    public PostsAndCommentsPageResponseDto(NoticePosts postsEntity, Page<NoticeComments> commentsPageEntity) {
        this.noticePosts=postsEntity;
        this.commentsPage=commentsPageEntity;
    }
}

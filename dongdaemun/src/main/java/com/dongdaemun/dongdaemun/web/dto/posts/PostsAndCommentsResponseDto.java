package com.dongdaemun.dongdaemun.web.dto.posts;

import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsAndCommentsResponseDto {
    NoticePosts noticePosts;
    List<NoticeComments> noticeComments;

    public PostsAndCommentsResponseDto(NoticePosts postsEntity, List<NoticeComments> commentsEntity) {
        this.noticePosts = postsEntity;
        this.noticeComments = commentsEntity;
    }
}

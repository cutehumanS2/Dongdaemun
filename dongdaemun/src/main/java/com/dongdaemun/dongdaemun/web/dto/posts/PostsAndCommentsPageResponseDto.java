package com.dongdaemun.dongdaemun.web.dto.posts;

import com.dongdaemun.dongdaemun.domain.comments.ActivityComments;
import com.dongdaemun.dongdaemun.domain.comments.AnonyComments;
import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.posts.ActivityPosts;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import lombok.Getter;
import org.springframework.data.domain.Page;

@Getter
public class PostsAndCommentsPageResponseDto {
    private NoticePosts noticePosts;
    private Page<NoticeComments> noticeCommentsPage;

    private AnonyPosts anonyPosts;
    private Page<AnonyComments> anonyComments;

    private ActivityPosts activityPosts;
    private Page<ActivityComments> activityComments;

    public PostsAndCommentsPageResponseDto(NoticePosts postsEntity, Page<NoticeComments> commentsPageEntity) {
        this.noticePosts=postsEntity;
        this.noticeCommentsPage=commentsPageEntity;
    }

    public PostsAndCommentsPageResponseDto(AnonyPosts postsEntity, Page<AnonyComments> commentsPageEntity) {
        this.anonyPosts=postsEntity;
        this.anonyComments=commentsPageEntity;
    }

    public PostsAndCommentsPageResponseDto(ActivityPosts postsEntity, Page<ActivityComments> commentsPageEntity) {
        this.activityPosts=postsEntity;
        this.activityComments=commentsPageEntity;
    }
}

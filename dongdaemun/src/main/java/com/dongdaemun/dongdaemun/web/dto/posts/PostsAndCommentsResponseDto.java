package com.dongdaemun.dongdaemun.web.dto.posts;

import com.dongdaemun.dongdaemun.domain.comments.ActivityComments;
import com.dongdaemun.dongdaemun.domain.comments.AnonyComments;
import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.posts.ActivityPosts;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsAndCommentsResponseDto {
    private NoticePosts noticePosts;
    private List<NoticeComments> noticeComments;

    private AnonyPosts anonyPosts;
    private List<AnonyComments> anonyComments;

    private ActivityPosts activityPosts;
    private List<ActivityComments> activityComments;


    public PostsAndCommentsResponseDto(NoticePosts postsEntity, List<NoticeComments> commentsEntity) {
        this.noticePosts = postsEntity;
        this.noticeComments = commentsEntity;
    }

    public PostsAndCommentsResponseDto(AnonyPosts postsEntity, List<AnonyComments> commentsEntity) {
        this.anonyPosts = postsEntity;
        this.anonyComments = commentsEntity;
    }

    public PostsAndCommentsResponseDto(ActivityPosts postsEntity, List<ActivityComments> commentsEntity) {
        this.activityPosts = postsEntity;
        this.activityComments = commentsEntity;
    }

}

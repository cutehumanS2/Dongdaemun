package com.dongdaemun.dongdaemun.web.dto;

import com.dongdaemun.dongdaemun.domain.posts.ActivityPosts;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String uid;
    private String title;
    private String content;
    private boolean anony;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(NoticePosts entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.anony = entity.isAnony();
        this.modifiedDate = entity.getModifieDate();
    }

    public PostsListResponseDto(AnonyPosts entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.anony = entity.isAnony();
        this.modifiedDate = entity.getModifieDate();
    }

    public PostsListResponseDto(ActivityPosts entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.anony = entity.isAnony();
        this.modifiedDate = entity.getModifieDate();
    }

}
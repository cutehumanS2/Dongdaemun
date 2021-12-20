package com.dongdaemun.dongdaemun.web.dto;

import com.dongdaemun.dongdaemun.domain.posts.ActivityPosts;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String uid;
    private String title;
    private String content;
    private boolean anony;

    public PostsResponseDto(NoticePosts entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.anony = entity.isAnony();
    }

    public PostsResponseDto(AnonyPosts entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.anony = entity.isAnony();
    }

    public PostsResponseDto(ActivityPosts entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.anony = entity.isAnony();
    }

}
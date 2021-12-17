package com.dongdaemun.dongdaemun.web.dto;

import com.dongdaemun.dongdaemun.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String uid;
    private String title;
    private String content;
    private boolean anony;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.anony = entity.isAnony();
    }
}

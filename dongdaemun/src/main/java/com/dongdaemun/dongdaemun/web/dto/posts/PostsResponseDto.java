package com.dongdaemun.dongdaemun.web.dto.posts;

import com.dongdaemun.dongdaemun.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String uid;
    private String title;
    private String content;
    private String category;
    private boolean anony;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.uid = entity.getUid();
        this.title = entity.getTitle();
        this.category = entity.getCategory();
        this.content = entity.getContent();
        this.anony = entity.isAnony();
    }

}
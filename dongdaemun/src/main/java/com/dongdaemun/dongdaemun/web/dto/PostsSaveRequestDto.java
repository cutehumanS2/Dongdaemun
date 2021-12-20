package com.dongdaemun.dongdaemun.web.dto;

import com.dongdaemun.dongdaemun.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String uid;
    private boolean anony;

    @Builder
    public PostsSaveRequestDto(String title, String content, String uid, boolean anony){
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.anony = anony;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .uid(uid)
                .anony(anony)
                .build();
    }
}


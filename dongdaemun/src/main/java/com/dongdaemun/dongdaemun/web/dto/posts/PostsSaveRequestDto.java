package com.dongdaemun.dongdaemun.web.dto.posts;

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
    private String category;
    private boolean anony;

    @Builder
    public PostsSaveRequestDto(String title, String content, String uid, String category, boolean anony){
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.category = category;
        this.anony = anony;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .uid(uid)
                .category(category)
                .anony(anony)
                .build();
    }

}

package com.dongdaemun.dongdaemun.web.dto;

import com.dongdaemun.dongdaemun.domain.posts.ActivityPosts;
import com.dongdaemun.dongdaemun.domain.posts.AnonyPosts;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
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

    public NoticePosts toEntityNotice(){
        return NoticePosts.builder()
                .title(title)
                .content(content)
                .uid(uid)
                .anony(anony)
                .build();
    }

    public AnonyPosts toEntityAnony(){
        return AnonyPosts.builder()
                .title(title)
                .content(content)
                .uid(uid)
                .anony(anony)
                .build();
    }

    public ActivityPosts toEntityActivity(){
        return ActivityPosts.builder()
                .title(title)
                .content(content)
                .uid(uid)
                .anony(anony)
                .build();
    }
}

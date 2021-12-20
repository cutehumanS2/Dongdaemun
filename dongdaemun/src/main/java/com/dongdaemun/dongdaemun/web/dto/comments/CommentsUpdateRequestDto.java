package com.dongdaemun.dongdaemun.web.dto.comments;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsUpdateRequestDto {
    private String cmt_content;

    @Builder
    public CommentsUpdateRequestDto(String cmt_content){
        this.cmt_content = cmt_content;
    }
}

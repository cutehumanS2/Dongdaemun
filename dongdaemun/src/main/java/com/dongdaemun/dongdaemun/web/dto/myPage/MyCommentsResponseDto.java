package com.dongdaemun.dongdaemun.web.dto.myPage;

import com.dongdaemun.dongdaemun.domain.comments.Comments;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import lombok.Getter;
import java.util.Optional;

@Getter
public class MyCommentsResponseDto {
    private Long cmtId;
    private Long cmtPid;
    private Posts pid;
    private String uid;
    private int cmt_index;
    private String cmt_content;
    private boolean cmt_anony;
    private String category;


    public MyCommentsResponseDto(Optional<Comments> comments){
        comments.ifPresent(value -> {
            this.cmtId = value.getCmtId();
            this.cmtPid = value.getCmtPid();
            this.pid = value.getPid();
            this.uid = value.getUid();
            this.cmt_index = value.getCmt_index();
            this.cmt_content = value.getCmt_content();
            this.cmt_anony = value.isCmt_anony();
            this.category = value.getCategory();
        });
    }
}





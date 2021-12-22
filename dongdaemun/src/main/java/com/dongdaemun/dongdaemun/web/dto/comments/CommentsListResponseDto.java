package com.dongdaemun.dongdaemun.web.dto.comments;

import com.dongdaemun.dongdaemun.domain.comments.Comments;

import java.time.LocalDateTime;

public class CommentsListResponseDto {

    private Long cmtId;
    private Long cmtPid;
    private String uid;
    private Long pid;
    private String cmt_content;
    private boolean anony;
    private String category;
    private LocalDateTime modifiedDate;

    public CommentsListResponseDto(Comments entity){
        this.cmtId = entity.getCmtId();
        this.cmtPid = entity.getCmtPid();
        this.uid = entity.getUid();
        this.pid = entity.getPid().getId();
        this.cmt_content = entity.getCmt_content();
        this.anony = entity.isCmt_anony();
        this.category = entity.getCategory();
        this.modifiedDate = entity.getModifieDate();
    }


}

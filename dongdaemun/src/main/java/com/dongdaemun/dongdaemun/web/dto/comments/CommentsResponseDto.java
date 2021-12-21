package com.dongdaemun.dongdaemun.web.dto.comments;

import com.dongdaemun.dongdaemun.domain.comments.ActivityComments;
import com.dongdaemun.dongdaemun.domain.comments.AnonyComments;
import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import lombok.Getter;

@Getter
public class CommentsResponseDto {
    private Long cmtId;
    private Long cmtPid;
    private String uid;
    private Long pid;
    private int index;
    private String cmt_content;
    private boolean anony;

    public CommentsResponseDto(NoticeComments entity){
        this.cmtId = entity.getCmtId();
        this.cmtPid = entity.getCmtPid();
        this.uid = entity.getUid();
        this.pid = entity.getPid();//.getId();
        this.cmt_content = entity.getCmt_content();
        this.anony = entity.isCmt_anony();
    }

    public CommentsResponseDto(AnonyComments entity){
        this.cmtId = entity.getCmtId();
        this.cmtPid = entity.getCmtPid();
        this.uid = entity.getUid();
        this.pid = entity.getPid();//.getId();
        this.cmt_content = entity.getCmt_content();
        this.anony = entity.isCmt_anony();
    }

    public CommentsResponseDto(ActivityComments entity){
        this.cmtId = entity.getCmtId();
        this.cmtPid = entity.getCmtPid();
        this.uid = entity.getUid();
        this.pid = entity.getPid();//.getId();
        this.cmt_content = entity.getCmt_content();
        this.anony = entity.isCmt_anony();
    }

    public CommentsResponseDto(CommentsResponseDto commentsResponseDto){
        this.cmtId = commentsResponseDto.getCmtId();
        this.cmtPid = commentsResponseDto.getCmtPid();
        this.uid = commentsResponseDto.getUid();
        this.pid = commentsResponseDto.getPid();//.getId();
        this.cmt_content = commentsResponseDto.getCmt_content();
        this.anony = commentsResponseDto.isAnony();
    }

}

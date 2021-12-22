package com.dongdaemun.dongdaemun.web.dto.comments;

import com.dongdaemun.dongdaemun.domain.comments.Comments;
import com.dongdaemun.dongdaemun.service.posts.PostsService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
public class CommentsResponseDto {
    private Long cmtId;
    private Long cmtPid;
    private String uid;
    private Long pid;
    private int index;
    private String cmt_content;
    private boolean anony;
    private String category;

    @Autowired
    private PostsService postsService;

    public CommentsResponseDto(Comments entity){
        this.cmtId = entity.getCmtId();
        this.cmtPid = entity.getCmtPid();
        this.uid = entity.getUid();
        this.pid = entity.getPid().getId();
        this.cmt_content = entity.getCmt_content();
        this.anony = entity.isCmt_anony();
        this.category = entity.getCategory();

    }

    public CommentsResponseDto(CommentsResponseDto commentsResponseDto){
        this.cmtId = commentsResponseDto.getCmtId();
        this.cmtPid = commentsResponseDto.getCmtPid();
        this.uid = commentsResponseDto.getUid();
        this.pid = postsService.findById(commentsResponseDto.getPid()).getId(); // 가져온 Long으로 테이블에서 Posts 객체를 얻어서 id 얻음
        this.cmt_content = commentsResponseDto.getCmt_content();
        this.anony = commentsResponseDto.isAnony();
        this.category = commentsResponseDto.getCategory();
    }

}
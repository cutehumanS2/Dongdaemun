package com.dongdaemun.dongdaemun.web.dto.comments;

import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import com.dongdaemun.dongdaemun.domain.posts.NoticePosts;
import com.dongdaemun.dongdaemun.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {

    private Long cmtPid;
    private String uid;
    private Long pid;
    private int index;
    private String cmt_content;
    private boolean anony;

    @Builder
    public CommentsSaveRequestDto(Long cmtPid, String uid, String cmt_content, Long pid, int index, boolean anony) {
        this.cmtPid = cmtPid;
        this.cmt_content = cmt_content;
        this.uid = uid;
        this.pid = pid;
        this.index = index;
        this.anony = anony;
    }

    @Builder
    public CommentsSaveRequestDto(String uid, String cmt_content, Long pid, int index, boolean anony){
        this.cmt_content = cmt_content;
        this.cmtPid = 0L;
        this.uid = uid;
        this.pid = pid;
        this.index = index;
        this.anony = anony;
    }

    public NoticeComments toEntityNotice(){
        return NoticeComments.builder()
                .cmt_content(cmt_content)
                .cmt_pid(cmtPid)
                .uid(uid)
                .pid(pid)  /* Long -> NoticePosts */
                .cmt_index(index)
                .anony(anony)
                .build();
    }

}

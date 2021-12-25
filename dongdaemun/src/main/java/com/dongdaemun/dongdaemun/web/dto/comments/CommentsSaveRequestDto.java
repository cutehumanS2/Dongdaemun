package com.dongdaemun.dongdaemun.web.dto.comments;

import com.dongdaemun.dongdaemun.domain.comments.Comments;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {

    private Long cmtPid;
    private String uid;
    private Long pid;
    private int cmt_index;
    private String cmt_content;
    private boolean cmt_anony;
    private String category;

    @Builder
    public CommentsSaveRequestDto(Long cmtPid, String uid, String cmt_content, Long pid, int index, boolean anony, String category) {
        this.cmtPid = cmtPid;
        this.cmt_content = cmt_content;
        this.uid = uid;
        this.pid = pid;
        this.cmt_index = index;
        this.cmt_anony = anony;
        this.category = category;
    }

    @Builder
    public CommentsSaveRequestDto(String uid, String cmt_content, Long pid, int index, boolean anony, String category){
        this.cmt_content = cmt_content;
        this.cmtPid = 0L;
        this.uid = uid;
        this.pid = pid;
        this.cmt_index = index;
        this.cmt_anony = anony;
        this.category = category;
    }

    public Comments toEntity(){
        return Comments.builder()
                .cmt_content(cmt_content)
                .cmt_pid(cmtPid)
                .uid(uid)
                //.pid(post)  /* Long -> Posts */
                .cmt_index(cmt_index)
                .cmt_anony(cmt_anony)
                .category(category)
                .build();
    }

}
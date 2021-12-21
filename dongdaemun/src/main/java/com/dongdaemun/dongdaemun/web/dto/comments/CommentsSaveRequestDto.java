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
    private int index;
    private String cmt_content;
    private boolean anony;
    private String category;

    @Builder
    public CommentsSaveRequestDto(Long cmtPid, String uid, String cmt_content, Long pid, int index, boolean anony, String category) {
        this.cmtPid = cmtPid;
        this.cmt_content = cmt_content;
        this.uid = uid;
        this.pid = pid;
        this.index = index;
        this.anony = anony;
        this.category = category;
    }

    @Builder
    public CommentsSaveRequestDto(String uid, String cmt_content, Long pid, int index, boolean anony, String category){
        this.cmt_content = cmt_content;
        this.cmtPid = 0L;
        this.uid = uid;
        this.pid = pid;
        this.index = index;
        this.anony = anony;
        this.category = category;
    }

    public Comments toEntity(){
        return Comments.builder()
                .cmt_content(cmt_content)
                .cmt_pid(cmtPid)
                .uid(uid)
                .pid(pid)  /* Long -> NoticePosts */
                .cmt_index(index)
                .anony(anony)
                .category(category)
                .build();
    }



}

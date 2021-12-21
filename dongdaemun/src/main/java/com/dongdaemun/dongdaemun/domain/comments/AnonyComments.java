package com.dongdaemun.dongdaemun.domain.comments;

import com.dongdaemun.dongdaemun.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class AnonyComments extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cmtId;

    private Long cmtPid; //

    //@ManyToOne
    //@JoinColumn(name ="noticeFK", insertable=false, updatable=false)
    //private NoticePosts pid;

    private Long pid;
    private String uid;

    @Column(nullable = false)
    private int cmt_index;

    @Column(columnDefinition = "TEXT", nullable = false)
    String cmt_content;

    @Column(nullable = false)
    boolean cmt_anony;


    @Builder
    public AnonyComments(Long cmt_pid, String uid, Long pid, int cmt_index, String cmt_content, boolean anony){
        this.cmtPid = cmt_pid;
        this.uid = uid;
        this.pid = pid;
        this.cmt_index = cmt_index;
        this.cmt_content = cmt_content;
        this.cmt_anony = true;
    }

    public AnonyComments update(String cmt_content){
        this.cmt_content = cmt_content;
        return this;
    }
}

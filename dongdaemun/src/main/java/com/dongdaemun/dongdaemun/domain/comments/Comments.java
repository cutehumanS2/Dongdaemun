package com.dongdaemun.dongdaemun.domain.comments;

import com.dongdaemun.dongdaemun.domain.BaseTimeEntity;
import com.dongdaemun.dongdaemun.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cmtId;

    private Long cmtPid;

    @ManyToOne
    @JoinColumn(name ="postFK")
    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Posts pid;

    private String uid;

    @Column(nullable = false)
    private int cmt_index;

    @Column(columnDefinition = "TEXT", nullable = false)
    String cmt_content;

    @Column(nullable = false)
    boolean cmt_anony;

    @Column(nullable = false)
    String category;

    @Builder
    public Comments(Long cmt_pid, String uid, Posts pid, int cmt_index, String cmt_content, boolean cmt_anony, String category){
        this.cmtPid = cmt_pid;
        this.uid = uid;
        this.pid = pid;
        this.cmt_index = cmt_index;
        this.cmt_content = cmt_content;
        this.cmt_anony = cmt_anony;
        this.category = category;
    }

    public Comments update(String cmt_content){
        this.cmt_content = cmt_content;
        return this;
    }

    public void setPid(Posts pid) {
        this.pid = pid;
    }
}
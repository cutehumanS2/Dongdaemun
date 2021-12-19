package com.dongdaemun.dongdaemun.domain.posts;

import com.dongdaemun.dongdaemun.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String uid; //작성자 아이디
    
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private boolean anony; //익명 여부

    //이미지는 .. 어카지
    //private String img;


    @Builder
    public Posts(String title, String content, String uid, boolean anony){
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.anony = anony;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

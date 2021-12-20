package com.dongdaemun.dongdaemun.domain.posts;

import com.dongdaemun.dongdaemun.domain.BaseTimeEntity;
import com.dongdaemun.dongdaemun.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class NoticePosts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name="POST_ID")
    private Long id;

    //@ManyToOne
    //@JoinColumn(name ="userFK")
    private String uid; //작성자 아이디
    
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column
    private boolean anony; //익명 여부

    @Builder
    public NoticePosts(String title, String content, String uid, boolean anony){
        this.title = title;
        this.content = content;
        this.uid = uid;
        this.anony = anony;
    }

    public NoticePosts(Long id){
        this.id=id;
    }

    public NoticePosts update(String title, String content){
        this.title = title;
        this.content = content;
        return this;
    }
}

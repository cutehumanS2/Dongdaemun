package com.dongdaemun.dongdaemun.domain.posts;



import org.junit.After;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // 4.
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After // 1.
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String uid = "cherrycoke";
        String title = "테스트 게시글";
        String content = "테스트 본문";
        boolean anony = false;

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .uid(uid)
                .anony(anony)
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        assertThat(posts.getUid()).isEqualTo(uid);
        assertThat(posts.isAnony()).isEqualTo(anony);
    }
    /*
    @Test
    public void BaseTimeEntity_등록(){
        //given
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>>> createDate=" + posts.getCreateDate()
                + ", modifiedDate=" + posts.getModifieDate());
        assertThat(posts.getCreateDate()).isAfter(now);
        assertThat(posts.getModifieDate()).isAfter(now);
    }*/
}


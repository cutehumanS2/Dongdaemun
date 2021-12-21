package com.dongdaemun.dongdaemun.domain.posts;

import com.dongdaemun.dongdaemun.domain.comments.NoticeComments;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    List<Posts> findAllByCategory(String category, Pageable paging);
}

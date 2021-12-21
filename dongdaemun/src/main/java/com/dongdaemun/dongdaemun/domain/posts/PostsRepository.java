package com.dongdaemun.dongdaemun.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    Page<Posts> findAllByCategory(String category, Pageable paging);
}

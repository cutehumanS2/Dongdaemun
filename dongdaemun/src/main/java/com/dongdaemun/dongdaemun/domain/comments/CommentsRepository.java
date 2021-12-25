package com.dongdaemun.dongdaemun.domain.comments;

import com.dongdaemun.dongdaemun.domain.posts.Posts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    List<Comments> findAllByPid(Posts pid);
    Page<Comments> findAllByPid(Posts pid, Pageable paging);
    Page<Comments> findAllByUid(String email, Pageable paging);
    List<Comments> findAllByUid(String email);
}
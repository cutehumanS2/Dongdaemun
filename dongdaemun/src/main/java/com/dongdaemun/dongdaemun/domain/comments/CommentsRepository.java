package com.dongdaemun.dongdaemun.domain.comments;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments,Long> {
    List<Comments> findAllByPid(Long pid);
    Page<Comments> findAllByUid(String email, Pageable paging);
}
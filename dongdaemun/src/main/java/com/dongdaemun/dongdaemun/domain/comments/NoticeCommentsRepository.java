package com.dongdaemun.dongdaemun.domain.comments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeCommentsRepository  extends JpaRepository<NoticeComments,Long> {
    List<NoticeComments> findAllByPid(Long pid);
}

package com.dongdaemun.dongdaemun.domain.comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityCommentsRepository extends JpaRepository<ActivityComments,Long> {
    List<ActivityComments> findAllByPid(Long pid);
}

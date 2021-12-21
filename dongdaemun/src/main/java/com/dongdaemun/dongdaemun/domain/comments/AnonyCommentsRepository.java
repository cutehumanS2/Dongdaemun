package com.dongdaemun.dongdaemun.domain.comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnonyCommentsRepository extends JpaRepository<AnonyComments,Long> {
    List<AnonyComments> findAllByPid(Long pid);
}

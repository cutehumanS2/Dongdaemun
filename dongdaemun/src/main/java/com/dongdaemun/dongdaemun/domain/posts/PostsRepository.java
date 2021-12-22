package com.dongdaemun.dongdaemun.domain.posts;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    Page<Posts> findAllByCategory(String category, Pageable paging);
    Page<Posts> findAllByUid(String email, Pageable paging);

    @Query(value="SELECT * from posts where id IN (select postfk from comments where uid=:email)", nativeQuery=true)
    Page<Posts> findAllWithMyComments(@Param("email")String email, Pageable paging);
    //"select p from Posts p where p.id in (select c.pid from Comments c where c.uid= %:email%)"
}
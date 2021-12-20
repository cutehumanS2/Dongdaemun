package com.dongdaemun.dongdaemun.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityPostsRepository extends JpaRepository<ActivityPosts,Long> {
}

package com.dongdaemun.dongdaemun.service;

import com.dongdaemun.dongdaemun.domain.posts.Posts;
import com.dongdaemun.dongdaemun.domain.posts.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    PostsRepository postRepository;

    @Override
    public void savePost(Posts post) throws SQLException {
        postRepository.save(post);
    }


}

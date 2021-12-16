package com.dongdaemun.dongdaemun.service;

import com.dongdaemun.dongdaemun.domain.posts.Posts;

import java.sql.SQLException;

public interface PostService {
    public void savePost(Posts post) throws SQLException;

}

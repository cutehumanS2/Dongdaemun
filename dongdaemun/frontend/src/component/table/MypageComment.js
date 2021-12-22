import React, {useState, useEffect} from 'react';
import Pagination from './Pagination';
import { paginate } from './paginate';
import "./Table.css"

const MypageComment = () => {
    const posts = [
      {
        "createDate": "2021-12-20T20:26:31.495907", //LocalDateTime
        "modifieDate": "2021-12-20T20:26:31.495907", //LocalDateTime
        "id": 2, //Long
        "uid": "minpearl0826@gmail.com", //String
        "title": "공지1", //String
        "content": "ㅇ", //String
        "anony": false //boolean
    },
    {
        "createDate": "2021-12-20T19:52:31.305561",
        "modifieDate": "2021-12-20T19:52:31.305561",
        "id": 1,
        "uid": "none",
        "title": "공지1",
        "content": "ㅇㄹㄴ",
        "anony": false
    }
    ];

const renderPosts = posts && posts.map(post => {
    return (
      <div className='post' key={post.id}>
        <div>{post.title}</div>
        <div>{post.createDate}</div>
      </div>
    )
  })


  return (
    <>
    <div className="table">
        <div className="titlebar">
      <p className='title'>내가 쓴 댓글</p>
      </div>
      <div className="bar">
          <div>제목</div>
          <div>작성일</div>
        </div>
          <div className='postContainer'>{renderPosts}</div>
      </div>
    </>
  );
};

export default MypageComment;
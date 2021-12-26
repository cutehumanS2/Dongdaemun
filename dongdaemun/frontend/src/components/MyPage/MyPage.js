import React from 'react'
import './MyPage.css';
import axios from "axios"
import { useState, useEffect } from 'react';
import {Link} from "react-router-dom"

function MyPage() {
  const [name, setName] = useState();
  const [club, setClub] = useState();
  const [posts, setPosts] = useState();
  const [comments, setComments] = useState();
    
  const getData = async () => {
    const response = await axios.get('/mypage');
    setName(response.data.myProfileResponseDto.name);
    setClub(response.data.myProfileResponseDto.club);
    setPosts(response.data.postsPage.content);
    setComments(response.data.commentsPage.content);
  };

  useEffect(() => {
    getData();
  }, []);
  
  const renderPosts = posts && posts.map(post => {
    return (
      <div className='post' key={post.id}>
        <div>{post.title}</div>
        <div>{post.createDate2}</div>
      </div>
    )
  })
  const renderComments = comments && comments.map(comment => {
    return (
      <div className='post' key={comment.id}>
        <div>{comment.title}</div>
        <div>{comment.createDate2}</div>
      </div>
    )
  })

  return (
    <div className='MyPage'>
      <div className='userInfo'>
        <div className='clubUser'>
          <div className='clubName'>{club}</div>
          <div className='user'>{name}</div>  
        </div>
        <div>
          <button className='logout btn'>로그아웃</button>            
          <button className='exit btn'>회원 탈퇴</button>            
        </div>
      </div>

      <div className='bar'>
        <div>내가 쓴 글</div>
        <Link to='/post'>더보기</Link>
        <div>더보기</div>
      </div>
      <div className='postContainer'>{renderPosts}</div>
      <div className='bar'>
        <div>내가 쓴 댓글</div>
        <div>더보기</div>
      </div>
      <div className='postContainer'>{renderComments}</div>
    </div>
  )
}

export default MyPage;

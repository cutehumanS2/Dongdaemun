import React from 'react'
import './MyPage.css';
import axios from "axios"
import { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';


function MyPage() {
  const [name, setName] = useState();
  const [club, setClub] = useState();
  const [posts, setPosts] = useState();
  const [comments, setComments] = useState();
  
  const email="seohyeon0319@sookmyung.ac.kr"
  const baseUrl = "http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080";
  // const baseUrl = "http://localhost:8080";
  const getData = async () => {
    const response = await axios.get(baseUrl+'/mypage?email='+email);
    setName(response.data.myProfileResponseDto.name);
    setClub(response.data.myProfileResponseDto.club);
    setPosts(response.data.postsPage.content);
    console.log(response.data);
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
        <div>{comment.cmt_content}</div>
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
          <button className='logout button'>로그아웃</button>            
          <button className='exit button'>회원 탈퇴</button>            
        </div>
      </div>

      <div className='bar'>
        <div>내가 쓴 글</div>
        <Link to='/mypage/post'>더보기</Link>
      </div>
      <div className='postContainer'>{renderPosts}</div>
      <div className='bar'>
        <div>내가 쓴 댓글</div>
        <Link to='/mypage/comment'>더보기</Link>
      </div>
      <div className='postContainer'>{renderComments}</div>
    </div>
  )
}

export default MyPage;

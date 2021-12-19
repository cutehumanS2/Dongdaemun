import React from 'react'
import './Mypage.css';

// import { Link } from "react-router-dom"

function Mypage() {
  const clubName = "GDSC sookmyung"
  const user = "김서현"
  const posts = [
    {
      id:1,
      title: "첫 번째 글",
      date:"21.12.18"
    }, {
      id:2,
      title: "두 번째 글",
      date:"21.12.18"
    }, {
      id:3,
      title: "세 번째 글",
      date:"21.12.18"
    }
  ];
  const renderPosts = posts && posts.map(post => {
      return (
        <div className='post' key={post.id}>
          <div>{post.title}</div>
          <div>{post.date}</div>
        </div>
      )
    })

  return (
    <div className='MyPage'>
      <div className='userInfo'>
        <div className='clubUser'>
          <div className='clubName'>{clubName}</div>
          <div className='user'>{user}</div>        
        </div>
        <div>
          <button className='logout btn'>로그아웃</button>            
          <button className='exit btn'>회원 탈퇴</button>            
        </div>
      </div>

      <div className='bar'>
        <div>내가 쓴 글</div>
        <div>더보기</div>
      </div>
      <div className='postContainer'>{renderPosts}</div>
      <div className='bar'>
        <div>내가 쓴 댓글</div>
        <div>더보기</div>
      </div>
      <div className='postContainer'>{renderPosts}</div>
    </div>
  )
}

export default Mypage;

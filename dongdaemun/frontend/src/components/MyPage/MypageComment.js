import React, {useState, useEffect} from 'react';
import Pagination from '../Post/PostList/Pagination';
import { paginate } from '../Post/PostList/paginate';
import "../Post/PostList/Table.css"
import axios from "axios";

const MyPageComment = () => {
  const [posts, setPosts] = useState();
  const getData = async() => {
    const headers = {
      "Content-Type": "application/json"
    }
    const response = await axios.get('/mypage/mycomments?commentPage=0', {headers});
    console.log(response.data.content);
    setPosts(response.data);
  };
  console.log("출력" + posts);

  useEffect(() => {
    getData();
  }, []);

  const renderPosts = posts.content && posts.content.map(post => {
    return (
      <div className='post' key={post.id}>
        <div>{post.title}</div>
        <div>{post.createDate}</div>
      </div>
    )
  })


  return (
    <>
    <div className="tablecss">
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

export default MyPageComment;
import React, {useState, useEffect} from 'react';
import "../Post/PostList/Table.css"
import axios from "axios";

const MyPageComment = () => {
  const [posts, setPosts] = useState({})
  const email="seohyeon0319@sookmyung.ac.kr"
  const baseUrl = "http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080";

  const getData = async() => {
    const headers = {
      "Content-Type": "application/json"
    }
    const response = await axios.get(baseUrl+'/mypage/mycomments?commentPage=0&email='+email, {headers});
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
        <a
            href={`pagetable/readpost/${post.category}/${post.id}`}
            style={{ textDecoration: "none" }}
            className="posts"
          >
        <div>{post.title}</div>
        <div>{post.createDate2}</div>
        </a>
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
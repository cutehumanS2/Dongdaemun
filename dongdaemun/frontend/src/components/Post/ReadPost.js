import React from "react";
import "./ReadPost.css";
import NavBar from "../NavBar/NavBar";
import { Button } from "react-bootstrap";
import Recommend from "./Comments";



function ReadPost() {

  

  return (
    
    <div className="App">
      <div className="post-title">제목</div>
      <div className="post-writer">글 작성자</div>
      <div className="post-date">글 작성일</div>
      <div className="post-text">

          게시글 내용
      </div>
      <div className="post-btn-row">
        <Button className="rewrite-btn" size="sm" variant="light">
          수정하기
        </Button>
        <Button className="delete-btn" size="sm" variant="light">
          삭제하기
        </Button>
        <Recommend/>
      </div>
    </div>
  );
}

export default ReadPost;

import React from "react";
import "./ReadPost.css";
import NavBar from "../NavBar/NavBar";
import { Button } from "react-bootstrap";
import Recommend from "./Comments";
import {useParams} from "react-router-dom"

function ReadPost() {
  let {category, id} = useParams();
  console.log("넘어오는 카테고리: ", category);
  console.log("넘어오는 아이디:", id);
  
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

import React from "react";
import "./css/readPost.css";
import NavBar from "./navBar";
import { Form, Button } from "react-bootstrap";
function ReadPost() {
  return (
    <div className="App">
      <div className="post-title">제목</div>
      <div className="post-writer">글 작성자</div>
      <div className="post-date">글 작성일</div>
      <div className="post-text">
        <Form>
          <Form.Group>
            {/* <Form.Label>게시글 내용</Form.Label> */}
            <Form.Control as="textarea" rows={15} />
          </Form.Group>
        </Form>
      </div>
      <div className="post-btn-row">
        <Button className="rewrite-btn" size="sm" variant="light">
          수정하기
        </Button>
        <Button className="delete-btn" size="sm" variant="light">
          삭제하기
        </Button>
      </div>
    </div>
  );
}

export default ReadPost;

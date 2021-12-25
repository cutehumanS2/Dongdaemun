import React from "react";
import { useState, useEffect} from "react";
import "./ReadPost.css";
import NavBar from "../NavBar/NavBar";
import { Button } from "react-bootstrap";
import Recommend from "./Comments";
import axios from "axios";



function ReadPost() {
  const [postText, setPostText] = useState([]);

  // const baseUrl = "http://localhost:8080"


  // useEffect(() => {
  //   getPost();
  // }, []);

  // async function getPost() {
  //   await axios
  //     .get("http://localhost:8080/view")
  //     .then((response) => {
  //       console.log(response.data);
  //       setPostText(response.data);
  //     })
  //     .catch((error) => {
  //       console.error(error)
  //     })
  // }
  const [posts, setPosts] = useState()

  const getData = async () => {
    const headers = {
      "Content-Type": "application/json"
    }
      const response = await axios.get('/view?category=notice&id=2&page=0', {headers});
      console.log(response.data);
    };
    console.log("출력!!!!"+posts);
  
    useEffect(() => {
    getData();
    }, []);





  return (
 
    <div className="App">
      <div className="post-title">제목</div>
      <div className="post-writer">글 작성자</div>
      <div className="post-date">글 작성일</div>
      <div className="post-text">
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

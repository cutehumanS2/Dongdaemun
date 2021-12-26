import React, { useState, useEffect } from "react";
import "./ReadPost.css";
import NavBar from "../NavBar/NavBar";
import { Button } from "react-bootstrap";
// import {useHistory} from "react-router-dom";
import Recommend from "./Comments";
import axios from "axios";



function ReadPost() {
  const [posts, setPosts] = useState({})
  const baseURL = "http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080"
  const getData = async () => {
    const headers = {
      "Content-Type": "application/json"
    }
    const response = await axios.get(baseURL + "/view?category=notice&id=3&page=0", { headers });
    console.log(response.data);


    setPosts({ posts, ...response.data.posts });
  };
  console.log("출력!!!!" + posts);

  useEffect(() => {
    getData();
  }, []);


  const postDelete = () => {
    axios.delete(baseURL + "/delete?category=notice&id=3")
      .then(function (response) {
        // handle success
        console.log(response);
      })
      .catch(function (error) {
        // handle error
        console.log(error);
      })
      .then(function () {
        // always executed
        //이전 화면으로 돌아가기, history.push()
      });
  }

  return (

    <div className="App">
      <div className="post-wrapper">

        {!!posts && (
          <div className="post-section" >
            <div className="post-title">{posts.title}</div>
            <div className="post-writer">{posts.uid}</div>
            <div className="post-date">{posts.createDate2}</div>
            <div className="post-text">
              {posts.content}
            </div>
          </div>
        )}
      </div>


      <div className="post-btn-row">
        <Button className="rewrite-btn" size="sm" variant="light">
          수정하기
        </Button>
        <Button onClick={postDelete} className="delete-btn" size="sm" variant="light">
          삭제하기
        </Button>
        <Recommend />
      </div>
    </div >
  );
}

export default ReadPost;

import React, { useState, useEffect } from "react";
import "./ReadPost.css";
import NavBar from "../NavBar/NavBar";
import { Button } from "react-bootstrap";
import { Link, useLocation, useParams, useNavigate } from "react-router-dom";
import Recommend from "./Comments";
import axios from "axios";
import queryString from "query-string";

function ReadPost() {
  const email="seohyeon0319@sookmyung.ac.kr"

  let { category, id } = useParams();
  console.log("넘어오는 카테고리: ", category);
  console.log("넘어오는 아이디:", id);

  const [posts, setPosts] = useState({});
  const baseURL =
    "http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080";
  const getData = async () => {
    const headers = {
      "Content-Type": "application/json",
    };
    const response = await axios.get(
      baseURL + "/view?category=" + category + "&id=" + id + "&page=0"+"&email=" + email
      
    );
    console.log(response.data);

    setPosts({ posts, ...response.data.postsAndCommentsPageResponseDto.posts });
  };
  console.log("출력!!!!" + posts);

  useEffect(() => {
    getData();
  }, []);


  let navigate = useNavigate()
  const postDelete = () => {
    axios
      .delete(baseURL + "/delete?category=" + category + "&id=" + id +"&email=" + email)
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      })
      .then(function () {
        // always executed
        //이전 화면으로 돌아가기, history.push()
        navigate(-1);
      });
  };

  return (
    <div className="App">
      <div className="post-wrapper">
        {!!posts && (
          <div className="post-section">
            <div className="post-title">{posts.title}</div>
            <div className="post-writer">{posts.uid}</div>
            <div className="post-date">{posts.createDate2}</div>
            <div className="post-text">{posts.content}</div>
          </div>
        )}
      </div>

      <div className="post-btn-row">
        <a
            href={`editpost/${category}/${id}`}
            style={{ textDecoration: "none" }}
          >
          <Button className="rewrite-btn" size="sm" variant="light">
            수정하기
          </Button>
        </a>

        <Button
          onClick={postDelete}
          className="delete-btn"
          size="sm"
          variant="light"
        >
          삭제하기
        </Button>
        <Recommend />
      </div>
    </div>
  );
}

export default ReadPost;

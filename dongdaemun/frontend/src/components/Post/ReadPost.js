import React, { useState, useEffect } from "react";
import "./ReadPost.css";
import NavBar from "../NavBar/NavBar";
import { Button } from "react-bootstrap";
import { Link, useLocation, useParams } from "react-router-dom";
import Recommend from "./Comments";
import axios from "axios";
import queryString from "query-string";

function ReadPost() {
  // const getParams = ({path}) => {
  //   const location = path;
  //   const query = queryString.parse(location.search);
  //   console.log("test" + query)
  // }

  // var newURL = window.location.pathname;
  // const query = queryString.parse(newURL);
  // console.log(query);

  //   const testUrl = new URL("http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080/view?category= notice&id=2&page=0")
  // const sch = testUrl.search;
  // const params = new URLSearchParams(sch);
  // const keyword = params.get('id');

  // console.log("test-id:" + keyword);

  // const params = useParams();
  // const [topic, setTopic] = useState({
  //   title: 'category',
  //   description: 'Not Found',
  // });

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
      baseURL + "/view?category=" + category + "&id=" + id + "&page=0"
      
    );
    console.log(response.data);

    setPosts({ posts, ...response.data.posts });
  };
  console.log("출력!!!!" + posts);

  useEffect(() => {
    getData();
  }, []);

  const postDelete = () => {
    axios
      .delete(baseURL + "/delete?category=notice&id=3")
      .then(function (response) {
        console.log(response);
      })
      .catch(function (error) {
        console.log(error);
      })
      .then(function () {
        // always executed
        //이전 화면으로 돌아가기, history.push()
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

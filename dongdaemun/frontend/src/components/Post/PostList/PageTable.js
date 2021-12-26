import React, {useState, useEffect} from 'react';
import Pagination from './Pagination';
import { paginate } from './paginate';
import "./Table.css"
import axios from "axios";
import MakePost from '../MakePost';
import ReadPost from '../ReadPost';
import {BrowserRouter as BrowserRouter, Routes, Route, Link} from "react-router-dom"
import pagination from './Pagination';
import "./Pagination.css"

const PageTable = (props) => {
  const [posts, setPosts] = useState({})
  const getData = async() => {
    const headers = {
      "Content-Type": "application/json"
    }
    const baseUrl = "http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080";
    const response = await axios.get(baseUrl + '/list?category=notice&page=0');
    console.log(response.data);
    setPosts(response.data);
  };

  useEffect(() => {
    getData();
  }, []);

  const textLengthOverCut = (txt, len, lastTxt) => {
    if (len == "" || len == null) { // 기본값
        len = 20;
    }
    if (lastTxt == "" || lastTxt == null) { // 기본값
        lastTxt = "...";
    }
    if (txt.length > len) {
        txt = txt.substr(0, len) + lastTxt;
    }
    return txt;
}


const renderPosts = posts.posts && posts.posts.map(post => {
    var text = post.content
  return (
      <div  key={post.id}>
        <Link to= {`readpost/${post.id}`} style={{textDecoration: 'none'}} className='posts'>
        <div className="downpostleft">
            <div>{post.title}</div><div>{textLengthOverCut(text,9,"...")}</div></div>
        <div className="downpostright">
            <div>{post.createDate2}</div><div>{post.uid}</div></div>
        </Link>
      </div>
    )
  })


  return (
    <>
    <div className="tablecss">
        <div className="titlebar">
      <p className='title'>공지 게시판</p>
      <Link to="/makepost" style={{textDecoration: 'none'}}>
        <button className="write" >글 작성하기</button></Link>
      </div>
      <div className="namebar">
          <div>제목</div>
          <div>작성일</div>
        </div>
        
          <div className='postsContainer'>{renderPosts}</div>
          <script>console.log("게시글 Id: " + postId)</script>

      </div>
      <Pagination className="pagination"
        pageCount={5} // totalRecords
        pageRangeDisplayed={5}
        marginPagesDisplayed={0}
        itemsCountPerPage={5}
        previousLabel={"◀"}
        nextLabel={"▶"}
        //onPageChange={changePage}
        containerClassName={"pagination-ul"}
        activeClassName={"currentPage"}
        previousClassName={"pageLabel-btn"}
        nextClassName={"pageLabel-btn"}
      />
    </>
  );
};

export default PageTable;
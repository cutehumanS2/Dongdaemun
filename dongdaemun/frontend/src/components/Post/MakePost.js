import React from 'react'
import axios from "axios"
import { useState } from 'react';
import './MakePost.css'

function MakePost() {
  const [postContent, setPostContent] = useState("");
  const [title, setTitle] = useState("");
  const handleContent = (e) => {
    setPostContent(e.target.value);
  }
  const handleTitle = (e) => {
    setTitle(e.target.value);
  }

  let category = "notice";
  let infos = JSON.stringify ({
    uid: "uid",
    title: title,
    content: postContent,
    category: category,
    anony: false
  })
  const onSubmit = async () => {
    const headers = {
      "Content-Type": "application/json"
    }
    const response = await axios.post('/save?category=' + category, infos, {headers});
    console.log(response.data)
    setPostContent(response.data);
    setPostContent("");  
    setTitle("");
  };
  
  return (
    <div className='MakePost'>
      <div>게시글 작성하기</div>
      <input value={title} onChange={handleTitle}></input>
      <textarea value={postContent} onChange={handleContent}></textarea>
      <button onClick={onSubmit}>업로드</button>
    </div>
  )
}

export default MakePost
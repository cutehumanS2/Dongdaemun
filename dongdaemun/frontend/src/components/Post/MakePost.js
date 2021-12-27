import React from 'react'
import axios from "axios"
import { useState } from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import './MakePost.css'
import { useParams, useNavigate } from "react-router-dom"


function MakePost(props) {
  let {category} = useParams();
  console.log("넘어오는 데이터: ", category);
  
  const [postContent, setPostContent] = useState("");
  const [title, setTitle] = useState("");
  const handleTitle = (e) => {
    setTitle(e.target.value);
  }
  
  let infos = JSON.stringify ({
    uid: "uid",
    title: title,
    content: postContent,
    category: category,
    anony: false
  })
  let navigate = useNavigate();
  const onSubmit = async () => {
    const headers = {
      "Content-Type": "application/json"
    }
    const response = await axios.post('http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080/save?category=' + category, infos, {headers});
    console.log(response.data)
    setPostContent(response.data);
    setPostContent("");  
    setTitle("");
    navigate(-1);
  };
  
  return (
    <div className='MakePost'>
      <input value={title} onChange={handleTitle}
        placeholder='제목을 입력하세요'>          
      </input>
      <CKEditor
        editor={ ClassicEditor }
        data="<p> </p>"        
        onChange={ ( event, editor ) => {
            const data = editor.getData();
            console.log(data)
            setPostContent(data);
        } }
      />
      <button className='btn' onClick={onSubmit}>업로드</button>
    </div>
  )
}

export default MakePost
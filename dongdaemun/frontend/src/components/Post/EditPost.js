import React from 'react'
import axios from "axios"
import { useState } from 'react';
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import './MakePost.css'

function EditPost() {
  const [postContent, setPostContent] = useState("");
  const [title, setTitle] = useState("");
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
      <input value={title} onChange={handleTitle}
        placeholder='제목을 입력하세요'>          
      </input>
      <CKEditor
        editor={ ClassicEditor }
        data="<p>게시글 id로 접근해서 글 내용 여기에 넣기</p>"        
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

export default EditPost
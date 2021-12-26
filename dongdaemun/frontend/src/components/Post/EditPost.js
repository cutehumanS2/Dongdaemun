import axios from "axios"
import React, { useState, useEffect } from "react";
import { CKEditor } from '@ckeditor/ckeditor5-react';
import ClassicEditor from '@ckeditor/ckeditor5-build-classic';
import './MakePost.css'
import {useParams} from "react-router-dom"

function EditPost() {
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
  const onSubmit = async () => {
    const headers = {
      "Content-Type": "application/json"
    }
    const response = await axios.post('http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080/update?category=' + category + '&id=' + id, infos, {headers});
    console.log(response.data)
    setPostContent(response.data);
    setPostContent("");  
    setTitle("");
  };
  
  return (
    <div className='MakePost'>
      <input value={title} onChange={handleTitle}
        placeholder={posts.title}>          
      </input>
      <CKEditor
        editor={ ClassicEditor }
        data={posts.content}     
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
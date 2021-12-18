import React from 'react';
import "./css/readPost.css";
import {} from "react-bootstrap";
import SingleComment from './SingleComment'

class ReadPost extends React.Component {
  constructor(props){
    super(props);
    this.stat={
      comments: [
        {
          uuid: 1, 
          writer:"김눈송", 
          date:"2021-01-01",
          content:"숙명 gdsc"
        }, 
        {
          uuid: 2, 
          writer:"선다래", 
          date:"2021-04-08",
          content:"쫄순"
        }

      ]
    }
    this.addComment = this.addComment.bind(this);
  }
  addComment(){
    let value=document.querySelector('#new-comment-content').value;
    this.setState({comments: [...this.state.comments, {
      uuid:this.state.comments.length +1,
      writer:"김눈송", 
      date: new Date.toISOString().slice(0, 10),
      content: value
    }]})
  }
  render(){
    return (
    <div id="root">
      <div>
        <div>작성자: 김눈송</div>
        <div id="writing-area">
          <textarea id="new-comment-content"></textarea>
          <button id="submit-new-comment" onClick={this.addComment}>새 댓글 쓰기</button>
        </div>
        <ul id="comments">
          {
            this.state.comments.map(comment => {
              return <SingleComment key={comment.uuid} comment={comment}/>
            })
          }
        </ul>
      </div>
    </div>
    )
  }
}
export default ReadPost;
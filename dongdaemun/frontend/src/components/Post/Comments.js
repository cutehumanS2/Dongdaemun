import React, { useState } from "react";
import "./Comments.css";

const mockList = [
  {
    id: 1,
    title: "김눈송",
    content:
      "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
    replies: [
      {
        id: 1,
        title: "김눈송",
        content:
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        tag: "",
      },
      {
        id: 2,
        title: "김눈송",
        content:
          "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ",
        tag: "",
      },
    ],
  },
];

const Comments = () => {
  const [isShowRpInput, setisShowRpInput] = useState(false);
  const [isShowCmInput, setisShowCmInput] = useState(true);

  const handleComment = (id) => {
    setisShowRpInput(true);
    console.log("댓글");
  };

  const handleReply = (id) => {
    setisShowRpInput(true);
    console.log("대댓글");
  };

  const handleSubmitComment= () => {
    console.log("댓글 제출");
  };
  const handleSubmitReply = () => {
    setisShowRpInput(false);
    console.log(" 대댓글 제출");
  };

  return (
    <>
      <div className="comment-wrapper">
        <ul className="comment-list-wrapper">
          {mockList.map((item) => {
            return (
              <li className="comment-list" key={item.id}>
                <div className="comment-item">
                  <div>
                    <p className="comment-title">{item.title}</p>
                    <div className="comment-content">{item.content}</div>
                    <button
                      className="reply-button"
                      onClick={() => handleReply(item.id)}
                    >
                      답글달기
                    </button>
                  </div>
                  
                </div>
                {isShowRpInput && (
                  <div className="input-wrapper">
                    <input value="" className="input"  placeholder="대댓글을 달아주세요" />
                    <button
                      className="submit"
                      onClick={() => handleSubmitReply}
                    >
                      등록
                    </button>
                  </div>
                )}
                <ul className="reply-wrapper">
                  {item.replies.map((item) => {
                    return (
                      <li className="reply-item" key={item.id}>
                        <div>
                          <div className="comment-title">{item.title}</div>
                          <div className="comment-content">{item.content}</div>
                         
                        </div>
                      </li>
                      
                      

                      
                    );
                  })}
                </ul>
                <div className="input-wrapper">
                    <input value="" className="input" placeholder="  댓글을 달아주세요" />
                    <button
                      className="submit"
                      onClick={() => handleSubmitCommentOrReply}
                    >
                      등록
                    </button>
                  </div>

              </li>
            );
          })}
        </ul>
      </div>
    </>
  );
};

export default Comments;
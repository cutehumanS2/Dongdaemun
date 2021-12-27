import React, { useState } from "react";
import "./Comments.css";
import axios from "axios";

const mockList = [
  {
    id: 1,
    title: "김눈송",
    content:
      "코스모스는 과거에 있었고, 현재에 있으며, 미래에 있을 그 모든 것이다. 이 책은 내가 직접 본 격렬한 역사의 한 단편이다.",
    replies: [
      {
        id: 1,
        title: "김눈송",
        content:
          "어떤 행성에서 지적 생물이 성숙했다고 말할 수 있는 것은 그 생물이 자기의 존재 이유를 처음으로 알아냈을 때이다.",
      },
      {
        id: 2,
        title: "김눈송",
        content:
          "일생을 통계역학을 연구하며 보냈던 루트비히 볼츠만은 1906년, 스스로 목숨을 끊었다. 파울 에렌페스트가 그의 일을 이어받았고, 1933년에 자살했다. 이제 우리가 통계역학을 배울 차례다. ",
      },
    ],
  },
  {
    id: 2,
    title: "김눈송",
    content:
      "'하늘은 사람 위에 사람 만들지 않았고, 사람 밑에 사람 만들지 않았다.' 라고들 말해진다. 이 책은 내가 직접 본 격렬한 역사의 한 단편이다.",
    replies: [
      {
        id: 1,
        title: "김눈송",
        content:
          "어떤 행성에서 지적 생물이 성숙했다고 말할 수 있는 것은 그 생물이 자기의 존재 이유를 처음으로 알아냈을 때이다.",
      },
      {
        id: 2,
        title: "김눈송",
        content:
          "역사란 무엇인가? 인류 사회의 “아(我)”와 “비아(非我)”의 투쟁이 시간으로 발전하고 공간으로 확대되는 심적(心的)활동 상태의 기록이니, 세계사라 하면 세계 인류가 그렇게 되어온 상태의 기록이요, 조선사라 하면 조선 민족이 이렇게 되어온 상태의 기록이다.",
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
                    <input className="input"  placeholder="대댓글을 달아주세요" />
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
                

              </li>
            );
          })}
        </ul>
        <div className="input-wrapper">
                    <input className="input" placeholder="  댓글을 달아주세요" />
                    <button
                      className="submit"
                      onClick={() => handleSubmitComment}
                    >
                      등록
                    </button>
                  </div>
      </div>
    </>
  );
};

export default Comments;
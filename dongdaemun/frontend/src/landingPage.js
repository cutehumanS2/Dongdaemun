import React from 'react';
import "./css/App.css";
import { Button } from "react-bootstrap";

function LandingPage() {
  return (
    <div className="App">
      <header className="App-header">
        <img src="img/ddm_logo.png" className="logo-img" alt="logo" />
        <p className="logo-name">Dongdaemoon</p>
        <p className="logo-explain">동아리 대문을 열어라</p>
        <Button variant="secondary" className="btn-google">
          구글 로그인
        </Button>
        <br />
        <Button variant="warning" className="btn-kakao">
          카카오 로그인
        </Button>
      </header>
    </div>
  );
}

export default LandingPage;

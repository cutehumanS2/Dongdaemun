import React from 'react';
import "./LandingPage.css";
import { Button } from "react-bootstrap";

function LandingPage() {
  return (
    <div className="App">
      <header className="App-header">
        <img src="img/ddm_logo.png" className="logo-img" alt="logo" />
        <p className="logo-name">Dongdaemoon</p>
        <p className="logo-explain">동아리 대문을 열어라</p>
        <a href='/oauth2/authorization/google'>
          <Button variant="secondary" className="btn-google">
            구글 로그인
        </Button></a>
        <br />
        <a href='/oauth2/authorization/naver'>
          <Button variant="success" className="btn-naver">
            네이버 로그인
        </Button></a>
      </header>
    </div>
  );
}

export default LandingPage;

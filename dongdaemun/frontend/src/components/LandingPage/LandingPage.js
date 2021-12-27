import React from 'react';
import "./LandingPage.css";
import { Button } from "react-bootstrap";
import logoImg from '../../img/ddm_logo.png';

function LandingPage() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logoImg} className="logo-img" alt="logo" />
        <p className="logo-name">Dongdaemoon</p>
        <p className="logo-explain">동아리 대문을 열어라</p>
        <a href='http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080/oauth2/authorization/google'>
          <Button variant="secondary" className="btn-google">
            구글 로그인
        </Button></a>
        <br />
        <a href='http://ec2-15-165-95-188.ap-northeast-2.compute.amazonaws.com:8080/oauth2/authorization/naver'>
          <Button variant="success" className="btn-naver">
            네이버 로그인
        </Button></a>
      </header>
    </div>
  );
}

export default LandingPage;

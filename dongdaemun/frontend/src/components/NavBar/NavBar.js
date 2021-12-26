import React from 'react';
import "./NavBar.css";
import { Navbar, Nav, Container } from "react-bootstrap";
import { BrowserRouter as Router, Routes, Route, Link } from "react-router-dom";
import {useState} from 'react';

function NavBar() {
  const [pagename, setPageName] = useState();
  return (
      <div className="App">
        <Navbar className="navBar">
          <Container>
            <Navbar.Brand href="#home">
              <img
                className="nav-logo"
                alt="logo"
                src="img/navbar_logo.png"
              ></img>
            </Navbar.Brand>
            <Nav className="me-auto">
              <Nav.Link href="/pagetable/notice">공지 게시판</Nav.Link>
              <Nav.Link href="/pagetable/activity">활동 게시판</Nav.Link>
              <Nav.Link href="/pagetable/anon">익명 게시판</Nav.Link>
              
              <Link to="/mypage" style={{ textDecoration: "none" }}>
              <button
                className="mypage-btn"
              >
                My Page
              </button>
              </Link>
            </Nav>
          </Container>
        </Navbar>
      </div>
  );
}

export default NavBar;
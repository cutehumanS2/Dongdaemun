import React from 'react';
import "./NavBar.css";
import { Navbar, Nav, Container, Button } from "react-bootstrap";
import { BrowserRouter as Router, Route, Switch, Link } from "react-router-dom";

function NavBar() {
  return (
    <Router>
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
              <Nav.Link href="/notice">공지 게시판</Nav.Link>
              <Nav.Link href="/activity">활동 게시판</Nav.Link>
              <Nav.Link href="/anon">익명 게시판</Nav.Link>
              <Button
                variant="default"
                size="sm"
                className="login-btn"
                style={{
                  backgroundColor: "#ffffe7",
                  outline: "none",
                  color: "black",
                }}
              >
                Login
              </Button>
              <Button
                variant="default"
                size="sm"
                className="mypage-btn"
                style={{
                  backgroundColor: "#ffffe7",
                  outline: "none",
                  color: "black",
                }}
              >
                My Page
              </Button>
            </Nav>
          </Container>
        </Navbar>
      </div>
      <div>
        <Switch>
          <Route path="/notice" >
{/* 컴포넌트 삽입 */}
          </Route>
        </Switch>
      </div>
    </Router>
  );
}

export default NavBar;

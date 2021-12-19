import React, {useState, useEffect} from 'react';
import '../../App.css';
import PostMain from './PostMain';
import { Carousel, Modal, Navbar, Container, Row, Col, Button,Alert,Breadcrumb, BreadcrumbItem, Card, Form, Nav } from 'react-bootstrap';



function mypageComment () {
return (
  <div className="App">
    <Container>
      <Row>
        <Col>
          <div style={{float: "left"}}>내가 쓴 댓글</div>
        </Col>
      </Row>
      <PostMain />
    </Container>
  </div>
  )
}

export default mypageComment;


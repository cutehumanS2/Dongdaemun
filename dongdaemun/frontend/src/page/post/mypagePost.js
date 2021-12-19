import React, {useState, useEffect} from 'react';
import '../../App.css';
import PostMain from './PostMain';
import { Carousel, Modal, Navbar, Container, Row, Col, Button,Alert,Breadcrumb, BreadcrumbItem, Card, Form, Nav } from 'react-bootstrap';



function mypagePost() {
return (
  <div className="mypagePost">
    <Container>
      <Row>
        <Col>
          <div style={{float: "left"}}>공지 게시판</div>
        </Col>
      </Row>
      <PostMain />
    </Container>
  </div>
  )
}

export default mypagePost;


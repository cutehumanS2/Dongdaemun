import React, {useState, useEffect} from 'react';
import '../../App.css';
import PostMain from './PostMain';
import { Carousel, Modal, Navbar, Container, Row, Col, Button,Alert,Breadcrumb, BreadcrumbItem, Card, Form, Nav } from 'react-bootstrap';



function Notice() {
return (
  <div className="Notice">
    <Container>
      <Row>
        <Col>
          <div style={{float: "left"}}>공지 게시판</div>
          <button 
          style={{float: "right",
                backgroundcolor : "#539ddb",
                }}>글 작성하기</button>
        </Col>
      </Row>
      <PostMain />
    </Container>
  </div>
  )
}

export default Notice;


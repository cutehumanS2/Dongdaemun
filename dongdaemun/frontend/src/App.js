import React, {useState, useEffect} from 'react';
import './App.css';
import PostMain from './page/post/PostMain';
import { Carousel, Modal, Navbar, Container, Row, Col, Button,Alert,Breadcrumb, BreadcrumbItem, Card, Form, Nav } from 'react-bootstrap';
import Pagination from './page/post/Pagination';
import mypageComment from './page/post/mypageComment';
import mypagePost from './page/post/mypagePost';
import { BrowserRouter as BrowserRouter, Route, Routes, Link } from 'react-router-dom';
import Notice from './page/post/Notice';


function App () {
return (
  <div className="App">
    <BrowserRouter>
      <div className='Menu-wrapper'>
            <Link to='/notice'><li>Notice</li></Link>
            <Link to='/mypagecomment'><li>mypageComment</li></Link>
            <Link to='/mypagepost'><li>mypagePost</li></Link>
        </div>
        <div className='Contents-wrapper'>
      <Routes>
        <Route path='/notice' element={<Notice/>}></Route>
        <Route path='/mypagecomment' element={<mypageComment/>}></Route>
        <Route path='/mypagepost' element={<mypagePost/>}></Route>
      </Routes>
      </div>
    </BrowserRouter>
  </div>
  )
}

export default App;


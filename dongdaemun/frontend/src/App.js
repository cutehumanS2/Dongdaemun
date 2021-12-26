import React from 'react';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import MakePost from './components/Post/MakePost';
import MyPage from './components/MyPage/MyPage';
import MyPagePost from './components/MyPage/MyPagePost';
import MyPageComment from './components/MyPage/MyPageComment';
import ReadPost from './components/Post/ReadPost';
import LandingPage from './components/LandingPage/LandingPage';
import PageTable from './components/Post/PostList/PageTable';
import NavBar from './components/NavBar/NavBar';
import EditPost from './components/Post/EditPost';
import { Nav } from 'react-bootstrap';

function App () {

return (
  <div className="App">
    <BrowserRouter>
    <NavBar/>
      <div>        
        <Routes>
          <Route exact path="/" element={<LandingPage />}></Route>
          <Route path="/pagetable/:category" element={<PageTable />}></Route>
          <Route path="/pagetable/makepost/:category" element={<MakePost />}></Route>
          <Route path="/pagetable/readpost/:category/:id" element={<ReadPost />}></Route>
          <Route path="/mypage" element={<MyPage />}></Route>
          <Route path="/mypage/post" element={<MyPagePost />}></Route>
          <Route path="/mypage/comment" element={<MyPageComment />}></Route>
          <Route path="/mypage/pagetable/readpost/:category/:id" element={<ReadPost />}></Route>
          <Route path="pagetable/readpost/:category/editpost/:category/:id" element={<EditPost/>}></Route>
        </Routes>
      </div>
    </BrowserRouter> 
  </div>
)}
export default App;
import React from 'react';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import MakePost from './components/Post/MakePost';
import MyPage from './components/MyPage/MyPage';
import MyPagePost from './components/MyPage/MyPagePost';
import MyPageComment from './components/MyPage/MyPageComment';
import ReadPost from './components/Post/ReadPost';
import LandingPage from './components/LandingPage/LandingPage';
import PageTable from './components/Post/PostList/PageTable';

function App () {

return (
  <div className="App">
    <BrowserRouter>
      <div>        
        <Routes>
          <Route exact path="/" element={<LandingPage />}></Route>
          <Route path="/notice" element={<PageTable />}></Route>
          <Route path="/makepost" element={<MakePost />}></Route>
          <Route path="/readpost" element={<ReadPost />}></Route>
          <Route path="/mypage" element={<MyPage />}></Route>
          <Route path="/mypage/post" element={<MyPagePost />}></Route>
          <Route path="/mypage/comment" element={<MyPageComment />}></Route>
        </Routes>
      </div>
    </BrowserRouter> 
  </div>
)}
export default App;
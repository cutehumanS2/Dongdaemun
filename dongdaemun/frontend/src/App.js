import React, {useState, useEffect} from 'react';
import './App.css';
import MainTable from './component/table/MainTable';
import PageTable from './component/table/PageTable';
import MypageComment from './component/table/MypageComment';
import MypagePost from './component/table/MypagePost';


function App () {
return (
  <div className="App">
    <PageTable />
    <MypageComment />
    <MypagePost />
  </div>
  )
}

export default App;


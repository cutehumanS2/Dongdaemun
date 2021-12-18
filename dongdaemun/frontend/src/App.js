import React from 'react';
import "./css/App.css";
import LandingPage from "./landingPage";
import NavBar from "./navBar";
import ReadPost from "./readPost.js";

function App() {
  return (
    <div className="App">
      <NavBar/>
      <ReadPost></ReadPost>

    </div>
  );
}

export default App;

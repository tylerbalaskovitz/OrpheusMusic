import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import {Login} from './Components/Login/Login';
import {Register} from "./Components/Register/Register";
import {HomePage} from "./Components/HomePage";
// import {Albums} from "./Components/Products/Albums";

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Router>
          <Routes>
            <Route path ="/" element={<Login/>}/>
          </Routes>
          <Routes>
            <Route path="/register" element={<Register/>}/>
        </Routes>
          <Routes>
            <Route path="/home" element={<HomePage/>}/>
          </Routes>

        </Router>
    
      </header>
    </div>
  );
}

export default App;
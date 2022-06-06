import React from 'react';
import logo from './logo.svg';
import './App.css';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
<<<<<<< HEAD
import {Login} from './Components/Login/Login';
import {Register} from "./Components/Register/Register";
import {HomePage} from "./Components/HomePage";
=======
import { Login } from './Components/Login/Login';
>>>>>>> 111e0995801b31965e0e2a708e33df9c34521155

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Router>
<<<<<<< HEAD
          <Routes>
            <Route path ="/" element={<Login/>}/>
          </Routes>
          <Routes>
            <Route path="/register" element={<Register/>}/>
        </Routes>
          <Routes>
            <Route path="/home" element={<HomePage/>}/>
          </Routes>
=======
          <Routes path ="/" element={<Login/>}/>
        </Routes>
>>>>>>> 111e0995801b31965e0e2a708e33df9c34521155
        </Router>
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}
import React, { useEffect, useState } from "react";
import { useDispatch, useSelector } from "react-redux";
import { useNavigate } from "react-router-dom";



export const HomePage: React.FC <any> = () => {

const navigate = useNavigate();

const handleChange = (e:any) => {
    if (e.target.name === "logout") {
        navigate("/")
    }

    return (
        <div>
            <input type="text" placeholder="Search..."></input>
        </div>

    <div>
        <button id="logout-button" name="logout" onClick={handleChange}>LOG OUT</button>
    </div>
)

}
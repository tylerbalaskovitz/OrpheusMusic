import {configureStore} from "@reduxjs/toolkit";
import reducer from "../Reducers/index";
import { AppState } from "./types";

const initialState:AppState = {
    user: {
        user_id:0,
        first_name:"",
        last_name:"",
        email:"",
        username:"",
        password:"",
        phone:0
    }}

export const store = configureStore({
    reducer
})
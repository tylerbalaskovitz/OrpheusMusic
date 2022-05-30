import {configureStore} from "@reduxjs/toolkit";
import reducer from "../Reducers/index";
import { AppState } from "./types";

const initialState:AppState = {
    user: {
        id:0,
        username:"",
        password:""
    },
    
}

export const store = configureStore({
    reducer
})
import { LOGIN_USER } from "../Actions/ActionTypes";
import { IUser } from "../Store/types";

let initialState:IUser = {
    id:0,
    username:"",
    password:"",
}
type Action = {type:string, payload:any};

export const LoginReducer = (state:IUser = initialState, action: Action) => {
}
import axios from "axios";
import { IUser } from "../Store/types"
import { LOGIN_USER } from "./ActionTypes";
interface  UserLogin {
    username: string,
    password: string
}

export const loginUser = (loginCreds:UserLogin) => async (dispatch:any) => {
    let loggedInUser: IUser;
}
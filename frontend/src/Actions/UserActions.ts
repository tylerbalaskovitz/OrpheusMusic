import axios from "axios";
import { IUser } from "../Store/types";
import { LOGIN_USER_FAILURE, LOGIN_USER_SUCCESS, REGISTER_USER_FAILURE, REGISTER_USER_SUCCESS } from "./actionTypes";
export interface UserLogin {
    username: string,
    password: string
}

export interface RegisterUser {
    first_name: string,
    last_name: string,
    email: string,
    username: string,
    password: string,
    phone: number
}

export const loginUser = (loginCreds: UserLogin) =>  async (dispatch: any) => {
    let loggedInUser: IUser;
    try {

        const response = await axios.post('http://localhost:8080/login', loginCreds);

        if (response.status === 202) {

            console.log(response);

            loggedInUser = {
                user_id: response.data.user_id,
                first_name: response.data.first_name,
                last_name: response.data.last_name,
                email: response.data.email,
                username: response.data.username,
                password: response.data.password,
                phone: response.data.phone
            }

            return dispatch({
                type: LOGIN_USER_SUCCESS,
                payload: loggedInUser
            })
        }
    } catch (error) {
        return dispatch({
            type: LOGIN_USER_FAILURE,
            payload: error
        })
    }

}

export const registerUser = (userCreds: RegisterUser) => async (dispatch:any) => {
    try {
        let newUser: RegisterUser = {} as RegisterUser;
        const response = await axios.post('http://localhost:8080/register', userCreds);
        if (response.status === 201) {
            console.log(response);
            newUser = {
                ...response.data
            }
        }
        return dispatch({
            type: REGISTER_USER_SUCCESS,
            payload: newUser,
        })
    } catch (error) {
        console.log("REGISTER FAILED!")
        return dispatch({
            type: REGISTER_USER_FAILURE,
            payload: error,
        })
    }
}
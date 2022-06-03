import { LOG_OUT_USER } from "../Actions/actionTypes";
import { IUser } from "../Store/types";

const initialState:IUser = {
    user_id: 0,
    first_name: "",
    last_name: "",
    email: "",
    username: "",
    password: "",
    phone: 0
}

type Action = {type:string, payload:any};

export const UserReducer = (state:IUser = initialState, action: Action) => {

    switch(action.type) {

        case LOG_OUT_USER:
            return initialState;
        default:
            return state
    }
}

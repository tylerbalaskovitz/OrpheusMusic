import { UserReducer } from "./UserReducer";
import { combineReducers } from "redux";

import { LoginReducer } from "./LoginReducer";

export default combineReducers({
    user:LoginReducer,
    user:UserReducer
    

})
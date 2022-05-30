import React, { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux"
import { useNavigate } from "react-router-dom"
import { loginUser } from "../Actions/Login"

export const Login: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);
    const dispatch = useDispatch();

    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');

    const navigate = useNavigate();

    const handleChange = (e:any) => {
        if(e.target.name === "username"){ 
            setUsername(e.target.value) 
        } else {
            setPassword(e.target.value) 
        }
    }

    const login = async () => {
        await dispatch(
            loginUser({username, password}) as any
            
        )
    }

    const register = () => {
        navigate("/register");
    }

    useEffect(() => {
        if(appState.user.id > 0){
            alert("Logged in successfully!")
            navigate("/home"); 
        }
    }, [appState])


    return(
    
       
       <div className="login">
             
             
        <header>
        <div>
            </div>

        </header>
<body className="loginBody">
            <div className="text-container">
                <h1>Welcome To Orpheus!</h1>
                <h3>Please login</h3>

                <div className="input-container">
                    <input type="text" name="username" placeholder="username" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="password" name="password" placeholder="password" onChange={handleChange}/>
                </div>

                <button className="login-button" onClick={login}>Login</button>
                <button className="register-button" onClick={register}>Register</button>
            </div>
            </body>
        </div>
       
    )

} 
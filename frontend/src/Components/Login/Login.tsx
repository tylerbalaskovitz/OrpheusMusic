import React, { useEffect, useState } from "react"
import { useDispatch, useSelector } from "react-redux"
import { useNavigate } from "react-router-dom"
import { loginUser } from "../../Actions/UserActions"

export const Login: React.FC<any> = () => {

    const appState = useSelector<any, any>((state) => state);

    const dispatch = useDispatch();

    let [username, setUsername] = useState('');
    let [password, setPassword] = useState('');

    const navigate = useNavigate();

    const handleChange = (e:any) => {
        if(e.target.name === "username") {
            setUsername(e.target.value)
            console.log(username)
        } else {
            setPassword(e.target.value)
        }
        if (e.target.name === "signup-button") {
            navigate("/register")
        }
    }

    const login = async () => {
        await dispatch(
            loginUser({username, password}) as any
        )

    }

    useEffect(() => {
        if (appState.user.id > 0) {
            navigate("/home");
        }
    }, [appState.user.id])


    return (
        <img src="https://user-images.githubusercontent.com/102433425/171229552-93909e1e-24b0-4ca6-8510-2286dead5575.png">
                <h3>Please login:</h3>

                <div className="input-container">
                    <input type="text" name="username" placeholder="username" onChange={handleChange}/>
                </div>
                <div className="input-container">
                    <input type="password" name="password" placeholder="password" onChange={handleChange}/>
                </div>

                <button className="login-button" onClick={login}>Login</button>
                <button className="register-button" onClick={register}>Register</button>


    )
    }

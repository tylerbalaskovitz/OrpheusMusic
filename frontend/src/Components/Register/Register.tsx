import React, { useState } from 'react';
import { useDispatch, useSelector } from "react-redux"
import { useNavigate } from 'react-router-dom';
import { RegisterUser, registerUser } from '../../Actions/UserActions';

export const Register: React.FC<any> = () => {

    const [user, setUser] = useState({});
    const dispatch = useDispatch();
    const navigate = useNavigate();

    const handleChange = (e: any) => {
        const updatedUser = {
            ...user,
            [e.target.name]: e.target.value
        };
        setUser(updatedUser);
    }

    const register = async () => {
        console.log('User ', user);
        const response = await dispatch(
            registerUser(user as RegisterUser) as any
        )
        console.log('Response: ', response);
        navigate('/HomePage');
    }

    return (
        
   <div className="login">
   <header>
       <h1>WELCOME TO ORPHEUS MUSIC</h1>
   </header>
<body>
   <div className="text-container">
       <h3>FILL OUT THE FIELDS BELOW TO REGISTER</h3>

       <div className="input-container1">
           <p className='form-animation'>FIRST NAME:</p>
           <input className='input-form-borders' type="first_name" name="first_name" id="first_name" onChange={handleChange} />
       </div>
       
     
     
     <div className="input-container2">
           <p className='form-animation'>LAST NAME:</p>
           <input className='input-form-borders' type="last_name" name="last_name" id="last_name" onChange={handleChange} />
       </div>
       
     
     
     <div className="input-container3">
           <p className='form-animation'>EMAIL:</p>
           <input className='input-form-borders' type="email" name="email" id="email" onChange={handleChange} />
       </div>
       
     
     
     <div className="input-container4">
           <p className='form-animation'>USERNAME:</p>
           <input className='input-form-borders' type="username" name="username" id="username" onChange={handleChange} />
       </div>
       
     
     
     <div className="input-container5">
           <p className='form-animation'>PASSWORD:</p>
           <input className='input-form-borders' type="password" name="password" onChange={handleChange} />
       </div>
       
     
     
     <div className='sign-up-div'>
           <button className="login-button" onClick={register}>SIGN UP</button>
       </div>


     
     
     <img src="https://user-images.githubusercontent.com/102433425/171229552-93909e1e-24b0-4ca6-8510-2286dead5575.png" alt="orpheus logo"></img>
                </div>
                </body>
            </div>
);}

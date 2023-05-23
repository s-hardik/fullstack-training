import React from "react";
import { useNavigate, useLocation, Link } from "react-router-dom";
import "./Login.css";
import logo from "../../assets/logo.png";
import {
  auth,
  logInWithEmailAndPassword,
  registerWithEmailAndPassword,
} from "../../firebase/firebase";
import { useEffect, useState } from "react";
import firebase from "../../firebase/firebase";
import  {login, register}  from "../../service/AuthService";

const Login = ({ setUser }) => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [error, serError]  = useState("");
  const [role, serRole]  = useState([]);
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const pathName = useLocation().pathname;
  const submitHandler = async () => {

    //Uncomment below code to use firebase Authentication

    // const signInMethod = await firebase
    //   .auth()
    //   .fetchSignInMethodsForEmail(email);
    // if (signInMethod.length > 0) {
    //   const res = logInWithEmailAndPassword(email, password);
    //   const token = await res.then((data) => data._tokenResponse.idToken); //TOFO: Session based login is pending
    //   localStorage.setItem("token", token);
    // } else {
    //   registerWithEmailAndPassword(email, password);
    // }

    //Authentication using Spring Boot, Spring Security
  if(pathName.includes("register")){
    const data = await register(email, userName, password, role);
    
    if(!data.error)
    {
      navigate("/");
      console.log("User Registered Successfully");
    }
  }
  else{
    const data = await login(userName, password);
    if(!data.error)
    {
      setUser({
        uid: "",
        email: data.email,
        name: data.username, 
      });
      
      if(data.roles.includes("ADMIN")){
        navigate("/dashboard");
      }
      else{
        navigate("/user-dashboard");
      }
      
      console.log("User Logged In");
      
    }
    else{
      serError(data.message);
    }
  }
  };


  return (
    <div className="formwarp">
      <div className="login-register">
        <div className="login form">
          <form id="login" className="active" action="">
            <div className="form-header">
              <img src={logo} alt="logo" />
             
              <h4>Sign In</h4>
              {error ? <p className="error-message">{error} Please Check Username Password Again</p>:""}
            </div>
            {pathName.includes("register")?<> <div className="form-group">
              <label htmlFor="email">Email</label>
              <input
                type="text"
                id="email"
                placeholder="Email"
                onChange={(e) => setEmail(e.target.value)}
              />
            </div>
             <div className="form-group">
             <label htmlFor="role">Roles</label>
             <input
               type="text"
               id="role"
               placeholder="Role"
               onChange={(e) => serRole(e.target.value)}
             />
           </div></>: "" }
            <div className="form-group">
              <label htmlFor="username">Username</label>
              <input
                type="text"
                id="username"
                placeholder="Username"
                onChange={(e) => setUserName(e.target.value)}
              />
            </div>
            <div className="form-group">
              <label htmlFor="password">Password</label>
              <input
                type="password"
                id="password"
                placeholder="Password"
                onChange={(e) => setPassword(e.target.value)}
              />
            </div>

            <div className="btn">
              <input type="button" value={pathName.includes("register")? "Register User" : "Sign In"} onClick={submitHandler} />
            </div>
          </form>
          
          {
            pathName.includes("register")? "" :<><h4>New User?? </h4> <Link to="/register">Register Here</Link></>
          }
          
        </div>
      </div>
    </div>
  );
};

export default Login;

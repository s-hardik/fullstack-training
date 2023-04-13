import React from "react";
import { useNavigate } from "react-router-dom";
import "./Login.css";
import logo from "../../assets/logo.png";
import {
  auth,
  logInWithEmailAndPassword,
  registerWithEmailAndPassword,
} from "../../firebase/firebase";
import { useAuthState } from "react-firebase-hooks/auth";
import { useEffect, useState } from "react";
import firebase from "../../firebase/firebase";
const Login = ({ setUser }) => {
  const navigate = useNavigate();
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const submitHandler = async () => {
    const res = logInWithEmailAndPassword(email, password);
    const token = await res.then( (data) => data._tokenResponse.idToken);
    localStorage.setItem("token", token);

    //navigate("/dashboard");
  };

  useEffect(() => {
    let isMounted = true;

    firebase.auth().onAuthStateChanged((user) => {
      // setIsLoggedIn(!!user)
      if (user && isMounted) {
        if (user.uid)
          setUser({
            uid: firebase.auth().currentUser.uid,
            email: firebase.auth().currentUser.email,
          });

        console.log("User Logged In");
      } else {
        console.log("User Signed Out");
        setUser({});
      }
      console.log("auth change");
      if (isMounted) return;
    });
    return () => (isMounted = false);
  }, [setUser]);

  return (
    <div className="formwarp">
      <div className="login-register">
        <div className="login form">
          <form id="login" className="active" action="">
            <div className="form-header">
              <img src={logo} alt="logo" />
              <h4>Sign In</h4>
            </div>
            <div className="form-group">
              <label htmlFor="email">Email</label>
              <input
                type="text"
                id="email"
                placeholder="Email"
                onChange={(e) => setEmail(e.target.value)}
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
              <input type="button" value="Sign In" onClick={submitHandler} />
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Login;

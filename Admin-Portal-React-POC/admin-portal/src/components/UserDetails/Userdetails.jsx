import React from 'react'
import { useState } from 'react'
import { useEffect } from 'react'
import {getEmployeeByEmailId} from '../../service/EmployeeService';
import { logout } from "../../service/AuthService";
import logo from "../../assets/logo.png";
const Userdetails = ({user}) => {
    const [empDetails, setEmpDetails] = useState({});
    const logoutHandler = ()=>{
        logout();
      }
    console.log(user);
    useEffect(()=>{
        getEmployeeByEmailId(user.email).then(res=>{
            setEmpDetails(res);
            console.log(res);
        }).catch(err=>{
            console.log(err);
        })
    },[])
  return (
    <>
    <header>
        <div className="nav-logo">
          <img src={logo} alt="" />
        </div>
        <nav>
          <ul>
            <li>
              <h4>{user.name}</h4>
            </li>
            <li>
              <a href="/" onClick={logoutHandler}>Logout</a>
            </li>
          </ul>
        </nav>
      </header>
      <main>
        <div className="dashboard-heading">
          <h3>Your Details</h3>
        </div>
        <div>
            {
                empDetails? JSON.stringify(empDetails) : <p>No Details Found. Please Check With Admin!</p>
            }
        </div>
      </main>
    </>
  )
}

export default Userdetails

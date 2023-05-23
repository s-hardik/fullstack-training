import React, { useEffect } from "react";
import "./EmployeeDetails.css";
import logo from "../../assets/logo.png";
import EmpTable from "./EmpTable";
import { useNavigate } from "react-router-dom";
import { logout } from "../../service/AuthService";

const EmployeeDetails = ({user}) => {
  const logoutHandler = ()=>{
    logout();
  }
  const navigate = useNavigate();
  const addEmploHandler = () => {
    navigate("/addnew");
  };
  useEffect(()=>{
  },[])
  return (
    <div>
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
          <h3>Employee Details</h3>
          <div className="btn">
            <input type="button" value="Add" onClick={addEmploHandler} />
          </div>
        </div>
        <EmpTable />
      </main>
    </div>
  );
};

export default EmployeeDetails;

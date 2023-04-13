import React from "react";
import "./EmployeeDetails.css";
import logo from "../../assets/logo.png";
import EmpTable from "./EmpTable";
import { useNavigate } from "react-router-dom";
import { logout } from "../../firebase/firebase";
const EmployeeDetails = () => {
  const logoutHandler = ()=>{
    logout();
    navigate('/')
  }
  const navigate = useNavigate();
  const addEmploHandler = () => {
    navigate("/addnew");
  };
  return (
    <div>
      <header>
        <div className="nav-logo">
          <img src={logo} alt="" />
        </div>
        <nav>
          <ul>
            <li>
              <a href="/">Name</a>
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

import { Routes, Route, Link } from "react-router-dom";
import "./App.css";
import Login from "./components/Login";
import EmployeeDetails from "./components/EmployeeDetails";
import NotFoundPage from "./components/NotFoundPage";
import AddNew from "./components/EmployeeDetails/AddNew";
import { useState, useEffect } from "react";
import firebase from "./firebase/firebase";


function App() {
  const [user, setUser] = useState({});

  return (
    <Routes>
      <Route path="/" element={<Login setUser={setUser} />} />
      <Route path="/dashboard" element={<EmployeeDetails setUser={setUser} user={user}/>} />
      <Route path="/addnew" element={<AddNew />} />
      <Route path="/update/:id" element={<AddNew />} />
	    <Route path="/*" element={<NotFoundPage/>} />
    </Routes>
  );
}

export default App;

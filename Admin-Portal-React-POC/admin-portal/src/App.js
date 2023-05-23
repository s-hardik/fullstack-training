import { Routes, Route, Link } from "react-router-dom";
import "./App.css";
import Login from "./components/Login";
import EmployeeDetails from "./components/EmployeeDetails";
import NotFoundPage from "./components/NotFoundPage";
import AddNew from "./components/EmployeeDetails/AddNew";
import { useState, useEffect } from "react";
import firebase from "./firebase/firebase";
import PrivateRoute from "./PrivateRoute";
import Userdetails from "./components/UserDetails/Userdetails";

function App() {
  const [user, setUser] = useState({});

  return (
    <Routes>
      <Route path="/" element={<Login setUser={setUser} />} />
      <Route path="/register" element={<Login setUser={setUser} />} />
      <Route path="/dashboard" element={
       <PrivateRoute roles={["ADMIN"]}>
      <EmployeeDetails setUser={setUser} user={user}/>
      </PrivateRoute>
      } />
      <Route path="/addnew" element={
      <PrivateRoute roles={["ADMIN"]}>
      <AddNew />
      </PrivateRoute>
      } />
      <Route path="/update/:id" element={
      <PrivateRoute roles={["ADMIN"]}>
      <AddNew />
      </PrivateRoute>
      } />
      <Route
        path="/user-dashboard"
        element={
          <PrivateRoute roles={["USER"]}>
          <Userdetails user={user} setUser={setUser}/>
          </PrivateRoute>
        }
      />
	    <Route path="/*" element={<NotFoundPage/>} />
    </Routes>
  );
}

export default App;

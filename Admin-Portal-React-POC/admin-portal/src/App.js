import { Routes, Route, Link } from "react-router-dom";
import "./App.css";
import Login from "./components/Login";
import EmployeeDetails from "./components/EmployeeDetails";
import NotFoundPage from "./components/NotFoundPage";
import AddNew from "./components/EmployeeDetails/AddNew";
import { useState, useEffect } from "react";
import firebase from "./firebase/firebase";
import { getDatabase, ref, set } from "firebase/database";

function App() {
  const [user, setUser] = useState({});
  console.log(user);

  useEffect(() => {
		const createUserInDB = async () => {
			if (user.uid)
				if (
					firebase.auth().currentUser.metadata.lastSignInTime ===
					firebase.auth().currentUser.metadata.creationTime
				) {
					try {
            await fetch('https://admin-portal-98df5-default-rtdb.firebaseio.com/users', {
							method: 'POST',
							body: JSON.stringify({
								uid: user.uid,
								email: user.email,
							}),
							headers: {
								'Content-Type': 'application/json',
							},
						});

						console.log('posted');
					} catch (error) {
						console.log('User Creation Error: ', error);
					}
				}
		};
		createUserInDB();		
	}, [user]);


  return (
    <Routes>
      <Route path="/" element={<Login setUser={setUser} />} />
      <Route path="/dashboard" element={<EmployeeDetails />} />
      <Route path="/addnew" element={<AddNew />} />
    </Routes>
  );
}

export default App;

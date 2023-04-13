import firebase from "firebase/compat/app";
import "firebase/compat/auth";
import 'firebase/compat/firestore';
import { getDatabase } from "firebase/database";
import {
  signInWithEmailAndPassword,
  createUserWithEmailAndPassword,
  signOut,
} from "firebase/auth";
const firebaseConfig = {
	apiKey: "AIzaSyDJCvJEXMC2hAYhFNqhLsJmNy_KkXHrrTo",
	authDomain: "admin-portal-98df5.firebaseapp.com",
	databaseURL: "https://admin-portal-98df5-default-rtdb.firebaseio.com/",
	projectId: "admin-portal-98df5",
	storageBucket: "admin-portal-98df5.appspot.com",
	messagingSenderId: "1089305017876",
	appId: "1:1089305017876:web:c497f74cd07b20cdd0b101"
  };
const app = firebase.initializeApp(firebaseConfig);
export const auth = firebase.auth(app);
export const database = getDatabase(app);

export const logInWithEmailAndPassword = async (email, password) => {
	try {
	const res = await signInWithEmailAndPassword(auth, email, password);
	return res;
	} catch (err) {
	  console.error(err);
	  alert(err.message);
	}
  };
  export const registerWithEmailAndPassword = async (email, password) => {
	try {
	  const res = await createUserWithEmailAndPassword(auth, email, password);
	  const user = res.user;
	//   await addDoc(collection(db, "users"), {
	// 	uid: user.uid,
	// 	name,
	// 	authProvider: "local",
	// 	email,
	//   });
	} catch (err) {
	  console.error(err);
	  alert(err.message);
	}
  };
 export  const logout = () => {
	signOut(auth);
  };
export default firebase;

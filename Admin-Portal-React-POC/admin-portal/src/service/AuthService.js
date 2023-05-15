import axios from "axios";

const API_URL = "http://localhost:8080/";

export const register = (email, userName, password, roles) => {

  return axios.post(API_URL + "register", {
    email,
    userName,
    password,
    roles: roles.split(" ")
  });
};

export const login =  async (userName, password) => {
  try{
    const response =  await axios.post(API_URL + "authenticate", {
      userName,
      password,
    });
    if (response.data.token) {
      localStorage.setItem("token", JSON.stringify(response.data.token).replace(/^"(.*)"$/, '$1'));
      axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;
    }
    return response.data;
  }
  catch(error){
   return error.response.data;
  }
    
  };

export const logout = () => {
    localStorage.removeItem("token");
    return axios.post(API_URL + "signout").then((response) => {
      return response.data;
    });
  };
  
export const getCurrentUser = () => {
    return JSON.parse(localStorage.getItem("user"));
  };
  
 
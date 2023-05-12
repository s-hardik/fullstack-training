import axios from "axios";

const API_URL = "http://localhost:8080/";

const register = (username, password, role) => {
  return axios.post(API_URL + "register", {
    username,
    password,
    role
  });
};

export const login =  async (userName, password) => {
    const response =  await axios.post(API_URL + "authenticate", {
        userName,
        password,
      });
      if (response.data.token) {
        localStorage.setItem("token", JSON.stringify(response.data.token));
        axios.defaults.headers.common['Authorization'] = `Bearer ${localStorage.getItem('token')}`;

      }
      return response.data.token;
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
  
 
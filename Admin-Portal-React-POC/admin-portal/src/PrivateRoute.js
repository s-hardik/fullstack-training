import { Navigate, Route, useLocation } from 'react-router-dom';
import NotFoundPage from "./components/NotFoundPage";
import Unauthorized from './components/UnauthorizedPage/Unauthorized';
const ROLE = ["ADMIN", "USER"]
const PrivateRoute = ({
  children,
  roles,
}) => {
  let location = useLocation();
  const isAuthenticated = localStorage.getItem("token");
  const  user_roles = localStorage.getItem("user_roles");

  const userHasRequiredRole = isAuthenticated && user_roles.includes(roles) ? true : false;
   
  if (!isAuthenticated) {
    return <Navigate to="/" state={{ from: location }} />;
  }

  if (isAuthenticated && !userHasRequiredRole) {
    return <Unauthorized/>; // build your won access denied page (sth like 404)
  }

  return children;
};

export default PrivateRoute;
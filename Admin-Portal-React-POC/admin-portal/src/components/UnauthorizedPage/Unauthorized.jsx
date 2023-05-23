import React from "react";
import "./Unauthorized.css";

const Unauthorized = () => {
  return (
   
      <div className="Unauth-div w3-display-middle">
        <h1 className=" Unauth-div-h1 w3-jumbo w3-animate-top w3-center">
          <code>Access Denied</code>
        </h1>
        <hr
          className="Unauth-div-hr w3-border-white w3-animate-left"
        />
        <h3 className="Unauth-div-h3 w3-center w3-animate-right">
          You dont have permission to view this site.
        </h3>
        <h3 className="Unauth-div-h3 w3-center w3-animate-zoom">🚫🚫🚫🚫</h3>
        <h6 className="Unauth-div-h6 w3-center w3-animate-zoom">
          <strong>Error Code</strong>: 403 forbidden
        </h6>
      </div>
   
  );
};

export default Unauthorized;

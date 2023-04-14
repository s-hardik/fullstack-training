import React from "react";
import "./AddNew.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
const AddNew = () => {
  const navigate = useNavigate();
  const [empData, setEmpdata] = useState({
    firstName: "",
    middleName: "",
    lastName: "",
    contactNumber: "",
    emergencyNumber: "",
    email: "",
    panNo: "",
    bloodGroup: "",
    presentAddress: "",
    permanentAddress: "",
  });
  let name, value;
  const postUserData = (event) => {
    name = event.target.name;
    value = event.target.value;

    setEmpdata({...empData, [name] : value});
  };
  const addNewEmployee = async (event) => {
    event.preventDefault();
    const {firstName,
      middleName,
      lastName,
      contactNumber,
      emergencyNumber,
      email,
      panNo,
      bloodGroup,
      presentAddress,
      permanentAddress} = empData;

      if(firstName &&
        middleName &&
        lastName &&
        contactNumber &&
        emergencyNumber &&
        email &&
        panNo &&
        bloodGroup &&
        presentAddress &&
        permanentAddress){
          const res = await fetch(
            "https://admin-portal-98df5-default-rtdb.firebaseio.com/employee.json",
            {
              method: "POST",
              body: JSON.stringify(empData),
              headers: {
                "Content-Type": "application/json",
              },
            }
          );
          if(res){
            setEmpdata({
              firstName: "",
              middleName: "",
              lastName: "",
              contactNumber: "",
              emergencyNumber: "",
              email: "",
              panNo: "",
              bloodGroup: "",
              presentAddress: "",
              permanentAddress: "",
            })
            alert("Data Submitted!!");
          }
          else{
            alert("Data Submission Failed Please Try Again");
          }
        navigate("/dashboard");
        }else{
          alert("Please fill all the data!!")
        } 
  };
  const cancleForm = () => {
    navigate("/dashboard");
  };
  return (
    <>
      <div className="container">
        <div id="frm_contact_us">
          <h2>Add New Employee</h2>
          <br />
          <div id="mail-status" className="success-msg"></div>

          <label htmlFor="firstName">First Name</label>
          <input
            type="text"
            id="fname"
            name="firstName"
            value={empData.firstName}
            onChange={postUserData}
            className="input_box"
            required
          />
          <label htmlFor="middleName">Middle Name</label>
          <input
            type="text"
            id="mname"
            name="middleName"
            value={empData.middleName}
            onChange={postUserData}
            className="input_box"
            required
          />

          <label htmlFor="lastName">Last Name</label>
          <input
            type="text"
            id="lname"
            name="lastName"
            value={empData.lastName}
            onChange={postUserData}
            className="input_box"
            required
          />

          <label htmlFor="contactNumber">Contact Number</label>
          <input
            type="text"
            id="contact"
            name="contactNumber"
            value={empData.contactNumber}
            onChange={postUserData}
            className="input_box"
            required
          />

          <label htmlFor="emergencyNumber">Emergency Contact Number</label>
          <input
            type="text"
            id="Econtact"
            name="emergencyNumber"
            value={empData.emergencyNumber}
            onChange={postUserData}
            className="input_box"
            required
          />
          <label htmlFor="email">Email Address</label>
          <input
            type="text"
            id="email"
            name="email"
            value={empData.email}
            onChange={postUserData}
            className="input_box"
            required
          />

          <label htmlFor="panNo">PAN Card No</label>
          <input
            type="text"
            id="PANno"
            name="panNo"
            value={empData.panNo}
            onChange={postUserData}
            className="input_box"
            required
          />

          <label htmlFor="bloodGroup">Blood Group</label>
          <input
            type="text"
            id="BloodG"
            name="bloodGroup"
            value={empData.bloodGroup}
            onChange={postUserData}
            className="input_box"
          />
          <label htmlFor="presentAddress">Present Address</label>
          <input
            type="text"
            id="PresentAdd"
            name="presentAddress"
            className="input_box"
            value={empData.presentAddress}
            onChange={postUserData}
            required
          />
          <label htmlFor="permanentAddress">Permanent Address</label>
          <input
            type="text"
            id="PermanentAdd"
            name="permanentAddress"
            className="input_box"
            value={empData.permanentAddress}
            onChange={postUserData}
            required
          />
          <div className="add-btn">
            <input type="submit" value="Submit" onClick={addNewEmployee} />
            <input type="submit" value="Cancle" onClick={cancleForm} />
          </div>
        </div>
      </div>
    </>
  );
};

export default AddNew;

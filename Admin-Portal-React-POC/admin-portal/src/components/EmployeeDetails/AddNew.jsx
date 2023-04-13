import React from "react";
import "./AddNew.css";
import { useNavigate } from "react-router-dom";
const AddNew = () => {
  const navigate = useNavigate();
  const addNewEmployee = () => {
    navigate('/dashboard')
  };
  const cancleForm = () => {
    navigate('/dashboard')
  };
  return (
    <>
      <div class="container">
        <div id="frm_contact_us">
          <h2>Add New Employee</h2>
          <br />
          <div id="mail-status" class="success-msg"></div>

          <label for="fname">First Name</label>
          <input type="text" id="fname" name="fname" class="input_box" />
          <label for="mname">Middle Name</label>
          <input type="text" id="mname" name="mname" class="input_box" />

          <label for="lname">Last Name</label>
          <input type="text" id="lname" name="lname" class="input_box" />

          <label for="contact">Contact Number</label>
          <input type="text" id="contact" name="contact" class="input_box" />

          <label for="Econtact">Emergency Contact Number</label>
          <input type="text" id="Econtact" name="Econtact" class="input_box" />
          <label for="email">Email Address</label>
          <input type="text" id="email" name="email" class="input_box" />

          <label for="PANno">PAN Card No</label>
          <input type="text" id="PANno" name="PANno" class="input_box" />

          <label for="BloodG">Blood Group</label>
          <input type="text" id="BloodG" name="BloodG" class="input_box" />
          <label for="PresentAdd">Present Address</label>
          <input
            type="text"
            id="PresentAdd"
            name="PresentAdd"
            class="input_box"
          />
          <label for="PermanentAdd">Permanent Address</label>
          <input
            type="text"
            id="PermanentAdd"
            name="PermanentAdd"
            class="input_box"
          />
          <div id="message-info" class="info1"></div>

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

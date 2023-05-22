import React, { useEffect } from "react";
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";
import AddTodoForm from "./AddTodoForm";
import { useState } from "react";
import { saveTaskData } from "../../Service/TaskService";
import { useLocation } from "react-router-dom";
import e from "express";
const TodoDetailsModals = ({ modal, toggle }) => {
  
  let curr = new Date();
  const location = useLocation();
  var date = curr.toISOString().substring(0, 10).split("/").join("-");
  const [taskData, setTaskData] = useState({
    taskName: "",
    createdDate: date,
    status: "",
    finishTragetDate: "",
    taskDescription: "",
  });
  const saveTask = async (event) => {
    event.preventDefault();
    const res = await saveTaskData(taskData);
    console.log(res);
    setTaskData({
      taskName: "",
      createdDate: date,
      status: "",
      finishTragetDate: "",
      taskDescription: "",
    });
    toggle();
  };
  useEffect(()=>{
     
  },[taskData])
  return (
    <div>
      <Modal isOpen={modal} toggle={toggle} centered>
        <ModalHeader toggle={toggle}>Create Task</ModalHeader>
        <ModalBody>
          <AddTodoForm setTaskData={setTaskData} taskData={taskData} />
        </ModalBody>
        <ModalFooter>
          <Button color="primary" onClick={saveTask}>
            Create
          </Button>{" "}
          <Button color="secondary" onClick={toggle}>
            Cancel
          </Button>
        </ModalFooter>
      </Modal>
    </div>
  );
};

export default TodoDetailsModals;

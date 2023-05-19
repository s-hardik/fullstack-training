import React from "react";
import { useState, useEffect } from "react";
import "./TodoList.css";
import TodoDetailsModals from "./Modals/TodoDetailsModals";
import TodoCard from "./TodoCard";
import { Container, Row } from "reactstrap";
const TodoList = () => {
  const [modal, setModal] = useState(false);
  const [taskList, setTaskList] = useState([]);

  const saveTask = (taskObj) => {
    let tempTaksList = taskList;
    tempTaksList.push(taskObj);
    localStorage.setItem("taskList", JSON.stringify(tempTaksList));
    setTaskList(tempTaksList);
  };
  const toggle = () => setModal(!modal);
  useEffect(() => {
    let taskArr = localStorage.getItem("taskList");
    let obj = JSON.parse(taskArr);
    if (obj) {
      setTaskList(obj);
    }
  }, []);
  return (
    <>
      <div className="header text-center">
        <h3>Todo List</h3>
        <button className="btn btn-primary mt-2" onClick={() => setModal(true)}>
          Create Task
        </button>
      </div>
      <Container>
      <Row xs="4">
        {taskList.map((task) => (
          <TodoCard  task={task} />
        ))}
        </Row>
      </Container>
      <TodoDetailsModals toggle={toggle} modal={modal} save={saveTask} />
    </>
  );
};

export default TodoList;

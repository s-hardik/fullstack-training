import React from "react";
import { useState, useEffect } from "react";
import "./TodoList.css";
import TodoDetailsModals from "./Modals/TodoDetailsModals";
import TodoCard from "./TodoCard";
import { getAllTask } from "../Service/TaskService";
import { Container, Row } from "reactstrap";
const TodoList = () => {
  const [modal, setModal] = useState(false);
  const [taskList, setTaskList] = useState([]);
  const toggle = () => setModal(!modal);

  useEffect(() => {
    getAllTask()
      .then((data) => {
        setTaskList(data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [modal]);
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
            <TodoCard key={task.taskId} task={task} toggle={toggle} />
          ))}
        </Row>
      </Container>
      <TodoDetailsModals
        toggle={toggle}
        modal={modal}
       
      />
    </>
  );
};

export default TodoList;

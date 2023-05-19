import React from 'react'
import { Button, Modal, ModalHeader, ModalBody, ModalFooter } from 'reactstrap';
import AddTodoForm from './AddTodoForm';
import { useState } from 'react';
const TodoDetailsModals = ({modal, toggle, save}) => {
    let curr = new Date();
    var date = curr.toISOString().substring(0,10).split("/").join("-");
    const [taskData, setTaskData] = useState({
        taskName: "",
        createdDate: date,
        status: "",
        finishTragetDate: "",
        taskDescription: "",
      });
      const saveTask = async (event) => {
        event.preventDefault();
        save(taskData);
        //send request to save the task data
        //navigate to dashboad page(TodoList Page)
        toggle();
      };
  return (
    <div>
      <Modal isOpen={modal} toggle={toggle} centered>
        <ModalHeader toggle={toggle}>Create Task</ModalHeader>
        <ModalBody>
            <AddTodoForm setTaskData={setTaskData} taskData={taskData}/>
        </ModalBody>
        <ModalFooter>
          <Button color="primary" onClick={saveTask}>
           Create
          </Button>{' '}
          <Button color="secondary" onClick={toggle}>
            Cancel
          </Button>
        </ModalFooter>
      </Modal>
    </div>
  )
}

export default TodoDetailsModals

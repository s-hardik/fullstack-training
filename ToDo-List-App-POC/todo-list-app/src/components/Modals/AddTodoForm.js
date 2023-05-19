import React from "react";
import { Form, FormGroup, Input, Label } from "reactstrap";
const AddTodoForm = ({taskData, setTaskData}) => {
  let name, value;
  const postTaskData = (event) => {
    name = event.target.name;
    value = event.target.value;
    setTaskData({ ...taskData, [name]: value });
  };
  
  return (
    <div>
      <Form>
        <FormGroup floating>
          <Input
            id="taskName"
            className="mb-3"
            name="taskName"
            value={taskData.taskName}
            onChange={postTaskData}
            placeholder="Task Name"
            type="text"
          />
          <Label for="taskName">Task name</Label>
        </FormGroup>{" "}
        <FormGroup floating>
          <Input
            id="createdDate"
            className="mb-3"
            name="createdDate"
            value={taskData.createdDate}
            onChange={postTaskData}
            placeholder="Date of creation"
            type="date"
          />
          <Label for="createdDate">Created Date</Label>
        </FormGroup>{" "}
        <FormGroup tag="fieldset">
          <legend>Task Status</legend>
          <FormGroup check>
            <Input name="status" value="To-Do" type="radio" onChange={postTaskData} />{" "}
            <Label check>To-Do</Label>
          </FormGroup>
          <FormGroup check>
            <Input name="status" value="Doing" type="radio" onChange={postTaskData}/>{" "}
            <Label check>Doing</Label>
          </FormGroup>
          <FormGroup check>
            <Input name="status" value="Done" type="radio" onChange={postTaskData}/>{" "}
            <Label check>Done</Label>
          </FormGroup>
        </FormGroup>
        <FormGroup floating>
          <Input
            id="finishTragetDate"
            className="mb-3"
            name="finishTragetDate"
            value={taskData.finishTragetDate}
            onChange={postTaskData}
            placeholder="End target Date"
            type="date"
          />
          <Label for="finishTragetDate">Finish Target Date</Label>
        </FormGroup>{" "}
        <FormGroup floating>
          <Input
            id="taskDescription"
            className="mb-3"
            name="taskDescription"
            value={taskData.taskDescription}
            onChange={postTaskData}
            placeholder="Task Description"
            type="textarea"
          />
          <Label for="taskDescription">Task Description</Label>
        </FormGroup>{" "}
      </Form>
    </div>
  );
};

export default AddTodoForm;

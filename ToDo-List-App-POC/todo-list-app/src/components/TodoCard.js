import React from "react";
import { useNavigate } from "react-router-dom";
import {
  Card,
  CardHeader,
  CardBody,
  CardTitle,
  CardSubtitle,
  CardText,
  Button,
  CardFooter,
} from "reactstrap";
import { deleteTaskfromDB } from "../Service/TaskService";
const TodoCard = ({ task, toggle }) => {
  const navigate = useNavigate();
  const updateTask = async (event) => {
    console.log(task);
    navigate("/updateTask/task.taskId");
  };
  const deleteTask = async () => {
    let ans = window.confirm("Are You sure??");
    if (ans) {
      let res = await deleteTaskfromDB(task.taskId);
      console.log(res);
    }
    window.location.reload();
  };
  return (
    <div>
      <Card
        className="my-2"
        style={{
          width: "18rem",
        }}
      >
        <CardHeader>{task.status}</CardHeader>
        <CardBody>
          <CardTitle tag="h5">{task.taskName}</CardTitle>
          <CardSubtitle className="mb-2 text-muted" tag="h6">
            Created Date: {task.createdDate}
          </CardSubtitle>
          <CardText>{task.taskDescription}</CardText>
          <CardSubtitle className="mb-2 text-muted" tag="h6">
            Finish Target Date: {task.finishTragetDate}
          </CardSubtitle>
        </CardBody>
        <CardFooter>
          <div>
            <Button className="m-1" onClick={updateTask}>
              Edit
            </Button>
            <Button className="m-1" onClick={deleteTask}>
              Delete
            </Button>
          </div>
        </CardFooter>
      </Card>
    </div>
  );
};

export default TodoCard;

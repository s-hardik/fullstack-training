import React from "react";
import { Card, CardHeader, CardBody,CardTitle, CardSubtitle, CardText, Button,CardFooter } from "reactstrap";
const TodoCard = ({task}) => {
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
          <CardSubtitle
      className="mb-2 text-muted"
      tag="h6"
    >
      Created Date: {task.createdDate}
    </CardSubtitle>
          <CardText>
            {task.taskDescription}
          </CardText>
          <CardSubtitle
      className="mb-2 text-muted"
      tag="h6"
    >
      Finish Target Date: {task.finishTragetDate}
    </CardSubtitle>
        </CardBody>
        <CardFooter>
            <div>
                <Button className="m-1">Edit</Button>
                <Button className="m-1">Delete</Button>
            </div>
        </CardFooter>
      </Card>
    </div>
  );
};

export default TodoCard;

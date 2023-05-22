import axios from "axios";
// const config = {
//     headers: {
//       "Access-Control-Allow-Origin": "*",
//       "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
//       "Authorization" : `Bearer ${localStorage.getItem('token')}`
//     }
//   };

export async function getAllTask() {
  try {
    const response = await axios.get("http://localhost:8080/api/todoapp/tasks", {
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
      },
    });
    return response.data;
  } catch (error) {
    return [];
  }
}

export async function getTaskById(id) {
  try {
    const response = await axios.get(
      "http://localhost:8080/api/todoapp/tasks?taskId=" + id,
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
        },
      }
    );
    return response.data;
  } catch (error) {
    return [];
  }
}

export async function saveTaskData(taskData) {
  const response = await axios.post(
    "http://localhost:8080/api/todoapp/tasks",
    taskData,
    {
      headers: {
        "Access-Control-Allow-Origin": "*",
        "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
      },
    }
  );
  return response.data;
}

export async function deleteTaskfromDB(id) {
  try {
    const response = await axios.delete(
      `http://localhost:8080/api/todoapp/tasks?taskId=${id}`,
      {
        headers: {
          "Access-Control-Allow-Origin": "*",
          "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
        },
      }
    );
    return response.data;
  } catch (error) {
    return "Data delete failed";
  }
}

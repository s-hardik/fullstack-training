import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import { DataGrid, GridActionsCellItem } from "@mui/x-data-grid";
import "./EmpTable.css";
import { getDatabase, ref, onValue, remove } from "firebase/database";
import EditTwoToneIcon from "@mui/icons-material/EditTwoTone";
import DeleteIcon from "@mui/icons-material/Delete";
import { getAllEmployee, removeData } from "../../service/EmployeeService";

import { useNavigate, useLocation } from "react-router-dom";
const EmpTable = () => {
  const navigate = useNavigate();
  const [dataRows, setDataRows] = useState([]);
 
  //For deleting the data
  const deleteUser = React.useCallback(
    (id) => () => {
      removeData(id).then(res=>{
        alert(res);
        getEmpData();
      }).catch(err=>{
        console.log("Employee data deleted",err);
      })
    },
    []
  );
  const editUser = React.useCallback(
    (id) => () => {
      
      navigate( `/update/${id}`);
      
      //TODO: TO fill the form auto with existing employee details + Edit the same into database + navigate to dashboard once daved
    },
    []
  );
  const columns = React.useMemo(
    () => [
      {
        field: "id",
        headerName: "EMP ID",
        headerClassName: "super-app-theme--header",
        width: 90,
      },
      {
        field: "firstName",
        headerName: "First Name",
        headerClassName: "super-app-theme--header",
        width: 120,
      },
      {
        field: "middleName",
        headerName: "Middle Name",
        headerClassName: "super-app-theme--header",
        width: 120,
      },
      {
        field: "lastName",
        headerName: "Last Name",
        headerClassName: "super-app-theme--header",
        width: 120,
      },

      {
        field: "contactNumber",
        headerName: "Contact Number",
        headerClassName: "super-app-theme--header",
        width: 100,
      },
      {
        field: "emergencyNumber",
        headerName: "Emergency Contact Number",
        headerClassName: "super-app-theme--header",
        width: 100,
      },
      {
        field: "email",
        headerName: "Email",
        headerClassName: "super-app-theme--header",
        width: 150,
      },
      {
        field: "panNo",
        headerName: "PANcard No",
        headerClassName: "super-app-theme--header",
        width: 130,
      },
      {
        field: "bloodGroup",
        headerName: "Blood Group",
        headerClassName: "super-app-theme--header",
        width: 125,
      },

      {
        field: "presentAddress",
        headerName: "Present Address",
        headerClassName: "super-app-theme--header",
        width: 125,
      },
      {
        field: "permanentAddress",
        headerName: "Permanent Address",
        headerClassName: "super-app-theme--header",
        width: 120,
      },

      {
        field: "actions",
        type: "actions",
        headerClassName: "super-app-theme--header",
        width: 80,
        getActions: (params) => [
          <GridActionsCellItem
            icon={<EditTwoToneIcon />}
            label="Edit"
            onClick={editUser(params.id)}
          />,
          <GridActionsCellItem
            icon={<DeleteIcon />}
            label="Delete"
            onClick={deleteUser(params.id)}
          />,
        ],
      },
    ],
    [deleteUser, editUser]
  );
  const getEmpData = async () => {
    // const db = getDatabase();
    // const empRef = ref(db, "/employee/");
    // onValue(empRef, (snapshot) => {
    //   let rows = [];
    //   const empData = snapshot.val();
    //   for (let key in empData) {
    //     let tempdata = {
    //       ...empData[key],
    //       id: key,
    //     };
    //     rows = [...rows, tempdata];
    //   }
    //   setDataRows(rows);
    // });
    getAllEmployee()
      .then((res) => {
        let rows = [];
        for (let key in res) {
          let tempdata = {
            ...res[key],
            id: res[key].empId,
          };
          rows = [...rows, tempdata];
        }
        setDataRows(rows);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  useEffect(() => {
    getEmpData();
    
  }, []);
  console.log(dataRows);
  return (
    <Box
      sx={{
        width: "100%",
        height: 500,
        "& .super-app-theme--header": {
          backgroundColor: "rgb(180, 180, 184)",
          color: "rgb(78, 78, 79)",
        },
      }}
    >
      <DataGrid rows={dataRows} columns={columns} disableRowSelectionOnClick />
    </Box>
  );
};

export default EmpTable;

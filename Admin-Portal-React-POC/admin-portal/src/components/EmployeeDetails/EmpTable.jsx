import React, { useEffect, useState } from "react";
import Box from "@mui/material/Box";
import { DataGrid, GridActionsCellItem } from "@mui/x-data-grid";
import "./EmpTable.css";
import { getDatabase, ref, onValue, remove } from "firebase/database";
import EditTwoToneIcon from "@mui/icons-material/EditTwoTone";
import DeleteIcon from "@mui/icons-material/Delete";
import { useNavigate } from "react-router-dom";
const EmpTable = () => {
  const navigate = useNavigate();
  const [dataRows, setDataRows] = useState([]);
  const deleteUser = React.useCallback(
    (id) => () => {
      const db = getDatabase();
      const empRef = ref(db, "/employee/" + id);
      remove(empRef).then(() => {
        console.log("removed");
      });
    },
    []
  );
  const editUser = React.useCallback(
    (id) => () => {
      // const db = getDatabase();
      // const empRef = ref(db, "/employee/" + id);
      navigate('/addnew');
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

  useEffect(() => {
    const getEmpData = () => {
      const db = getDatabase();
      const empRef = ref(db, "/employee/");
      onValue(empRef, (snapshot) => {
        let rows = [];
        const empData = snapshot.val();
        for (let key in empData) {
          let tempdata = {
            ...empData[key],
            id: key,
          };
          rows = [...rows, tempdata];
        }
        setDataRows(rows);
      });
    };
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

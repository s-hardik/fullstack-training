import React from "react";
import Box from "@mui/material/Box";
import { DataGrid } from "@mui/x-data-grid";
import "./EmpTable.css";

const columns = [
  { field: "id", headerName: "EMP ID", headerClassName: 'super-app-theme--header', width: 90 },
  {
    field: "firstName",
    headerName: "First Name",
    headerClassName: 'super-app-theme--header',
    width: 120,
  },
  {
    field: "MiddleName",
    headerName: "Middle Name",
    headerClassName: 'super-app-theme--header',
    width: 120,
  },
  {
    field: "lastName",
    headerName: "Last Name",
    headerClassName: 'super-app-theme--header',
    width: 120,
  },
  {
    field: "gender",
    headerName: "Gender",
    headerClassName: 'super-app-theme--header',
    width: 95,
  },
  {
    field: "contactNumber",
    headerName: "Contact Number",
    headerClassName: 'super-app-theme--header',
    width: 100,
  },
  {
    field: "email",
    headerName: "Email",
    headerClassName: 'super-app-theme--header',
    width: 190,
  },
  {
    field: "PANCardNo",
    headerName: "PANcard No",
    headerClassName: 'super-app-theme--header',
    width: 130,
  },
  {
    field: "DOB",
    headerName: "DOB",
    headerClassName: 'super-app-theme--header',
    width: 10,
  },
  {
    field: "hobbies",
    headerName: "Hobbies",
    headerClassName: 'super-app-theme--header',
    width: 130,
  },
  {
    field: "presentAddress",
    headerName: "Present Address",
    headerClassName: 'super-app-theme--header',
    width: 125,
  },
  {
    field: "edit",
    headerName: "",
    headerClassName: 'super-app-theme--header',
    width: 35,
  },
  {
    field: "delete",
    headerName: "",
    headerClassName: 'super-app-theme--header',
    width: 35,
  },
];

const rows = [
  { id: 1, lastName: "Snow", firstName: "Jon", age: 35 },
  { id: 2, lastName: "Lannister", firstName: "Cersei", age: 42 },
  { id: 3, lastName: "Lannister", firstName: "Jaime", age: 45 },
  { id: 4, lastName: "Stark", firstName: "Arya", age: 16 },
  { id: 5, lastName: "Targaryen", firstName: "Daenerys", age: null },
  { id: 6, lastName: "Melisandre", firstName: null, age: 150 },
  { id: 7, lastName: "Clifford", firstName: "Ferrara", age: 44 },
  { id: 8, lastName: "Frances", firstName: "Rossini", age: 36 },
  { id: 9, lastName: "Roxie", firstName: "Harvey", age: 65 },
];

const EmpTable = () => {
  return (
      
      <Box sx={{width:"100%",  height:500,  '& .super-app-theme--header': {
          backgroundColor: 'rgb(180, 180, 184)',
          color: 'rgb(78, 78, 79)',
         
        }}}>
        <DataGrid
          rows={rows}
          columns={columns}
          disableRowSelectionOnClick
        />
      </Box>
     
  );
};

export default EmpTable;

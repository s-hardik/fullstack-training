import axios from "axios";
const config = {
    headers: {
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
      "Authorization" : `Bearer ${localStorage.getItem('token')}`
    }
  };

 
export async function getAllEmployee(){
    try{
        const response = await axios.get('http://localhost:8080/getAllEmployee',{
            headers: {
              "Access-Control-Allow-Origin": "*",
              "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
              "Authorization" : `Bearer ${localStorage.getItem('token')}`
            }
          });
        return response.data;
    }catch(error) {
        return [];
    }
}

export async function getEmployeeById(id){
    try{
        const response = await axios.get('http://localhost:8080/getEmployeeById?empId='+id, {
            headers: {
              "Access-Control-Allow-Origin": "*",
              "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
              "Authorization" : `Bearer ${localStorage.getItem('token')}`
            }
          });
       // console.log('response  ', response)
        return response.data;
    }catch(error) {
        return [];
    }
}


export async function saveEmployeeData(empData, pathName){
    const {firstName,
        middleName,
        lastName,
        contactNumber,
        emergencyNumber,
        email,
        panNo,
        bloodGroup,
        presentAddress,
        permanentAddress} = empData;
  
        if(firstName &&
          middleName &&
          lastName &&
          contactNumber &&
          emergencyNumber &&
          email &&
          panNo &&
          bloodGroup &&
          presentAddress &&
          permanentAddress){
            if(!pathName.includes("update")){
                const response = await axios.post(
                    "http://localhost:8080/addEmployee", empData, {
                        headers: {
                          "Access-Control-Allow-Origin": "*",
                          "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
                          "Authorization" : `Bearer ${localStorage.getItem('token')}`
                        }
                      });
                   // console.log('response  ', response)
                    return response.data;
            }
            else{
                let id = pathName.split("/")[2].trim();
                const response = await axios.put(
                    "http://localhost:8080/editEmployee?empId="+id, empData, {
                        headers: {
                          "Access-Control-Allow-Origin": "*",
                          "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
                          "Authorization" : `Bearer ${localStorage.getItem('token')}`
                        }
                      });
                    console.log('response  ', response)
                    return response.data;
            }
            }
        else{
            alert("Please fill all the data!!")
          };
}

export async function removeData(id){
    try{
        const response = await axios.delete(`http://localhost:8080/deleteEmployeeById?empId=${id}`,{
            headers: {
              "Access-Control-Allow-Origin": "*",
              "Access-Control-Allow-Methods": "GET,PUT,POST,DELETE,PATCH,OPTIONS",
              "Authorization" : `Bearer ${localStorage.getItem('token')}`
            }
          });
        return response.data;
    }catch(error) {
        return "Data delete failed";
    }
}


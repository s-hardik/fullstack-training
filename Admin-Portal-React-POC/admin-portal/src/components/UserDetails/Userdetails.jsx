import React from 'react'
import { useState } from 'react'
import { useEffect } from 'react'
import {getEmployeeByEmailId} from '../../service/EmployeeService';
import { logout } from "../../service/AuthService";
import logo from "../../assets/logo.png";
import userImg from "../../assets/user.jpg";
import { styled } from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import { red } from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';

const ExpandMore = styled((props) => {
  const { expand, ...other } = props;
  return <IconButton {...other} />;
})(({ theme, expand }) => ({
  transform: !expand ? 'rotate(0deg)' : 'rotate(180deg)',
  marginLeft: 'auto',
  transition: theme.transitions.create('transform', {
    duration: theme.transitions.duration.shortest,
  }),
}));
const Userdetails = ({user}) => {
    const [expanded, setExpanded] = React.useState(false);

    const handleExpandClick = () => {
      setExpanded(!expanded);
    };
  
    const [empDetails, setEmpDetails] = useState({});
    const logoutHandler = ()=>{
        logout();
      }
    console.log(user);
    useEffect(()=>{
        getEmployeeByEmailId(user.email).then(res=>{
            setEmpDetails(res);
            console.log(res);
        }).catch(err=>{
            console.log(err);
        })
    },[])
  return (
    <>
    <header>
        <div className="nav-logo">
          <img src={logo} alt="" />
        </div>
        <nav>
          <ul>
            <li>
              <h4>{user.name}</h4>
            </li>
            <li>
              <a href="/" onClick={logoutHandler}>Logout</a>
            </li>
          </ul>
        </nav>
      </header>
      <main>
        <div className="dashboard-heading">
          <h3>Your Details</h3>
        </div>
        <Card sx={{ maxWidth: 345 }}>
      <CardHeader
        avatar={
          <Avatar sx={{ bgcolor: red[500] }} aria-label="employee">
          </Avatar>
        }
        action={
          <IconButton aria-label="settings">
            <MoreVertIcon />
          </IconButton>
        }
        title={empDetails.firstName}
        subheader={empDetails.empId}
      />
      <CardMedia
        component="img"
        height="194"
        image={userImg}
        alt="Paella dish"
      />
      <CardContent>
        <Typography variant="body2" color="text.secondary">
        <p><b>First Name:</b> {empDetails.firstName}</p>
        <p><b>Middle Name:</b>  {empDetails.middleName}</p>
        <p><b>Last Name: </b> {empDetails.lastName}</p>
        </Typography>
      </CardContent>
      <CardActions disableSpacing>
        <IconButton aria-label="share">
          <ShareIcon />
        </IconButton>
        <ExpandMore
          expand={expanded}
          onClick={handleExpandClick}
          aria-expanded={expanded}
          aria-label="show more"
        >
          <ExpandMoreIcon />
        </ExpandMore>
      </CardActions>
      <Collapse in={expanded} timeout="auto" unmountOnExit>
        <CardContent>
        <Typography variant="body2" color="text.secondary">
        <p><b>Email Id:</b> {empDetails.email}</p>
        <p><b>Contact Number:</b>  {empDetails.contactNumber}</p>
        <p><b>Emergency Contact Number:</b>  {empDetails.emergencyNumber}</p>
        <p><b>PAN Number:</b>  {empDetails.panNo}</p>
        <p><b>Blood Group:</b>  {empDetails.bloodGroup}</p>
        <p><b>Permanent Address:</b>  {empDetails.permanentAddress}</p>
        <p><b>Present Address:</b>  {empDetails.presentAddress}</p>
        </Typography>
        </CardContent>
      </Collapse>
    </Card>
      </main>
    </>
  )
}

export default Userdetails

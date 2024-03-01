import React from 'react'
import { Navigate, Outlet } from 'react-router'
import { isLoggedin } from '../../auth'

const Adminroute = () => {

  let role=JSON.parse(localStorage.getItem("data")).user.role

  if (isLoggedin && role==="admin") {
    return  <Outlet/>
  }else{
    return <Navigate to={"/userLogin"} />
  }

  
}

export default Adminroute
import React from 'react'
import { Outlet } from 'react-router'
import { isLoggedin } from '../../auth'
import { Navigate } from 'react-router'

const Garageroute = () => {
    let role = JSON.parse(localStorage.getItem("data")).user.role
    if (isLoggedin && role === "garage") {
        return <Outlet />      
    } else {
        return <Navigate to={"/userLogin"} />
    }
}

export default Garageroute;
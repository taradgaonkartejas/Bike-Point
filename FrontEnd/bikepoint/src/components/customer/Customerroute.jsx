import React from 'react'
import { Navigate, Outlet } from 'react-router'
import { getCurrenUserDetail, isLoggedin } from '../../auth'

const Customerroute = () => {
    let role=getCurrenUserDetail()?.role
    if (isLoggedin && role==="customer") {
        return  <Outlet/>
    } else {
        return <Navigate to={"/userLogin"}  />
    }
 
}

export default Customerroute
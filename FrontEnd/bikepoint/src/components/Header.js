
import React, { useEffect, useState } from 'react';
import { NavLink, useNavigate } from 'react-router-dom';
import { doLogout, getCurrenUserDetail, isLoggedin } from '../auth';

export default function Header(props) {

    let navigate=useNavigate();
    let role=getCurrenUserDetail()?.role;

    const logout=()=>{
        doLogout(() => {
            console.log("login detail is removed from localstorage.")
            console.log("Sucess")
            navigate("/");
        })
    }

    return (
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark px-5">

            <div className="navbar-header">
                <NavLink className="navbar-brand" to="/">{props.title}</NavLink>
            </div>
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">

                < li className="nav-item"><NavLink className="nav-link active" to="/">Home</NavLink></li>

                {(isLoggedin() && role === "admin") ?
                    (< li className="nav-item"><NavLink className="nav-link active" to="/admin/dashboard">My Dashboard</NavLink></li>)
                    : <></>
                }
                {(isLoggedin() && role === "customer") ?
                    (< li className="nav-item"><NavLink className="nav-link active" to="/customer/dashboard"> My Dashboard</NavLink></li>)
                    : <></>
                }
                {(isLoggedin() && role === "garage") ?
                    (< li className="nav-item"><NavLink className="nav-link active" to="/garage/dashboard"> My Dashboard</NavLink></li>)
                    : <></>
                }
                <li className="nav-item"><NavLink className="nav-link" to="/customer/map">Map</NavLink></li>
            </ul>
            <span className="navbar-text mx-3">
            {(isLoggedin()) ?
                    (getCurrenUserDetail()?.email)
                    : <></>
                }
            </span>
            <span className="navbar-text mx-3">
            {(isLoggedin()) ?
                    (<NavLink className="nav-link" onClick={logout} to="/">Logout</NavLink>)
                    :(<NavLink className="nav-link" to="/userLogin">Login</NavLink>)
                }
            </span>
            <span className="navbar-text">
            {(!isLoggedin()) ?
                    (<NavLink className="nav-link" to="/signup">Signup</NavLink>)
                    :<></>
                }
            </span>
        </nav >
    )
}


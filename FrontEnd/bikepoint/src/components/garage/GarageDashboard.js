import React from 'react'
import { NavLink, useNavigate } from 'react-router-dom';

export default function GarageDashboard() {
    var firstName= "Garage";
    const navigate = useNavigate();
  return (
    <>
    <div className="container">
                    <div className="row my-3 mx-5">
                        <div className="col-sm-6"><h2 className="text-capitalize">Hello, {firstName}</h2></div>
                        <div className="col-sm-6">
                            <NavLink className="btn btn-link btn-danger text-light offset-10 text-uppercase text-decoration-none " to="/">Logout</NavLink>
                        </div>
                    </div>

                    <div className="row justify-content-center">
                        <div className="col-sm-5 mx-4 mb-4">
                            <div className="row border rounded-4 p-4 bg-white shadow">
                                <div className="card-body">
                                    <h5 className="card-title">Find Service Request</h5>
                                    <p className="card-text">Please find service reqwst that you can work on.</p>
                                    <button className="btn btn-danger" onClick={()=>{navigate("/garage/find-requests")}}>Find</button>
                                </div>
                            </div>
                        </div>
                        <div className="col-sm-5 mx-4 mb-4">
                            <div className="row border rounded-4 p-4 bg-white shadow">
                                <div className="card-body">
                                    <h5 className="card-title">Previously done jobs</h5>
                                    <p className="card-text">View details of privious job.</p>
                                    <button className="btn btn-danger">VIEW</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="row justify-content-center ">
                        <div className="col-sm-5 mx-4 mb-4">
                            <div className="row border rounded-4 p-4 bg-white shadow">
                                <div className="card-body">
                                    <h5 className="card-title">Find Current Jobs</h5>
                                    <p className="card-text">Find the list of jobs that you are working on.</p>
                                    <button className="btn btn-danger" onClick={()=>{navigate("/add-new-part")}}>Find</button>
                                </div>
                            </div>
                        </div>
                        <div className="col-sm-5 mx-4 mb-4">
                            <div className="row border rounded-4 p-4 bg-white shadow">
                                <div className="card-body">
                                    <h5 className="card-title">Cancel Repair</h5>
                                    <p className="card-text">Cancel your repair Request.</p>
                                    <button className="btn btn-danger">REMOVE</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="row justify-content-center my-4">
                        
                    </div>
                </div>
    </>
  )
}

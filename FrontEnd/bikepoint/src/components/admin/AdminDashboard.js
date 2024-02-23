import React from 'react'
import { NavLink, useNavigate } from 'react-router-dom';

export default function AdminDashboard() {
    var firstName= "Tejas";
    const navigate = useNavigate();
  return (
    <>
    <div className="container">
        <br /><br /><br />
                    <div className="row my-3">
                        <div className="col-sm-6"><h2 className="text-capitalize">Hello, {firstName}</h2></div>
                        <div className="col-sm-6">
                            <NavLink className="btn btn-link btn-danger text-light offset-10 text-uppercase text-decoration-none " to="/">Logout</NavLink>
                        </div>
                    </div>

                    <div className="row">
                        <div className="col-sm-6">
                            <div className="card">
                                <div className="card-body">
                                    <h5 className="card-title">Add New Garage</h5>
                                    <p className="card-text">Register a new garage to database.</p>
                                    <button className="btn btn-danger" onClick={()=>{navigate("/add-new-garage")}}>ADD</button>
                                </div>
                            </div>
                        </div>
                        <div className="col-sm-6">
                            <div className="card">
                                <div className="card-body">
                                    <h5 className="card-title">View Garage List</h5>
                                    <p className="card-text">View details of all registered garages.</p>
                                    <button className="btn btn-danger">VIEW</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="row my-3">
                        <div className="col-sm-6">
                            <div className="card">
                                <div className="card-body">
                                    <h5 className="card-title">Add New Part</h5>
                                    <p className="card-text">Add a new vehicle part to database.</p>
                                    <button className="btn btn-danger" onClick={()=>{navigate("/add-new-part")}}>ADD</button>
                                </div>
                            </div>
                        </div>
                        <div className="col-sm-6">
                            <div className="card">
                                <div className="card-body">
                                    <h5 className="card-title">Add New Repair Service</h5>
                                    <p className="card-text">Add a new vehicle Repair service to database.</p>
                                    <button className="btn btn-danger" onClick={()=>{navigate("/add-new-service")}} >ADD</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div className="row my-3">
                        <div className="col-sm-6">
                            <div className="card">
                                <div className="card-body">
                                    <h5 className="card-title">Remove Garage</h5>
                                    <p className="card-text">Remove garage from database.</p>
                                    <button className="btn btn-danger">REMOVE</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
    </>
  )
}
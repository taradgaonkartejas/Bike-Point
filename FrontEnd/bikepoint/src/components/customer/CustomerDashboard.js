import React from 'react'
import { NavLink, useNavigate } from 'react-router-dom';

export default function CustomerDashboard() {
    var firstName = "Customer";
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
                                <h5 className="card-title">Register New Problem</h5>
                                <p className="card-text">PLease register problem so we can fix your problem.</p>
                                <button className="btn btn-danger" onClick={() => { navigate("/customer/addproblem") }}>ADD</button>
                            </div>
                        </div>
                    </div>
                    <div className="col-sm-5 mx-4 mb-4">
                        <div className="row border rounded-4 p-4 bg-white shadow">
                            <div className="card-body">
                                <h5 className="card-title">Your Service Requests</h5>
                                <p className="card-text">View details of privious service.</p>
                                <button className="btn btn-danger" onClick={() => { navigate("/customer/service-list") }}>VIEW</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div className="row justify-content-center">
                    <div className="col-sm-5 mx-4 mb-4">
                        <div className="row border rounded-4 p-4 bg-white shadow">
                            <div className="card-body">
                                <h5 className="card-title">Track Current Job</h5>
                                <p className="card-text">Get information currently working job.</p>
                                <button className="btn btn-danger" onClick={() => { navigate("/add-new-part") }}>ADD</button>
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

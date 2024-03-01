
import React, { useEffect, useState } from 'react';
import './LandingPage.css';
import { NavLink } from 'react-router-dom';
import { getCurrenUserDetail, isLoggedin } from '../auth';



const LandingPage = () => {

    let role=getCurrenUserDetail()?.role;

    return (
        <>
            <div className="container-fluid">
                <div id="carouselExampleCaptions" className="carousel slide" data-bs-ride="carousel">
                    <div className="carousel-inner">
                        <div className="carousel-item active">
                            <video className="videoStyle" autoPlay muted loop>
                                <source src="assets\engineOil.mp4" type="video/mp4" />
                            </video>
                            <div className="middleLayer bg-1"></div>

                            <div className="d-flex flex-column justify-content-center align-items-center w-100 vh-100 position-fixed slideContent">
                            <h4 className="text-light font-weight-bolder text-uppercase">Book Service</h4>
                                        <div className="container w-50">
                                            <p className="display-6 text-light text-center">Book appointments on the go with best specialist Mechanics in your city.</p>
                                        </div>
                                {(isLoggedin() && role === "customer") ?
                                    (<div>
                                        <NavLink className="btn btn-danger btn-lg text-uppercase text-decoration-none mx-3" to="/customer/addproblem">Book Service</NavLink>
                                    </div>) :
                                    (<div>
                                        <NavLink className="btn btn-danger btn-lg text-uppercase text-decoration-none mx-3" to="/signup">Sign Up</NavLink>
                                        <NavLink className="btn btn-outline-danger btn-lg text-uppercase text-decoration-none mx-3" to="/userLogin">Login</NavLink>
                                    </div>)
                                }
                            </div>
                        </div>
                        <div className="carousel-item">
                            <video className="videoStyle" autoPlay muted loop>
                                <source src="assets\repair.mp4" type="video/mp4" />
                            </video>
                            <div className="middleLayer bg-2"></div>
                            <div className="d-flex flex-column justify-content-center align-items-center w-100 h-100 position-fixed slideContent">

                                {(isLoggedin() && role === "customer") ?
                                    (<div>
                                        <h3 className="text-light font-weight-bolder text-uppercase text-center">Have a Problem?</h3>
                                        <div className="container w-50">
                                            <p className="display-6 text-light text-center">Register a problem run your bike smoothly!</p>
                                        </div>
                                        <div className="d-flex justify-content-center">
                                        <NavLink className="btn btn-danger btn-lg text-uppercase text-decoration-none mx-3" to="/customer/addproblem">Register Problem</NavLink>
                                        </div>
                                    </div>) :
                                    (<div>
                                        <h3 className="text-light font-weight-bolder text-uppercase text-center">Easy To Use</h3>
                                        <div className="container w-50">
                                            <p className="display-6 text-light text-center">Search garages by specializations and say bye to your vehicle problems easily.</p>
                                        </div>
                                        <div className="d-flex justify-content-center">
                                        <NavLink className="btn btn-danger btn-lg text-uppercase text-decoration-none mx-3" to="/signup">Sign Up</NavLink>
                                        <NavLink className="btn btn-outline-danger btn-lg text-uppercase text-decoration-none mx-3" to="/userLogin">Login</NavLink>
                                        </div>
                                    </div>)
                                }
                            </div>
                        </div>
                    </div>
                    <button className="carousel-control-prev prevButtonPosition" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">

                        <div className="carousel-control-prev-icon" aria-hidden="true"></div>
                        <div className="visually-hidden">Previous</div>
                    </button>
                    <button className="carousel-control-next nextButtonPosition" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <div className="carousel-control-next-icon" aria-hidden="true"></div>
                        <div className="visually-hidden">Next</div>
                    </button>
                </div>
            </div>
        </>
    )
}

export default LandingPage

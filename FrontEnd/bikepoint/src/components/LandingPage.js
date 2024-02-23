import React, { useEffect } from 'react';
import './LandingPage.css';
import { NavLink } from 'react-router-dom';

// const toLogin = () => {
//     return <Link to="/userLogin">Login</Link>
// }

const LandingPage = () => {

    //useEffect(() => {
    //     const reloadCount = sessionStorage.getItem('reloadCount');
    //     if (reloadCount < 2) {
    //         sessionStorage.setItem('reloadCount', String(reloadCount + 1));
    //         window.location.reload();
    //     } else {
    //         sessionStorage.removeItem('reloadCount');
    //     }
    // }, []);



    let role = (sessionStorage.getItem("role"));
    console.log(role);

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
                            <div className="d-flex flex-column justify-content-center align-items-center w-100 h-100 position-fixed slideContent">
                                <h4 className="text-light font-weight-bolder text-uppercase">Book Service</h4>
                                <div className="container w-50">
                                    <p className="display-6 text-light text-center">Book appointments on the go with best specialist Mechanics in your city.</p>
                                </div>
                                {role ?
                                    (<span></span>) :
                                    (<div>
                                        <NavLink className="btn btn-danger btn-lg text-uppercase text-decoration-none mx-3" to="/customerSignup">Sign Up</NavLink>
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
                                <h4 className="text-light font-weight-bolder text-uppercase">Easy To Use</h4>
                                <div className="container w-50">
                                    <p className="display-6 text-light text-center">Search garages by specializations and say bye to your vehicle problems easily.</p>
                                </div>
                                {role ?
                                    (<span></span>) :
                                    (<div>
                                        <NavLink className="btn btn-danger btn-lg text-uppercase text-decoration-none mx-3" to="/customerSignup">Sign Up</NavLink>
                                        <NavLink className="btn btn-outline-danger btn-lg text-uppercase text-decoration-none mx-3" to="/userLogin">Login</NavLink>
                                    </div>)
                                }
                            </div>
                        </div>
                    </div>
                    <button className="carousel-control-prev prevButtonPosition" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                        <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Previous</span>
                    </button>
                    <button className="carousel-control-next nextButtonPosition" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                        <span className="carousel-control-next-icon" aria-hidden="true"></span>
                        <span className="visually-hidden">Next</span>
                    </button>
                </div>
            </div>
        </>
    )
}

export default LandingPage

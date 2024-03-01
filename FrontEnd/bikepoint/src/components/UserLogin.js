import React, { useState } from 'react'

import { toast } from 'react-toastify'
import { logIn } from '../service/userService';
import './UserLogin.css'
import { Form, Input, FormFeedback, Label } from 'reactstrap';
import { doLogin, isLoggedin } from '../auth';
import { useNavigate } from 'react-router';


export default function UserLogin() {


    const navigate = useNavigate()

    const [loginDetail, setLoginDetail] = useState({
        email: '',
        password: ''
    });

    const [error, setError] = useState({
        errors: {},
        isError: false
    });

    const handelChange = (event, feild) => {
        setLoginDetail({ ...loginDetail, [feild]: event.target.value })
    }

    //resetting form
    const resetData = () => {
        setLoginDetail({
            email: '',
            password: ''
        })
    }

    //submitting form    
    const handletFormSubmit = (event) => {
        event.preventDefault()
        //Form validation
        // if(error.isError){
        //     toast.error("Form Data is invalid cocorrect all details.")
        //     return;
        // }

        //sending data to server
        console.log(loginDetail)
        resetData()

        logIn(loginDetail).then((data) => {


            //save data to localstorage
            doLogin(data, () => {
                console.log("login detail is saved to localstorage.")
                console.log("Sucess")



                //redirect to user dashboard page
                let role = JSON.parse(localStorage.getItem("data"))?.user?.role
                if (isLoggedin() && role === "customer") {

                    navigate("/customer/dashboard")

                } else if (isLoggedin() && role === "garage") {

                    navigate("/garage/dashboard")

                } else if (isLoggedin() && role === "admin") {

                    navigate("/admin/dashboard")

                } else {

                    navigate("/userLogin")
                }


            });

           
        }).catch((error) => {
            console.log(error)
            console.log("failed")
            toast.error("Form Data is invalid cocorrect all details.")
            //handel error in proper way
            setError({
                errors: error,
                isError: true
            })

        })


    }

    return (
        <>
            {/* <!----------------------- Main Container --------------------------> */}

            <div className="container d-flex justify-content-center align-items-center my-5" >

                {/* <!----------------------- Login Container --------------------------> */}

                <div className="row border rounded-5 p-3 bg-white shadow box-area">

                    {/* <!--------------------------- Left Box -----------------------------> */}

                    <div className="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style={{ background: '#dc3545' }}>
                        <div className="featured-image mb-3">
                            <img src="assets/1.png" className="img-fluid" style={{ width: '250px' }} />
                        </div>
                        <p className="text-white fs-2" style={{ fontFamily: "Courier New", fontWeight: "600" }}>Be Verified</p>
                        <small className="text-white text-wrap text-center" style={{ width: '17rem', fontFamily: 'Courier New' }}>Make your bike like new on this platform.</small>
                    </div>

                    {/* <!-------------------- ------ Right Box ----------------------------> */}

                    <Form className="col-md-6 right-box" onSubmit={handletFormSubmit}>
                        <div className="row align-items-center">
                            <div className="header-text mb-4">
                                <h2>Hello,Again</h2>
                                <p>We are happy to have you back.</p>
                            </div>
                            <div className="col-md-12 mb-3">
                                <Input type="email" className="form-control form-control-lg bg-light fs-6" placeholder="Email address" id='email' name='email'
                                    value={loginDetail.email} onChange={(e) => { handelChange(e, 'email') }}
                                    invalid={error.errors?.response?.data?.message ? true : undefined} />
                                <FormFeedback>
                                    {error.errors?.response?.data?.message}
                                </FormFeedback>
                            </div>
                            <div className="col-md-12 mb-1">
                                <Input type="password" className="form-control form-control-lg bg-light fs-6" placeholder="Password" id='password' name='password'
                                    value={loginDetail.password} onChange={(e) => { handelChange(e, 'password') }}
                                    invalid={error.errors?.response?.data?.message ? true : undefined} />
                                <FormFeedback>
                                    {error.errors?.response?.data?.message}
                                </FormFeedback>
                            </div>
                            <div className="input-group mb-5 d-flex justify-content-between">
                                <div className="form-check">
                                    <Input type="checkbox" className="form-check-input" id="formCheck" />
                                    <Label htmlFor="formCheck" className="form-check-label text-secondary"><small>Remember Me</small></Label>
                                </div>
                                <div className="forgot">
                                    <small><a href="#">Forgot Password?</a></small>
                                </div>
                            </div>
                            <div className="input-group mb-3">
                                <button type='submit' className="btn btn-lg btn-danger w-100 fs-6">Login</button>
                            </div>
                            <div className="input-group mb-3">
                                <button className="btn btn-lg btn-light w-100 fs-6"><img src="assets/google.png" style={{ width: '20px' }} className="me-2" /><small>Sign In with Google</small></button>
                            </div>
                            <div className="row">

                                <small>Don't have account? <a href="/signup">Sign Up</a></small>
                            </div>
                        </div>
                    </Form>

                </div>
            </div>
        </>
    )
}

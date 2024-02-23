import '../UserLogin.css'
import React, { useEffect, useState } from 'react'
import { signUp } from '../../service/userService';

export default function CustomerSignup() {

 

    const [data,setData]=useState({
        firstName :'',
        lastName :'',
        email :'',
        password :'',
        mobileNo :'',
        dob :'',
        address :'',
    });

    const [error, setError]=useState({
        errors:{},
        isError:false
    });

    const handelChange=(event,feild)=>{
        setData({...data, [feild]:event.target.value})
    }

   //resetting form
    const resetData=()=>{
        setData({
            firstName :'',
            lastName :'',
            email :'',
            password :'',
            mobileNo :'',
            dob :'',
            address :'',
        })
    }

    //submitting form    
    const submitForm=(event)=>{
        event.preventDefault()
        //Form validation


        //sending data to server
        console.log(data)
        resetData()
        signUp(data).then((resp)=>{
            console.log(resp);
            console.log("Sucess")
        }).catch((err)=>{
            console.log(err)
            console.log("failed")
        })


    }

  return (
    <>
    {/* <!----------------------- Main Container --------------------------> */}
    <form className="container d-flex justify-content-center align-items-center min-vh-100 w-50 " onSubmit={submitForm}>
        {/* <!----------------------- Login Container --------------------------> */}
        <div className="row border rounded-5 p-3 bg-white shadow box-area">

            <div>
                <div className="row align-items-center">
                    
                    <div className="col-md-12 right-box">
                    <h2>Register Your Account Here!</h2>
                        <div className="row align-items-center">
                            <div className="row">
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <input type="text" className="form-control form-control-lg bg-light fs-6" 
                                        id="firstName" placeholder="" value={data.firstName} onChange={(e)=>{handelChange(e , 'firstName')}}/>
                                        <label htmlFor="firstName">First Name</label>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <input type="text" className="form-control" 
                                        id="lastName" placeholder="" value={data.lastName} onChange={(e)=>{handelChange(e , 'lastName')}}/>
                                        <label htmlFor="lastName">Last Name</label>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <input type="text" className="form-control" 
                                        id="email" placeholder="" value={data.email} onChange={(e)=>{handelChange(e , 'email')}}/>
                                        <label htmlFor="email">Email</label>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <input type="text" className="form-control" 
                                        id="password" placeholder="" value={data.password} onChange={(e)=>{handelChange(e , 'password')}}/>
                                        <label htmlFor="password">Passsword</label>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <input type="text" className="form-control" 
                                        id="mobileNo" placeholder="" value={data.mobileNo} onChange={(e)=>{handelChange(e , 'mobileNo')}}/>
                                        <label htmlFor="mobileNo">Mobile Number</label>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <input type="date" className="form-control" 
                                        id="dob" placeholder="" value={data.dob} onChange={(e)=>{handelChange(e , 'dob')}}/>
                                        <label htmlFor="dob">Date Of Birth</label>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <textarea className="form-control" 
                                        id="address" rows="4" placeholder="" value={data.address} onChange={(e)=>{handelChange(e , 'address')}}></textarea>
                                        <label htmlFor="address">Address</label>
                                    </div>
                                    <div className="input-group mb-3">
                                        <button type='submit' className="btn btn-lg btn-danger w-100 fs-6">Register</button>
                                    </div>
                                    <div className="input-group mb-3">
                                        <button type='reset' className="btn btn-lg btn-secondary w-100 fs-6" onClick={resetData}>Reset</button>
                                    </div>
                                    <div className="row">
                                        <small>Already have a account? <a href="/userLogin">login</a></small>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
    </>
  )
}

import '../UserLogin.css'
import React, { useEffect, useState } from 'react'
import { signUp } from '../../service/userService';
import { toast } from 'react-toastify';
import { FormFeedback, Input,Form,FormGroup,Label } from 'reactstrap';

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
        // if(error.isError){
        //     toast.error("Form Data is invalid cocorrect all details.")
        //     return;
        // }

        //sending data to server
        console.log(data)
        resetData()
        signUp(data).then((resp)=>{
            console.log(resp);
            console.log("Sucess")
            toast.success("User registered successfully!!")
        }).catch((error)=>{
            console.log(error)
            console.log("failed")
            toast.error("Form Data is invalid cocorrect all details.")
            //handel error in proper way
            setError({
                errors:error,
                isError:true
            })

        })


    }

  return (
    <>
    {/* <!----------------------- Main Container --------------------------> */}
    <Form className="container d-flex justify-content-center align-items-center min-vh-100 w-50 " onSubmit={submitForm}>
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
                                     
                                        <Input type="text" className="form-control form-control-lg bg-light fs-6" 
                                        id="firstName" placeholder="First Name" value={data.firstName} onChange={(e)=>{handelChange(e , 'firstName')}}
                                        invalid={error.errors?.response?.data?.firstName ? true:undefined}/>
                                        <Label htmlFor="firstName">First Name</Label>
                                        <FormFeedback>
                                            {error.errors?.response?.data?.firstName}
                                        </FormFeedback>
                                        
                                        
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <Input type="text" className="form-control" 
                                        id="lastName" placeholder="" value={data.lastName} onChange={(e)=>{handelChange(e , 'lastName')}}
                                        invalid={error.errors?.response?.data?.lastName ? true:undefined}/>
                                        <Label htmlFor="lastName">Last Name</Label>
                                        <FormFeedback>
                                            {error.errors?.response?.data?.lastName}
                                        </FormFeedback>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <Input type="text" className="form-control" 
                                        id="email" placeholder="" value={data.email} onChange={(e)=>{handelChange(e , 'email')}}
                                        invalid={error.errors?.response?.data?.email ? true:undefined}/>
                                        <Label htmlFor="email">Email</Label>
                                        <FormFeedback>
                                            {error.errors?.response?.data?.email}
                                        </FormFeedback>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <Input type="text" className="form-control" 
                                        id="password" placeholder="" value={data.password} onChange={(e)=>{handelChange(e , 'password')}}
                                        invalid={error.errors?.response?.data?.password ? true:undefined}/>
                                        <Label htmlFor="password">Passsword</Label>
                                        <FormFeedback>
                                            {error.errors?.response?.data?.password}
                                        </FormFeedback>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <Input type="text" className="form-control" 
                                        id="mobileNo" placeholder="" value={data.mobileNo} onChange={(e)=>{handelChange(e , 'mobileNo')}}
                                        invalid={error.errors?.response?.data?.mobileNo ? true:undefined}/>
                                        <Label htmlFor="mobileNo">Mobile Number</Label>
                                        <FormFeedback>
                                            {error.errors?.response?.data?.mobileNo}
                                        </FormFeedback>
                                    </div>
                                </div>
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <Input type="date" className="form-control" 
                                        id="dob" placeholder="" value={data.dob} onChange={(e)=>{handelChange(e , 'dob')}}
                                        invalid={error.errors?.response?.data?.dob ? true:undefined}/>
                                        <Label htmlFor="dob">Date Of Birth</Label>
                                        <FormFeedback>
                                            {error.errors?.response?.data?.dob}
                                        </FormFeedback>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="col">
                                    <div className="form-floating mb-3">
                                        <textarea className="form-control" 
                                        id="address" rows="4" placeholder="" value={data.address} onChange={(e)=>{handelChange(e , 'address')}}></textarea>
                                        <Label htmlFor="address">Address</Label>
                                        
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
    </Form>
    </>
  )
}

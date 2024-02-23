import React, { Component } from 'react'
import { NavLink } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify'
import './UserLogin.css'


export default function UserLogin() {
  
  return (
    <>
    {/* <!----------------------- Main Container --------------------------> */}
<div class="container d-flex justify-content-center align-items-center min-vh-100" >

{/* <!----------------------- Login Container --------------------------> */}

  <div class="row border rounded-5 p-3 bg-white shadow box-area">

{/* <!--------------------------- Left Box -----------------------------> */}

  <div class="col-md-6 rounded-4 d-flex justify-content-center align-items-center flex-column left-box" style={{background: '#dc3545'}}>
      <div class="featured-image mb-3">
       <img src="assets/1.png" class="img-fluid" style={{width: '250px'}}/>
      </div>
      <p class="text-white fs-2" style={{fontFamily: "Courier New", fontWeight: "600"}}>Be Verified</p>
      <small class="text-white text-wrap text-center" style={{width: '17rem',fontFamily: 'Courier New'}}>Make your bike like new on this platform.</small>
  </div> 

{/* <!-------------------- ------ Right Box ----------------------------> */}
   
  <div class="col-md-6 right-box">
     <div class="row align-items-center">
           <div class="header-text mb-4">
                <h2>Hello,Again</h2>
                <p>We are happy to have you back.</p>
           </div>
           <div class="input-group mb-3">
               <input type="email" class="form-control form-control-lg bg-light fs-6" placeholder="Email address" id='email' name='email'/>
           </div>
           <div class="input-group mb-1">
               <input type="password" class="form-control form-control-lg bg-light fs-6" placeholder="Password" id='password' name='password'/>
           </div>
           <div class="input-group mb-5 d-flex justify-content-between">
               <div class="form-check">
                   <input type="checkbox" class="form-check-input" id="formCheck"/>
                   <label for="formCheck" class="form-check-label text-secondary"><small>Remember Me</small></label>
               </div>
               <div class="forgot">
                   <small><a href="#">Forgot Password?</a></small>
               </div>
           </div>
           <div class="input-group mb-3">
               <button class="btn btn-lg btn-danger w-100 fs-6">Login</button>
           </div>
           <div class="input-group mb-3">
               <button class="btn btn-lg btn-light w-100 fs-6"><img src="assets/google.png" style={{width:'20px'}} class="me-2"/><small>Sign In with Google</small></button>
           </div>
           <div class="row">
               <small>Don't have account? <a href="/customerSignup">Sign Up</a></small>
           </div>
     </div>
  </div> 

 </div>
</div>
    </>
  )
}

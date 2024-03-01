import React, { useState, useEffect } from 'react'
import '../UserLogin.css'
import { FormFeedback, Input, Form, Label } from 'reactstrap';
import { addProblem } from '../../service/customerService';
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import { getCurrenUserDetail } from '../../auth';
import axios from 'axios';
import { useNavigate } from 'react-router';

export default function RegisterProblem() {

    const [location, setLocation] = useState({ latitude: null, longitude: null });
    const [add, setAdd] = useState('')

    const navigate=useNavigate();

    const [problemData, setProblemData] = useState({
        id:0,
        vehicleCompany: '',
        vehicleModel: '',
        problemType: '',
        problemDescription: '',
        latitude: location.latitude,
        longitude: location.longitude,
        address: '',
        status: ''
    });

    const id = getCurrenUserDetail()?.id

    const [error, setError] = useState({
        errors: {},
        isError: false
    });

    const handelChange = (event, feild) => {
        setProblemData({ ...problemData, [feild]: event.target.value, latitude: location.latitude, longitude: location.longitude, address: add })
    }

    useEffect(() => {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(function (position) {
                setLocation({
                    latitude: position.coords.latitude,
                    longitude: position.coords.longitude,
                });
                setProblemData({ ...problemData, latitude: location.latitude, longitude: location.longitude })

                //getting adderss form the location
                axios.get(`https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=${position.coords.latitude}&lon=${position.coords.longitude}`).then((resp) => {

                    setAdd(resp?.data?.display_name)
                    
                }).catch(err => {
                    console.log(err);
                })
            });
        } else {
            console.log("Geolocation is not available in your browser.");
        }
    }, []);
    console.log(add);
    const resetProblemData = () => {
        setProblemData({
            id:0,
            vehicleCompany: '',
            vehicleModel: '',
            problemType: '',
            problemDescription: '',
            latitude: location.latitude,
            longitude: location.longitude,
            address: '',
            status: ''
        })
    }

    const problemHandler = (event) => {
        event.preventDefault()
        //validation

        //Sending data to server
        console.log(problemData)
        addProblem(id, problemData).then((resp) => {
            console.log(resp);
            console.log("Sucess")

            //storing problem id ti session storage
            sessionStorage.removeItem("problemId");
            sessionStorage.setItem("problemId",resp.id);

            toast.success("Problem registered successfully!!", {
                position: "bottom-center",
            });
            //Navigating to map Page
            navigate("/customer/map")

        }).catch((error) => {
            console.log(error)
            console.log("failed")
            //handel error in proper way
            setError({
                errors: error,
                isError: true
            })

        })

    }

    return (
        (location.latitude && location.longitude) ? (
            <>
                {/* <!----------------------- Main Container --------------------------> */}
                <div className="container d-flex justify-content-center align-items-center my-5 w-50 ">
                    {/* <!----------------------- Registration Container --------------------------> */}
                    <Form className="row border rounded-5 p-3 bg-white shadow box-area my-4" onSubmit={problemHandler}>
                        <div className="row align-items-center">

                            <div className="col-md-12 right-box">
                                <div className="header-text ">
                                    <h2>Book Service Here!</h2>
                                </div>
                                <div className="row">
                                    <div className="col-md-6 ">
                                        <Input type='select' className="form-select mb-3" id='vehicleCompany'
                                            value={problemData.vehicleCompany} onChange={(e) => { handelChange(e, 'vehicleCompany') }}
                                            invalid={error.errors?.response?.data?.vehicleCompany ? true : undefined}>
                                            <option value="Select Company" defaultValue>----Vehicle Company----</option>
                                            <option value="Royal Enfield">Royal Enfield</option>
                                            <option value="Hero">Hero</option>
                                            <option value="Honda">Honda</option>
                                            <option value="Bajaj">Bajaj</option>
                                            <option value="TVS">TVS</option>
                                            <option value="KTM">KTM</option>
                                            <option value="Yamaha">Yamaha</option>
                                        </Input>
                                        <FormFeedback>
                                            {error.errors?.response?.data?.vehicleCompany}
                                        </FormFeedback>
                                    </div>
                                    <div className="col-md-6">
                                        <Input type='select' className="form-select mb-3" id='problemType'
                                            value={problemData.problemType} onChange={(e) => { handelChange(e, 'problemType') }}
                                            invalid={error.errors?.response?.data?.problemType ? true : undefined}>
                                            <option value="Select Problem" defaultValue>---- Select Problem Type ----</option>
                                            <option value="Battery">Battery</option>
                                            <option value="Break">Break</option>
                                            <option value="Tyre">Tyre</option>
                                            <option value="Light">Light</option>
                                            <option value="Engine">Engine</option>
                                            <option value="Carburetor">Carburetor</option>
                                            <option value="OilLeak">Oil Leak</option>
                                        </Input>
                                        <FormFeedback>
                                            {error.errors?.response?.data?.problemType}
                                        </FormFeedback>
                                    </div>

                                </div>
                                <div className="row">
                                    <div className="col-md-12">
                                        <div className="form-floating mb-3">
                                            <Input type="text" className="form-control" id="vehicleModel" placeholder=""
                                                value={problemData.vehicleModel} onChange={(e) => { handelChange(e, 'vehicleModel') }}
                                                invalid={error.errors?.response?.data?.vehicleModel ? true : undefined} />
                                            <Label htmlFor="vehicleModel">Vehicle Model</Label>
                                            <FormFeedback>
                                                {error.errors?.response?.data?.vehicleModel}
                                            </FormFeedback>
                                        </div>
                                    </div>
                                    <div className="col-md-12">
                                        <div className="form-floating mb-3">
                                            <Input type='textarea' className="form-control" id="problemDescription" rows="4" placeholder=""
                                                value={problemData.problemDescription} onChange={(e) => { handelChange(e, 'problemDescription') }}
                                                invalid={error.errors?.response?.data?.problemDescription ? true : undefined}></Input>
                                            <Label htmlFor="problemDescription">Problem Description</Label>
                                            <FormFeedback>
                                                {error.errors?.response?.data?.problemDescription}
                                            </FormFeedback>
                                        </div>
                                        <p>Latitude: {location.latitude}    Longitude:{location.longitude}</p>
                                        <div className="input-group mb-3">
                                            <button type='submit' className="btn btn-lg btn-danger w-100 fs-6">Book Service</button>
                                            <ToastContainer />
                                        </div>
                                        <div className="input-group">
                                            <button type='reset' className="btn btn-lg btn-secondary w-100 fs-6" onClick={resetProblemData}>Reset</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </Form>
                </div>
            </>
        ) : (
            <p>Loading...</p>
        )
    )
}

import React, { useEffect, useState } from 'react'
import '../UserLogin.css'
import { FormFeedback, Input, Form, Label } from 'reactstrap';
import { addGarage } from '../../service/adminService';
import { toast } from 'react-toastify';

export default function AddNewGarage() {
    const [location, setLocation] = useState({ latitude: null, longitude: null });
    const [garageData, setGarageData] = useState({
        email: '',
        password: '',
        garageName: '',
        mobileNo: '',
        latitude: location.latitude,
        longitude: location.longitude,
        address: ''
    });

    const [error, setError] = useState({
        errors: {},
        isError: false
    });

    const handelChange = (event, feild) => {
        setGarageData({ ...garageData, [feild]: event.target.value, latitude: location.latitude, longitude: location.longitude })
    }

    useEffect(() => {
        if ("geolocation" in navigator) {
            navigator.geolocation.getCurrentPosition(function (position) {
                setLocation({
                    latitude: position.coords.latitude,
                    longitude: position.coords.longitude,
                });
                setGarageData({ ...garageData, latitude: location.latitude, longitude: location.longitude })
            });
        } else {
            console.log("Geolocation is not available in your browser.");
        }
    }, []);

    const resetGarageData = () => {
        setGarageData({
            email: '',
            password: '',
            garageName: '',
            mobileNo: '',
            latitude: location.latitude,
            longitude: location.longitude,
            address: ''
        })
    }

    const garageHandler = (event) => {
        event.preventDefault()
        //validation

        //Sending data to server
        console.log(garageData)
        addGarage(garageData).then((resp) => {
            console.log(resp);
            console.log("Sucess")
            toast.success("Garage registered successfully!!")
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
            {location.latitude && location.longitude ? (
                <>
                    {/* <!----------------------- Main Container --------------------------> */}
                    <div className="container d-flex justify-content-center align-items-center min-vh-100 w-50 ">
                        {/* <!----------------------- Registration Container --------------------------> */}
                        <Form className="row border rounded-5 p-3 bg-white shadow box-area" onSubmit={garageHandler}>
                            <div className="row align-items-center">

                                <div className="col-md-12 right-box">
                                    <div className="header-text ">
                                        <h2>Add new Garage Here!</h2>
                                        <p></p>
                                    </div>
                                    <div className="row">
                                        <div className="col">
                                            <div className="form-floating mb-3">
                                                <Input type="text" className="form-control" id="email" placeholder=""
                                                    value={garageData.email} onChange={(e) => { handelChange(e, 'email') }}
                                                    invalid={error.errors?.response?.data?.email ? true : undefined} />
                                                <Label htmlFor="email">Email</Label>
                                                <FormFeedback>
                                                    {error.errors?.response?.data?.email}
                                                </FormFeedback>
                                            </div>
                                        </div>
                                        <div className="col">
                                            <div className="form-floating mb-3">
                                                <Input type="password" className="form-control" id="password" placeholder=""
                                                    value={garageData.password} onChange={(e) => { handelChange(e, 'password') }}
                                                    invalid={error.errors?.response?.data?.password ? true : undefined} />
                                                <Label htmlFor="password">Passsword</Label>
                                                <FormFeedback>
                                                    {error.errors?.response?.data?.password}
                                                </FormFeedback>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="col">
                                        <div className="form-floating mb-3">
                                            <Input type="text" className="form-control" id="garageName" placeholder=""
                                                value={garageData.garageName} onChange={(e) => { handelChange(e, 'garageName') }}
                                                invalid={error.errors?.response?.data?.mobileNo ? true : undefined} />
                                            <Label htmlFor="garageName">Garage Name</Label>
                                            <FormFeedback>
                                                {error.errors?.response?.data?.mobileNo}
                                            </FormFeedback>
                                        </div>
                                    </div>

                                    <div className="col">
                                        <div className="form-floating mb-3">
                                            <Input type="text" className="form-control" id="mobileNo" placeholder=""
                                                value={garageData.mobileNo} onChange={(e) => { handelChange(e, 'mobileNo') }}
                                                invalid={error.errors?.response?.data?.mobileNo ? true : undefined} />
                                            <Label htmlFor="mobileNo">Mobile No</Label>
                                            <FormFeedback>
                                                {error.errors?.response?.data?.mobileNo}
                                            </FormFeedback>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col">
                                            <div className="form-floating mb-3">
                                                <textarea className="form-control" id="address" rows="4" placeholder=""
                                                    value={garageData.address} onChange={(e) => { handelChange(e, 'address') }}
                                                    invalid={error.errors?.response?.data?.address ? true : undefined}></textarea>
                                                <Label htmlFor="address">Address</Label>
                                                <FormFeedback>
                                                    {error.errors?.response?.data?.address}
                                                </FormFeedback>
                                            </div>
                                            <p>Latitude: {location.latitude}    Longitude:{location.longitude}</p>
                                            <div className="input-group mb-3">
                                                <button type='submit' className="btn btn-lg btn-danger w-100 fs-6">Register</button>
                                            </div>
                                            <div className="input-group">
                                                <button type='reset' className="btn btn-lg btn-secondary w-100 fs-6" onClick={resetGarageData}>Register</button>
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
            )}



        </>
    )
}

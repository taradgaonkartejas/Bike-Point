import React, { useState } from 'react'
import { FormFeedback, Input, Form, Label } from 'reactstrap';
import { addService } from '../../service/adminService';
import { ToastContainer, toast} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

export default function AddNewService() {

    const [service, setService] = useState({
        serviceName: '',
        serviceCost: ''
    });

    const [error, setError] = useState({
        errors: {},
        isError: false
    });

    const handelChange = (event, feild) => {
        setService({ ...service, [feild]: event.target.value })
    }

    const resetServiceData = () => {
        setService({
            serviceName: '',
            serviceCost: ''
        })
    }

    const serviceHandler = (event) => {
        event.preventDefault()
        //validation

        //Sending data to server
        console.log(service)
        addService(service).then((resp) => {
            console.log(resp);
            console.log("Sucess")
            toast.success("Part added successfully!!")
        }).catch((error) => {
            console.log(error)
            console.log("failed")
            toast.error("Form Data is invalid cocorrect all details.")
            toast.success("Service added successfully!!",{
                position:  "bottom-center",
              })
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
        <>
            {/* <!----------------------- Main Container --------------------------> */}
            <Form className="container d-flex justify-content-center align-items-center min-vh-100 w-50 " onSubmit={serviceHandler}>
                {/* <!----------------------- Form Container --------------------------> */}
                <div className="row border rounded-5 p-5 bg-white shadow box-area">
                    <div className="row">
                        <div className="header-text mb-2">
                            <h2>Add New Service Here!</h2>
                        </div>
                        <div className="row mb-3">
                            <div className="col">
                                <div className="form-floating mb-3">
                                    <Input type="text" className="form-control" id="serviceName" placeholder=""
                                        value={service.serviceName} onChange={(e) => { handelChange(e, 'serviceName') }}
                                        invalid={error.errors?.response?.data?.serviceName ? true : undefined} />
                                    <Label htmlFor="serviceName">Service Name </Label>
                                    <FormFeedback>
                                        {error.errors?.response?.data?.serviceName}
                                    </FormFeedback>
                                </div>
                            </div>
                            <div className="col">
                                <div className="form-floating mb-3">
                                    <Input type="text" className="form-control" id="serviceCost" placeholder=""
                                        value={service.serviceCost} onChange={(e) => { handelChange(e, 'serviceCost') }}
                                        invalid={error.errors?.response?.data?.serviceCost ? true : undefined} />
                                    <Label htmlFor="serviceCost">Service Cost </Label>
                                    <FormFeedback>
                                        {error.errors?.response?.data?.serviceCost}
                                    </FormFeedback>
                                </div>
                            </div>
                            <div className="input-group mb-3">
                                <button type='submit' className="btn btn-lg btn-danger w-100 fs-6">Save</button>
                                <ToastContainer/>
                            </div>
                            <div className="input-group">
                                <button type='reset' className="btn btn-lg btn-secondary w-100 fs-6" onClick={resetServiceData}>Reset</button>
                            </div>
                        </div>
                    </div>
                </div>
            </Form>
        </>
    )
}

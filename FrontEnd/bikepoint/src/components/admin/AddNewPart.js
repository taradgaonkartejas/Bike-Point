import React, { useState } from 'react'
import '../UserLogin.css'
import { FormFeedback, Input, Form, Label } from 'reactstrap';
import { addPart } from '../../service/adminService';
import { toast } from 'react-toastify';

export default function AddNewPart() {

    const [part, setPart] = useState({
        partName: '',
        partCost: '',
        companyName: ''
    });

    const [error, setError] = useState({
        errors: {},
        isError: false
    });

    const handelChange = (event, feild) => {
        setPart({ ...part, [feild]: event.target.value })
    }

    const resetPartData = () => {
        setPart({
            partName: '',
            partCost: '',
            companyName: ''
        })
    }

    const partHandler = (event) => {
        event.preventDefault()
        //validation

        //Sending data to server
        console.log(part)
        addPart(part).then((resp) => {
            console.log(resp);
            console.log("Sucess")
            toast.success("Part added successfully!!")
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
                <div className="container d-flex justify-content-center align-items-center min-vh-100 w-50 ">
                    {/* <!----------------------- Login Container --------------------------> */}
                    <Form className="row border rounded-5 p-5 justify-content-center align-items-center bg-white shadow box-area" onSubmit={partHandler}>
                        <div className="row align-items-center">
                            <div className="header-text mb-4">
                                <h2>Add Parts Here!</h2>
                            </div>
                            <div className="row">

                                <div className="row mb-3">
                                    <div className="col">
                                        <div className="form-floating mb-3">
                                            <Input type="text" className="form-control" id="partName" placeholder=""
                                                value={part.partName} onChange={(e) => { handelChange(e, 'partName') }}
                                                invalid={error.errors?.response?.data?.partName ? true : undefined} />
                                            <Label htmlFor="partName">Part Name </Label>
                                            <FormFeedback>
                                                {error.errors?.response?.data?.partName}
                                            </FormFeedback>
                                        </div>
                                    </div>
                                    <div className="col">
                                        <div className="form-floating mb-3">
                                            <Input type="text" className="form-control" id="partCost" placeholder=""
                                                value={part.partCost} onChange={(e) => { handelChange(e, 'partCost') }}
                                                invalid={error.errors?.response?.data?.partCost ? true : undefined} />
                                            <Label htmlFor="partCost">Part Cost </Label>
                                            <FormFeedback>
                                                {error.errors?.response?.data?.partCost}
                                            </FormFeedback>
                                        </div>
                                    </div>
                                    <div className="input-group ">
                                        <select className="form-select mb-3" id='companyName' value={part.companyName} onChange={(e) => { handelChange(e, 'companyName') }}>
                                            <option value="Select Company" defaultValue>----Select Company----</option>
                                            <option value="Royal Enfield">Royal Enfield</option>
                                            <option value="Hero">Hero</option>
                                            <option value="Honda">Honda</option>
                                            <option value="Bajaj">Bajaj</option>
                                            <option value="TVS">TVS</option>
                                            <option value="KTM">KTM</option>
                                            <option value="Yamaha">Yamaha</option>
                                        </select>
                                        <div className="input-group mb-3">
                                            <button type='submit' className="btn btn-lg btn-danger w-100 fs-6">Save</button>
                                        </div>
                                        <div className="input-group">
                                            <button type='reset' className="btn btn-lg btn-secondary w-100 fs-6" onClick={resetPartData}>Reset</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </Form>
                </div>
            </>
        )
    
}
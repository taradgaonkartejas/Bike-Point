import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router'
import { addJob, getServiceRequests } from '../../service/garageservice';
import { getCurrenUserDetail } from '../../auth';
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';

export default function FindServiceRequests() {

    const navigate = useNavigate()

    const id=getCurrenUserDetail()?.id;

    const [problems, setProblems] = useState([]);

    const [job, setJob]=useState({
        id:0,
        status:''
    });

    useEffect(() => {
        getServiceRequests().then((resp) => {
            setProblems(resp)
           
        }).catch((error) => {
            console.log(error)
            console.log("failed")

        })

    }, []);
    
    const createJob=(garageId,problemId,event)=>{
        event.preventDefault()
        addJob(garageId,problemId,job).then((resp) => {
            setJob({
                id:resp.id,
                status:resp.status
            })
      
            toast.success("Created a job sucessfully", {
                position: "bottom-center",
            })
            
            //Storing job to session to get job details after the session
            sessionStorage.removeItem("problemId");
            sessionStorage.setItem("problemId",problemId);
            //navigate to map page 
             navigate("/garage/map");
        }).catch((error) => {
            console.log(error)
            console.log("failed")
            toast.error("Failed to add job.", {
                position: "bottom-center",
            })
        })
        

    }
    
    return (
        <>
            <li className='list-group container mt-4' style={{ width: '70%' }}>
                {problems.map((problem, index) => {
                    return (
                        <ul className="row-sm-10 list-group-item mx-4 mb-4 border rounded-4 p-4 bg-white shadow" key={problem.id}>
                            <div className="card-body">
                                <table>
                                    <tbody className=" col-sm-10 mx-4 mb-4">
                                        <tr className='row-sm-12'>
                                            <td className='col' style={{ width: '30%' }}>
                                                <h6 className="card-title mb-3">Vehicle Company : {problem.vehicleCompany} </h6>
                                                <h6 className="card-title mb-3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Vehicle Model : {problem.vehicleModel} </h6>
                                                <h6 className="card-title">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Problem Type : {problem.problemType} </h6>
                                            </td>
                                            <td className='col' style={{ width: '30%' }}>
                                                <h6 className="card-title">Address : </h6>
                                                <p className="text-muted">{problem.address}</p>
                                            </td>
                                            <td className='col'>
                                                <h6 className="card-title">Problem Description : </h6>
                                                <p className="text-muted">{problem.problemDescription}</p>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div className="position-relative">
                                    <div className="position-absolute bottom-0 end-0 mx-3">
                                        <button className="btn btn-danger " onClick={(e)=>createJob(id,problem.id,e)}>Accept</button>
                                    </div>
                                </div>
                            </div>
                        </ul>
                    )
                })}
            </li>
            <ToastContainer/>
        </>
    )
}

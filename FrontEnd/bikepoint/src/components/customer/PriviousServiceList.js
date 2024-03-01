import React, { useEffect, useState } from 'react';
import { getCurrenUserDetail } from '../../auth';
import { findAllProblemsById } from '../../service/customerService';
import { NavLink } from 'react-router-dom';

export default function PriviousServiceList() {

    const [problems, setProblems] = useState([]);

    const id = getCurrenUserDetail()?.id;

    useEffect(() => {
        findAllProblemsById(id).then((resp) => {
            console.log("Sucess");
            console.log(resp)
            setProblems(resp)
        }).catch((error) => {
            console.log(error);
            console.log("failed");
        })
    }, []);


    return (
        <>
            <div className="container d-flex justify-content-center align-items-center ">
                <div className="py-3 my-5 row border  rounded-4 bg-white shadow box-area" style={{ width: '100%' }}>
                    <table className="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Problem Id</th>
                                <th scope="col">Vehicle Company</th>
                                <th scope="col">Model</th>
                                <th scope="col">Problem Type</th>
                                <th scope="col">Description</th>
                                <th scope="col">Status</th>
                            </tr>
                        </thead>
                        <tbody>
                            {problems.map((problem, index) => {
                                return (<tr key={problem.id} className='align-items-center'>
                                    <th >{index + 1}</th>
                                    <td>{problem.id}</td>
                                    <td>{problem.vehicleCompany}</td>
                                    <td>{problem.vehicleModel}</td>
                                    <td>{problem.problemType}</td>
                                    <td>{problem.problemDescription}</td>
                                    <td>{problem.status}</td>
                                    <td><button type='button' className="btn btn-sm btn-danger ">See Details</button></td>
                                </tr>)
                            })
                            }


                        </tbody>
                    </table>
                </div>
            </div>
        </>

    )
}

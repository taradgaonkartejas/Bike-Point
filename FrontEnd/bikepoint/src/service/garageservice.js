import { myXiois } from "./helper";

export const getGarage=(id)=>{
    return myXiois.post(`/garage/getgarage/${id}`)
    .then((response)=>response.data);
}

export const getServiceRequests=()=>{
    return myXiois.get('/garage/getservicerequests')
    .then((response)=>response.data);
}

export const addJob=(garageId,problemId,job)=>{
    return myXiois.post(`/garage/addjob/${garageId}/${problemId}`,job)
    .then((response)=>response.data);
}

export const findProblemById=(id)=>{
    return myXiois.get(`/garage/findproblem/${id}`)
    .then((response)=>response.data);
}

export const findGarageByProblem=(id)=>{
    return myXiois.get(`/garage/findgaragebyproblem/${id}`)
    .then((response)=>response.data);
}
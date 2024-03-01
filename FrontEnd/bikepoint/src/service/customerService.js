import { myXiois } from "./helper";
import axios from "axios";

export const getCustomer=(id)=>{
    return myXiois.post(`/customer/getcustomer/${id}`)
    .then((response)=>response.data);
}

export const addProblem=(id,problem)=>{
    return myXiois.post(`/customer/addproblem/${id}`,problem)
    .then((response)=>response.data);
}

export const findAllProblemsById=async (id)=>{
    return myXiois.get(`/customer/getallproblems/${id}`)
    .then((response)=>response.data);
}

export const convertToAddress = (lat, log) => {
    return axios.get(`https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=${lat}&lon=${log}`)
    .then((resp) => resp?.data?.display_name);
}
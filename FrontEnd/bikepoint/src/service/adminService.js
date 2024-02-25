import { myXiois } from "./helper";

export const addGarage=(garage)=>{
    return myXiois.post('/admin/addgarage',garage)
    .then((response)=>response.data);
}

export const addPart=(part)=>{
    return myXiois.post('/admin/addpart',part)
    .then((response)=>response.data);
}

export const addService=(service)=>{
    return myXiois.post('/admin/addservice',service)
    .then((response)=>response.data);
}
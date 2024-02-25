import { myXiois } from "./helper";

export const signUp=(user)=>{
    return myXiois.post('/customer/signup',user)
    .then((response)=>response.data);
}

export const logIn=(user)=>{
    return myXiois.post('/user/login',user)
    .then((response)=>response.data);
}


import { myXiois } from "./helper";

export const signUp=(user)=>{
    return myXiois.post('/customer/register',user)
    .then((response)=>response.data);
}
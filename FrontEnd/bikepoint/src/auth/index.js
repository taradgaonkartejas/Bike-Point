//isLoggedIn=> to check the user data in localstorage
export const isLoggedin=()=>{
    var data=localStorage.getItem("data")
    if (data==null) {
        return false;
    }else{  
        return true;
    }
}

//doLogin=> set to localstorage
export const doLogin=(data,next)=>{
    localStorage.setItem("data", JSON.stringify(data));
    next()
}

//doLogout=> remove  from localstorage
export const doLogout=(next)=>{
    localStorage.removeItem("data");
    next()
}

//get currentUser
export const getCurrenUserDetail=()=>{
    if (isLoggedin()) {
       return JSON.parse(localStorage.getItem("data"))?.user;
    } else {
        return undefined;
    }
}
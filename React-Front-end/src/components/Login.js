import React,{useState, useEffect} from 'react'
import {Link} from 'react-router-dom';
import axios from 'axios';

function Login() {
    const [name, setName] = useState('')
    const [password, setPassword] = useState('')
    const [employee, setEmployee] = useState([])

    const epName = employee.username;
    const accessToken = employee.accessToken;
    

   


    const login = (e) => {
        e.preventDefault();
        
        axios.post("http://localhost:8282/employees/login",{
           username:name,
           password:password
         }).then((response)=>{
             if(response.data.accessToken){
                 localStorage.setItem("employee",JSON.stringify(response.data));
                 window.location.reload();
             }
     
         });
    
    }

    useEffect(() =>{
        const employee = JSON.parse(localStorage.getItem("employee"));
        if(employee){
            setEmployee(employee);
        }
    },[])

    const cancel = (e) => {
        localStorage.removeItem("employee");
    }

    return (
        <div>
        <br /><br />
        <div className = "container">
             <div className = "row">
                 <div className = "card col-md-6 offset-md-3 offset-md-3">
                    
                     <div className = "card-body">
                         <form>
                             <div className = "form-group mb-2">
                                 <label className = "form-label"> Name :</label>
                                 <input
                                     type = "text"
                                     placeholder = "Enter first name"
                                     name = "firstName"
                                     className = "form-control"
                                     value = {name}
                                     onChange = {(e) => setName(e.target.value)}
                                 >
                                 </input>
                             </div>

                             <div className = "form-group mb-2">
                                 <label className = "form-label"> password :</label>
                                 <input
                                     type = "password"
                                     placeholder = "Enter password"
                                     name = "password"
                                     className = "form-control"
                                     value = {password}
                                     onChange = {(e) => setPassword(e.target.value)}
                                 >
                                 </input>
                             </div>

                            
                             <button className = "btn btn-success m-1" onClick = {(e) => login(e)}  >login </button>
                             <Link to="/employees" className="btn btn-danger" onClick = {(e) => cancel(e)}> Back </Link>


                         </form>

                         <h1>Name : {epName}</h1>
                         <h1>AccressToken : {accessToken}</h1>

                     </div>
                 </div>
             </div>

        </div>

     </div>
    )
}

export default Login

import axios from 'axios'



class EmployeeService{

    getAllEmployees(){
        return axios.get("http://localhost:8282/employees/getAll")
    }

    createEmployee(employee){
        return axios.post("http://localhost:8282/employees/addEmployee", employee)
    }

    getEmployeeById(employeeId){
        return axios.get("http://localhost:8282/employees/employeebyid/" + employeeId);
    }

    updateEmployee(employeeId, employee){
        return axios.put("http://localhost:8282/employees/updateemployee/" +employeeId, employee);
    }

    deleteEmployee(employeeId){
        return axios.delete("http://localhost:8282/employees/deleteemployee/" + employeeId);
    }

    
}

export default new EmployeeService();
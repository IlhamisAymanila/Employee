package com.ilham.employee.Service;

import com.ilham.employee.DTO.LoginDto;
import com.ilham.employee.Model.Employee;
import com.ilham.employee.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements UserDetailsService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveEmployee( Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(long id){
        return employeeRepository.findById(id).orElse(null);
    }



    public String deleteEmployee(long id){
        employeeRepository.deleteById(id);
        return "Employee Removed"+ id;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepository.findByName(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found" + username));
        return LoginDto.build(employee);
    }
}

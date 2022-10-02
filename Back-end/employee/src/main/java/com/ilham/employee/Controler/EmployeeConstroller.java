package com.ilham.employee.Controler;

import com.ilham.employee.DTO.JwtResponse;
import com.ilham.employee.DTO.LoginDto;
import com.ilham.employee.DTO.LoginRequest;
import com.ilham.employee.Model.Employee;
import com.ilham.employee.Repository.EmployeeRepository;
import com.ilham.employee.Service.EmployeeService;
import com.ilham.employee.Service.LoginService.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("employees")
public class EmployeeConstroller {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;



    @PostMapping("/addEmployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/getAll")
    public List<Employee> gellAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("employeebyid/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable long id){
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("updateemployee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee){
        Employee updateEmployee = employeeRepository.findById(id).orElse(null);
        updateEmployee.setName(employee.getName());
        updateEmployee.setEmailid(employee.getEmailid());
        updateEmployee.setAddress(employee.getAddress());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    @DeleteMapping("deleteemployee/{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        String employee = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateJwtToken(authentication);

        LoginDto userDetails = (LoginDto) authentication.getPrincipal();

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername()));
    }




}

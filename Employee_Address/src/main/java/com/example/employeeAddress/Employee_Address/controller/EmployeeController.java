package com.example.employeeAddress.Employee_Address.controller;

import com.example.employeeAddress.Employee_Address.model.Employee;
import com.example.employeeAddress.Employee_Address.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    //get all employees
    @GetMapping("employees")
    public Iterable<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }


    //get employee by Id
    @GetMapping("employee/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    //create a new Employee

    @PostMapping("employees")
    public void addEmp(@RequestBody Employee employee){
        employeeService.addEmp(employee);
    }

    //update an employee by Id
    @PutMapping("employees/{id}/{firstName}/{lastName}")
    public String updateEmpById(@PathVariable Long id,@PathVariable String firstName, @PathVariable String lastName){
        return employeeService.updateEmpById(id,firstName,lastName);
    }

    //delete an employee by id
    @DeleteMapping("employees/{id}")
    public String deleteEmp(@PathVariable Long id){
        return employeeService.deleteEmp(id);
    }






}

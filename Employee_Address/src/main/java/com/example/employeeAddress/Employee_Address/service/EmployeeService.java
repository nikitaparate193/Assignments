package com.example.employeeAddress.Employee_Address.service;

import com.example.employeeAddress.Employee_Address.model.Employee;
import com.example.employeeAddress.Employee_Address.repository.IEmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    IEmployeeRepo employeeRepo;

    public Iterable<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findById(id);
    }

    public void addEmp(Employee employee) {
        employeeRepo.save(employee);
    }


    public String updateEmpById(Long id, String firstName, String lastName) {
        Optional<Employee> myEmpOpt=employeeRepo.findById(id);
        Employee myEmp=null;
        if(myEmpOpt.isPresent()){
            myEmp=myEmpOpt.get();
        }else{
            return "Id not found";
        }
        myEmp.setFirstName(firstName);
        myEmp.setLastName(lastName);
        employeeRepo.save(myEmp);
        return "Employee firstName and lastName updated";
    }

    public String deleteEmp(Long id) {
        employeeRepo.deleteById(id);
        return "Employee data deleted";

    }
}

package com.example.employeeAddress.Employee_Address.repository;

import com.example.employeeAddress.Employee_Address.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepo extends CrudRepository<Employee,Long> {


}

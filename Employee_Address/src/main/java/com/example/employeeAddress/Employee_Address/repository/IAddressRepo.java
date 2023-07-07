package com.example.employeeAddress.Employee_Address.repository;

import com.example.employeeAddress.Employee_Address.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepo extends CrudRepository<Address,Long> {
}

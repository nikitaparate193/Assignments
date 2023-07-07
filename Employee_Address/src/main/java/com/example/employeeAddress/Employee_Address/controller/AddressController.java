package com.example.employeeAddress.Employee_Address.controller;

import com.example.employeeAddress.Employee_Address.model.Address;
import com.example.employeeAddress.Employee_Address.model.Employee;
import com.example.employeeAddress.Employee_Address.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;

    //get all addresses
    @GetMapping("addresses")
    public Iterable<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }


    //get employee by Id
    @GetMapping("addresses/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id){
        return addressService.getAddressById(id);
    }

    //create a new address

    @PostMapping("addresses")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }

    //update an address by id
    @PutMapping("addresses/{id}/{street}/{city}/{zipcode}")
    public String updateAddressById(@PathVariable Long id, @PathVariable String street,@PathVariable String city, @PathVariable String zipcode){
        return addressService.updateAddressById(id,street,city,zipcode);
    }

    //delete an address by id
    @DeleteMapping("addresses/{id}")
    public String deleteAdd(@PathVariable Long id){
        return addressService.deleteAdd(id);
    }
}

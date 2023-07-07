package com.example.employeeAddress.Employee_Address.service;

import com.example.employeeAddress.Employee_Address.model.Address;
import com.example.employeeAddress.Employee_Address.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public Iterable<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressRepo.findById(id);
    }

    public void addAddress(Address address) {
        addressRepo.save(address);
    }

    public String updateAddressById(Long id, String street, String city, String zipcode) {
        Optional<Address> myAddOpt = addressRepo.findById(id);
        Address myAdd=null;
        if(myAddOpt.isPresent()){
            myAdd=myAddOpt.get();
        }else{
            return "Id not found";
        }
        myAdd.setStreet(street);
        myAdd.setCity(city);
        myAdd.setZipcode(zipcode);

        addressRepo.save(myAdd);
        return "Address updated";
    }

    public String deleteAdd(Long id) {
        addressRepo.deleteById(id);
        return "Address deleted";
    }
}

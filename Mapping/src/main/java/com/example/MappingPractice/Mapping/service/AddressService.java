package com.example.MappingPractice.Mapping.service;

import com.example.MappingPractice.Mapping.model.Address;
import com.example.MappingPractice.Mapping.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public void createAddress(Address address) {
        addressRepo.save(address);

    }

    public List<Address> getAllAddresses() {
        return addressRepo.findAll();
    }

    public String updateAddressLandmark(String addressId, String addressLandmark) {
        Optional<Address> myAddOpt = addressRepo.findById(addressId);
        Address myAdd = null;
        if(myAddOpt.isPresent()){
            myAdd = myAddOpt.get();
        }else{
            return "Id not found";
        }
        myAdd.setAddressLandmark(addressLandmark);
        addressRepo.save(myAdd);
        return "Address Landmark updated";
    }

    public String deleteAddress(String addressId) {
        addressRepo.deleteById(addressId);
        return "address deleted";
    }
}

package com.example.MappingPractice.Mapping.controller;

import com.example.MappingPractice.Mapping.model.Address;
import com.example.MappingPractice.Mapping.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("address")
    public void createAddress(@Valid @RequestBody Address address){
        addressService.createAddress(address);
    }

    @GetMapping("addresses")
    public List<Address> getAllAddresses(){
        return addressService.getAllAddresses();
    }

    @PutMapping("address/{addressId}/{addressLandmark}")
    public String updateAddressLandmark(@PathVariable String addressId, @PathVariable String addressLandmark){
        return addressService.updateAddressLandmark(addressId,addressLandmark);
    }

    @DeleteMapping("address/{addressId}")
    public String deleteAddress(@PathVariable String addressId){
        return addressService.deleteAddress(addressId);
    }
}



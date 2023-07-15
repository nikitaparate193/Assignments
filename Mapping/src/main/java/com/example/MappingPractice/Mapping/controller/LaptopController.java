package com.example.MappingPractice.Mapping.controller;

import com.example.MappingPractice.Mapping.model.Laptop;
import com.example.MappingPractice.Mapping.service.LaptopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class LaptopController {

    @Autowired
    LaptopService laptopService;

    @PostMapping("laptop")
    public void createLaptop(@Valid @RequestBody Laptop laptop){
        laptopService.createLaptop(laptop);
    }

    @GetMapping("laptops")
    public List<Laptop> getAllLaptops(){
        return laptopService.getAllLaptops();
    }

    @PutMapping("laptop/{laptopId}/{laptopName}")
    public String updateLaptopName(@PathVariable String laptopId, @PathVariable String laptopName){
        return laptopService.updateLaptopName(laptopId,laptopName);
    }

    @DeleteMapping("laptop/{laptopId}")
    public String deleteLaptop(@PathVariable String laptopId){
        return laptopService.deleteLaptop(laptopId);
    }
}

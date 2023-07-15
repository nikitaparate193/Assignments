package com.example.MappingPractice.Mapping.service;

import com.example.MappingPractice.Mapping.model.Laptop;
import com.example.MappingPractice.Mapping.repository.ILaptopRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaptopService {

    @Autowired
    ILaptopRepo laptopRepo;

    public void createLaptop(Laptop laptop) {
        laptopRepo.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepo.findAll();
    }

    public String updateLaptopName(String laptopId, String laptopName) {
        Optional<Laptop> myLapOpt = laptopRepo.findById(laptopId);
        Laptop myLap=null;
        if(myLapOpt.isPresent()){
            myLap=myLapOpt.get();
        }else{
            return "Laptop id not found";
        }
        myLap.setLaptopName(laptopName);
        laptopRepo.save(myLap);
        return "laptop name updated";
    }

    public String deleteLaptop(String laptopId) {
        laptopRepo.deleteById(laptopId);
        return "laptop deleted";
    }
}

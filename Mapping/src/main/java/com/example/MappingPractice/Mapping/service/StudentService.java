package com.example.MappingPractice.Mapping.service;

import com.example.MappingPractice.Mapping.model.Student;
import com.example.MappingPractice.Mapping.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public void createStudent(Student student) {
        studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public String updateStudentDepartment(String studentId, String studentDepartment) {
        Optional<Student> myStuOpt = studentRepo.findById(studentId);
        Student mystu = null;
        if(myStuOpt.isPresent()){
            mystu=myStuOpt.get();
        }else{
            return "student id not found";
        }
        mystu.setStudentDepartment(studentDepartment);
        studentRepo.save(mystu);
        return "student department updated";

    }

    public String deleteStudent(String studentId) {
        studentRepo.deleteById(studentId);
        return "student deleted";
    }
}

package com.example.UniversityEvent1.UniversityEventManagement1.service;

import com.example.UniversityEvent1.UniversityEventManagement1.Repository.IStudentRepo;
import com.example.UniversityEvent1.UniversityEventManagement1.model.StudentModel;
import com.example.UniversityEvent1.UniversityEventManagement1.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;
//    Add student
//update student department
//delete student
//Get all students
//Get student by Id

    public void addStudent(StudentModel studentModel){
        studentRepo.save(studentModel);
    }

    public String updateStudentDepartment(Long studentId, Type type) {
        Optional<StudentModel> myStudentOpt = studentRepo.findById(studentId);
        StudentModel myStudent=null;
        if(myStudentOpt.isPresent()){
            myStudent=myStudentOpt.get();
        }else{
            return "Id not Found";
        }
        myStudent.setDepartment(type);
        studentRepo.save(myStudent);
        return "room type updated";
    }

    public String deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
        return "student deleted successfully";
    }

    public Iterable<StudentModel> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<StudentModel> getStudentById(Long studentId) {
        return studentRepo.findById(studentId);
    }
}

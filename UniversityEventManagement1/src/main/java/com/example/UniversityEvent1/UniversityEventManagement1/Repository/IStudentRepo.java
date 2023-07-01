package com.example.UniversityEvent1.UniversityEventManagement1.Repository;

import com.example.UniversityEvent1.UniversityEventManagement1.model.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepo extends CrudRepository<StudentModel, Long> {
//    List<StudentModel> findByStudentId(Long studentId);
}

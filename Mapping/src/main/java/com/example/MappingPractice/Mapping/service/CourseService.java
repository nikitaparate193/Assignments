package com.example.MappingPractice.Mapping.service;

import com.example.MappingPractice.Mapping.model.Course;
import com.example.MappingPractice.Mapping.repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    ICourseRepo courseRepo;

    public void createCourse(Course course) {
        courseRepo.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public String updateCourseTitle(String courseId, String courseTitle) {
        Optional<Course> myCouOpt = courseRepo.findById(courseId);
        Course myCou = null;
        if(myCouOpt.isPresent()){
            myCou=myCouOpt.get();
        }else{
            return "course Id not found";
        }
        myCou.setCourseTitle(courseTitle);
        courseRepo.save(myCou);
        return "Course Title Updated";
    }

    public String deleteCourse(String courseId) {
        courseRepo.deleteById(courseId);
        return "course deleted";
    }
}

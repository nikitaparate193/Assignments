package com.example.MappingPractice.Mapping.controller;

import com.example.MappingPractice.Mapping.model.Course;
import com.example.MappingPractice.Mapping.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class CourseController {

    @Autowired
    CourseService courseService;

    @PostMapping("course")
    public void createCourse(@Valid @RequestBody Course course){
        courseService.createCourse(course);
    }

    @GetMapping("courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();

    }

    @PutMapping("course/{courseId}/{courseTitle}")
    public String updateCourseTitle(@PathVariable String courseId, @PathVariable String courseTitle){
        return courseService.updateCourseTitle(courseId,courseTitle);
    }

    @DeleteMapping("course/{courseId}")
    public String deleteCourse(@PathVariable String courseId){
        return courseService.deleteCourse(courseId);
    }
}



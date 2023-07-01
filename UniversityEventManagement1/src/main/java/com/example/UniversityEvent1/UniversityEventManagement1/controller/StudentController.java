package com.example.UniversityEvent1.UniversityEventManagement1.controller;

import com.example.UniversityEvent1.UniversityEventManagement1.model.EventModel;
import com.example.UniversityEvent1.UniversityEventManagement1.model.StudentModel;
import com.example.UniversityEvent1.UniversityEventManagement1.model.Type;
import com.example.UniversityEvent1.UniversityEventManagement1.service.EventService;
import com.example.UniversityEvent1.UniversityEventManagement1.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@Validated
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    EventService eventService;

    @PostMapping("student")
    public void addStudent(@Valid @RequestBody StudentModel studentModel){
        studentService.addStudent(studentModel);
    }

    @PutMapping("student/{studentId}/{type}")
    public String updateStudentDepartment(@PathVariable Long studentId, @PathVariable Type type){
        return studentService.updateStudentDepartment(studentId,type);
    }

    @DeleteMapping("room/{studentId}")
    public String deleteStudent(@PathVariable Long studentId){
        return studentService.deleteStudent(studentId);
    }

    @GetMapping("students")
    public Iterable<StudentModel> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("student/{studentId}")
    public Optional<StudentModel> getStudentById(@PathVariable Long studentId){
        return studentService.getStudentById(studentId);
    }

    //event
    //add event
    @PostMapping("event")
    public void addEvent(@RequestBody @Valid EventModel eventModel){
        eventService.addEvent(eventModel);
    }

    //update event
    @PutMapping("event/{eventId}/{eventName}")
    public String updateEventById(@PathVariable Long eventId, @PathVariable  String eventName){
        return eventService.updateEventById(eventId,eventName);
    }

    //delete event
    @DeleteMapping("event/{eventId}")
    public String deleteEvent(@PathVariable Long eventId){
        return eventService.deleteEvent(eventId);
    }

    @GetMapping("event")
    public Iterable<EventModel> getAllEvent(){
        return eventService.getAllEvent();
    }

    //get all event by date

    @GetMapping("event/date/{date}")
    public List<EventModel> getAllEventsByDate(@PathVariable LocalDate date){
        return eventService.getAllEventsByDate(date);


    }

}

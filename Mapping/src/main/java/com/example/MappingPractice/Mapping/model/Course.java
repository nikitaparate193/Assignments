package com.example.MappingPractice.Mapping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    private String courseId;

    private String courseTitle;
    private String courseDescription;
    private String courseDuration;
    //unidirectional
    @ManyToMany
    @JoinTable(name="fk_course_student_table",joinColumns = @JoinColumn(name = "fk_course_id"),inverseJoinColumns = @JoinColumn(name = "fk_student_id"))
    List<Student> students;

}

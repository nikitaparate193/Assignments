package com.example.UniversityEvent1.UniversityEventManagement1.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Student")
public class StudentModel {

    @Id
    private Long studentId;

    @NotNull
    @Pattern(regexp = "[A-Z][a-zA-Z]*",message = "First name should start with a capital letter")
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    @Min(value = 18, message = "Age should be at least 18")
    @Max(value = 25, message = "Age should not exceed 25")
    private Integer age;


    @Enumerated(EnumType.STRING)
    private Type department;
}

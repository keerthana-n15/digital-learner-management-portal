package com.project.Faculty.model;

import com.project.Faculty.enums.Department;
import com.project.Faculty.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "faculty_table")
public class FacultyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long facultyId;

    @Column(nullable = false)
    private String facultyName;

    @Column(nullable = false, unique = true)
    private String facultyEmail;

    @Column(nullable = false, unique = true, length = 10)
    private String facultyPhoneNumber;

    @Column(nullable = false)
    private Double facultySalary;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Department facultyDepartment;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender facultyGender;


    private Boolean active = true;
}
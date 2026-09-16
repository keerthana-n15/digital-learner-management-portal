package com.project.Faculty.controller;

import com.project.Faculty.enums.Department;
import com.project.Faculty.enums.Gender;
import com.project.Faculty.model.FacultyEntity;
import com.project.Faculty.service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // GET BY ID
    @GetMapping("/getFacultyById/{id}")
    public ResponseEntity<Optional<FacultyEntity>> getFacultyById(@PathVariable Long id) {
        return ResponseEntity.ok(facultyService.getFacultyById(id)
        );
    }

    // GET BY NAME
    @GetMapping("/getFacultyByName")
    public ResponseEntity<List<FacultyEntity>> getFacultyByName(@RequestParam String facultyName) {

        return ResponseEntity.ok(facultyService.getFacultyByName(facultyName)
        );
    }

    // GET BY EMAIL
    @GetMapping("/getFacultyByEmail")
    public ResponseEntity<Optional<FacultyEntity>> getFacultyByEmail(@RequestParam String facultyEmail) {

        return ResponseEntity.ok(facultyService.getFacultyByEmail(facultyEmail)
        );
    }

    // GET BY DEPARTMENT
    @GetMapping("/getFacultyByDepartment")
    public ResponseEntity<List<FacultyEntity>> getFacultyByDepartment(@RequestParam Department facultyDepartment) {

        return ResponseEntity.ok(facultyService.getFacultyByDepartment(facultyDepartment));
    }

    // GET BY GENDER
    @GetMapping("/getFacultyByGender")
    public ResponseEntity<List<FacultyEntity>> getFacultyByGender(@RequestParam Gender facultyGender) {
        return ResponseEntity.ok(facultyService.getFacultyByGender(facultyGender));
    }

    // ADD FACULTY
    @PostMapping("/addFaculty")
    public ResponseEntity<String> addFaculty(@RequestBody FacultyEntity facultyEntity) {
        String response = facultyService.addFaculty(facultyEntity);
        if (response.equals("Faculty Data is Saved")) {
            return ResponseEntity.status(201).body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    // UPDATE FACULTY
    @PutMapping("/updateFacultyDetail/{id}")
    public ResponseEntity<String> updateFacultyDetail(@PathVariable Long id, @RequestBody FacultyEntity facultyEntity) {

        String response = facultyService.updateFacultyDetail(id, facultyEntity);

        if (response.equals("Updated Successfully")) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    //  DELETE
    @DeleteMapping("/deleteFaculty/{id}")
    public ResponseEntity<String> deleteFaculty(@PathVariable Long id) {
        String response = facultyService.deleteFaculty(id);
        if (response.equals("Faculty Deleted Successfully")) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }
}
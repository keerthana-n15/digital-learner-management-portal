package com.project.collegeproject.controller;

import com.project.collegeproject.enums.Status;
import com.project.collegeproject.enums.Type;
import com.project.collegeproject.model.CollegeEntity;
import com.project.collegeproject.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CollegeController {
    @Autowired
    private CollegeService collegeService;

    @GetMapping("/getAllColleges")
    public ResponseEntity<List<CollegeEntity>> getAllColleges() {
        return ResponseEntity.ok(collegeService.getAllColleges());
    }

    @GetMapping("/getCollegeByCode/{collegeCode}")
    public ResponseEntity<Optional<CollegeEntity>> getCollegeByCode(@PathVariable String collegeCode) {
        return ResponseEntity.ok(collegeService.getCollegeByCode(collegeCode));
    }

    @GetMapping("/getCollegeByName")
    public ResponseEntity<List<CollegeEntity>> getCollegeByName(@RequestParam String collegeName) {
        return ResponseEntity.ok(collegeService.getCollegeByName(collegeName));
    }

    @GetMapping("/getCollegeByEmail/{collegeEmail}")
    public ResponseEntity<Optional<CollegeEntity>> getCollegeByEmail(@PathVariable String collegeEmail) {
        return ResponseEntity.ok(collegeService.getCollegeByEmail(collegeEmail));
    }

    @GetMapping("/getCollegeByPhoneNumber")
    public ResponseEntity<Optional<CollegeEntity>> getCollegeByPhoneNumber(@RequestParam String collegePhoneNumber) {
        return ResponseEntity.ok(collegeService.getCollegeByPhoneNumber(collegePhoneNumber));
    }

    @GetMapping("/getCollegeByPinCode")
    public ResponseEntity<List<CollegeEntity>> getCollegeByPinCode(@RequestParam String pinCode) {
        return ResponseEntity.ok(collegeService.getCollegeByPinCode(pinCode));
    }

    @GetMapping("/getCollegeByCity/{city}")
    public ResponseEntity<List<CollegeEntity>> getCollegeByCity(@PathVariable String city) {
        return ResponseEntity.ok(collegeService.getCollegeByCity(city));
    }

    @GetMapping("/getCollegeByState")
    public ResponseEntity<List<CollegeEntity>> getCollegeByState(@RequestParam String state) {
        return ResponseEntity.ok(collegeService.getCollegeByState(state));
    }

    @GetMapping("/getCollegeByCountry")
    public ResponseEntity<List<CollegeEntity>> getCollegeByCountry(@RequestParam String country) {
        return ResponseEntity.ok(collegeService.getCollegeByCountry(country));
    }

    @GetMapping("/getCollegeByPinCodeAndCountry")
    public ResponseEntity<List<CollegeEntity>> getCollegeByPinCodeAndCountry(@RequestParam String pinCode, @RequestParam String country) {
        return ResponseEntity.ok(collegeService.getCollegeByPinCodeAndCountry(pinCode, country));
    }

    @GetMapping("/getCollegeByPinCodeAndCollegeType")
    public ResponseEntity<List<CollegeEntity>> getCollegeByPinCodeAndCollegeType(@RequestParam String pinCode, @RequestParam Type collegeType) {
        return ResponseEntity.ok(collegeService.getCollegeByPinCodeAndCollegeType(pinCode, collegeType));
    }

    @GetMapping("/getCollegeByPinCodeAndCollegeTypeAndCollegeStatus")
    public ResponseEntity<List<CollegeEntity>> getCollegeByPinCodeAndCollegeTypeAndCollegeStatus(@RequestParam String pinCode,
                                                                                                 @RequestParam Type collegeType,
                                                                                                 @RequestParam Status collegeStatus) {
        return ResponseEntity.ok(collegeService.getCollegeByPinCodeAndCollegeTypeAndCollegeStatus(pinCode, collegeType, collegeStatus));
    }

    @GetMapping("/getCollegeByType")
    public ResponseEntity<List<CollegeEntity>> getCollegeByType(@RequestParam Type collegeType) {
        return ResponseEntity.ok(collegeService.getCollegeByType(collegeType));
    }

    @GetMapping("/getCollegeByStatus")
    public ResponseEntity<List<CollegeEntity>> getCollegeByStatus(@RequestParam Status collegeStatus) {
        return ResponseEntity.ok(collegeService.getCollegeByStatus(collegeStatus));
    }

    @PostMapping("/addCollege")
    public ResponseEntity<String> addCollege(@RequestBody CollegeEntity collegeEntity) {
        String response = collegeService.addCollege(collegeEntity);
        if (response.equals("Congrats !! Your College is saved")) {
            return ResponseEntity.status(201).body(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @DeleteMapping("/deleteCollege/{collegeId}")
    public ResponseEntity<String> deleteCollegeById(@PathVariable Long collegeId) {
        String response = collegeService.deleteCollegeById(collegeId);
        if (response.equals("college id is deleted Successfully")) {
            return ResponseEntity.ok(response);
        }
        return ResponseEntity.badRequest().body(response);
    }

    @PutMapping("/update/{collegeId}")
    public ResponseEntity<String> updateCollege(@PathVariable Long collegeId, @RequestBody CollegeEntity collegeEntity) {
        return ResponseEntity.ok(collegeService.updateCollege(collegeId, collegeEntity));

    }
}

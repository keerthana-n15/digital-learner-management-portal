package com.project.Faculty.service;

import com.project.Faculty.enums.Department;
import com.project.Faculty.enums.Gender;
import com.project.Faculty.model.FacultyEntity;
import com.project.Faculty.repository.FacultyRepository;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    // ADD FACULTY
    public String addFaculty(FacultyEntity facultyEntity) {

        if (ObjectUtils.isEmpty(facultyEntity)) {
            return "Please Write Faculty Details";
        }

        if (StringUtils.isBlank(facultyEntity.getFacultyName())) {
            return "Invalid Faculty Name";
        }

        if (StringUtils.isBlank(facultyEntity.getFacultyEmail())) {
            return "Invalid Faculty Email";
        }

        if (StringUtils.isBlank(facultyEntity.getFacultyPhoneNumber())) {
            return "Invalid Faculty Phone Number";
        }

        if (ObjectUtils.isEmpty(facultyEntity.getFacultySalary())) {
            return "Invalid Faculty Salary";
        }

        if (ObjectUtils.isEmpty(facultyEntity.getFacultyDepartment())) {
            return "Invalid Faculty Department";
        }

        if (ObjectUtils.isEmpty(facultyEntity.getFacultyGender())) {
            return "Invalid Faculty Gender";
        }

        if (facultyRepository.findByFacultyEmail(facultyEntity.getFacultyEmail()).isPresent()) {

            return "Faculty Email Already Exists";
        }

        if (facultyRepository.findByFacultyPhoneNumber(facultyEntity.getFacultyPhoneNumber()).isPresent()) {

            return "Faculty Phone Number Already Exists";
        }
        facultyEntity.setActive(true);

        facultyRepository.save(facultyEntity);

        return "Faculty Data is Saved";
    }

    // GET BY ID
    public Optional<FacultyEntity> getFacultyById(Long id) {

        if (id == null) {
            return Optional.empty();
        }

        // CHANGED
        return facultyRepository.findByFacultyIdAndActive(id, true);
    }

    // GET BY NAME
    public List<FacultyEntity> getFacultyByName(
            String facultyName) {

        if (StringUtils.isBlank(facultyName)) {
            return List.of();
        }

        // CHANGED
        return facultyRepository.findByFacultyNameAndActive(facultyName, true);
    }

    // GET BY EMAIL
    public Optional<FacultyEntity> getFacultyByEmail(String facultyEmail) {

        if (StringUtils.isBlank(facultyEmail)) {
            return Optional.empty();
        }

        // CHANGED
        return facultyRepository.findByFacultyEmailAndActive(facultyEmail, true);
    }

    // GET BY DEPARTMENT
    public List<FacultyEntity> getFacultyByDepartment(Department facultyDepartment) {

        if (ObjectUtils.isEmpty(facultyDepartment)) {
            return List.of();
        }

        // CHANGED
        return facultyRepository.findByFacultyDepartmentAndActive(facultyDepartment, true);
    }

    // GET BY GENDER
    public List<FacultyEntity> getFacultyByGender(Gender facultyGender) {

        if (ObjectUtils.isEmpty(facultyGender)) {
            return List.of();
        }
        // CHANGED
        return facultyRepository.findByFacultyGenderAndActive(facultyGender, true);
    }

    // UPDATE FACULTY
    public String updateFacultyDetail(Long id, FacultyEntity facultyEntity) {

        Optional<FacultyEntity> existingFaculty = facultyRepository.findByFacultyIdAndActive(id, true);

        if (existingFaculty.isEmpty()) {
            return "This faculty id does not exist";
        }

        if (ObjectUtils.isEmpty(facultyEntity)) {
            return "Please Write Faculty Details";
        }

        if (StringUtils.isBlank(
                facultyEntity.getFacultyName())) {
            return "Invalid Faculty Name";
        }

        if (StringUtils.isBlank(
                facultyEntity.getFacultyEmail())) {
            return "Invalid Faculty Email";
        }

        if (StringUtils.isBlank(
                facultyEntity.getFacultyPhoneNumber())) {
            return "Invalid Faculty Phone Number";
        }

        if (ObjectUtils.isEmpty(
                facultyEntity.getFacultySalary())) {
            return "Invalid Faculty Salary";
        }

        if (ObjectUtils.isEmpty(
                facultyEntity.getFacultyDepartment())) {
            return "Invalid Faculty Department";
        }

        if (ObjectUtils.isEmpty(
                facultyEntity.getFacultyGender())) {
            return "Invalid Faculty Gender";
        }

        // Check email belongs to another faculty
        Optional<FacultyEntity> existingEmail =
                facultyRepository.findByFacultyEmail(
                        facultyEntity.getFacultyEmail()
                );

        if (existingEmail.isPresent()
                && !existingEmail.get()
                .getFacultyId()
                .equals(id)) {

            return "Faculty Email Already Exists";
        }

        // Check phone belongs to another faculty
        Optional<FacultyEntity> existingPhone =
                facultyRepository.findByFacultyPhoneNumber(
                        facultyEntity.getFacultyPhoneNumber()
                );

        if (existingPhone.isPresent()
                && !existingPhone.get()
                .getFacultyId()
                .equals(id)) {

            return "Faculty Phone Number Already Exists";
        }

        FacultyEntity faculty = existingFaculty.get();

        faculty.setFacultyName(
                facultyEntity.getFacultyName());

        faculty.setFacultyEmail(
                facultyEntity.getFacultyEmail());

        faculty.setFacultyPhoneNumber(
                facultyEntity.getFacultyPhoneNumber());

        faculty.setFacultySalary(
                facultyEntity.getFacultySalary());

        faculty.setFacultyDepartment(
                facultyEntity.getFacultyDepartment());

        faculty.setFacultyGender(
                facultyEntity.getFacultyGender());

        facultyRepository.save(faculty);

        return "Updated Successfully";
    }


    // SOFT DELETE

    public String deleteFaculty(Long id) {

        // Only find ACTIVE faculty
        Optional<FacultyEntity> existingFaculty =
                facultyRepository.findByFacultyIdAndActive(id, true);

        if (existingFaculty.isEmpty()) {
            return "This faculty id does not exist";
        }

        FacultyEntity faculty = existingFaculty.get();

        // IMPORTANT:
        // We are NOT deleting the database row.
        // We are only changing active = false.
        faculty.setActive(false);

        facultyRepository.save(faculty);

        return "Faculty Deleted Successfully";
    }
}
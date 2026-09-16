package com.project.Faculty.repository;

import com.project.Faculty.enums.Department;
import com.project.Faculty.enums.Gender;
import com.project.Faculty.model.FacultyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository
        extends JpaRepository<FacultyEntity, Long> {

    List<FacultyEntity> findByFacultyNameAndActive(String facultyName, Boolean active);

    Optional<FacultyEntity> findByFacultyEmailAndActive(String facultyEmail, Boolean active);

    List<FacultyEntity> findByFacultyDepartmentAndActive(Department facultyDepartment, Boolean active);

    List<FacultyEntity> findByFacultyGenderAndActive(Gender facultyGender, Boolean active);

    Optional<FacultyEntity> findByFacultyIdAndActive(Long facultyId, Boolean active);

    Optional<FacultyEntity> findByFacultyEmail(String facultyEmail);

    Optional<FacultyEntity> findByFacultyPhoneNumber(String facultyPhoneNumber);
}
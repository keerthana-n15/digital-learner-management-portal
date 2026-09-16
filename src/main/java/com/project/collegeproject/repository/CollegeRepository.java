package com.project.collegeproject.repository;

import com.project.collegeproject.enums.Status;
import com.project.collegeproject.enums.Type;
import com.project.collegeproject.model.CollegeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollegeRepository extends JpaRepository<CollegeEntity, Long> {
    Optional<CollegeEntity> findByCollegeCode(String collegeCode);

    List<CollegeEntity> findByCollegeName(String collegeName);

    Optional<CollegeEntity> findByCollegeEmail(String collegeEmail);

    Optional<CollegeEntity> findByCollegePhoneNumber(String collegePhoneNumber);

//    List<CollegeEntity> findByCollegeAddress(String address); useless now


    List<CollegeEntity> findByCollegeType(Type collegeType);

    List<CollegeEntity> findByCollegeStatus(Status collegeStatus);


    List<CollegeEntity> findByCollegeAddress_City(String city);

    List<CollegeEntity> findByCollegeAddress_PinCode(String pinCode);

    List<CollegeEntity> findByCollegeAddress_State(String state);

    List<CollegeEntity> findByCollegeAddress_Country(String country);

    List<CollegeEntity> findByCollegeAddress_PinCodeAndCollegeAddress_Country(String pinCode, String country);

    List<CollegeEntity> findByCollegeAddress_PinCodeAndCollegeType(String pinCode, Type collegeType);

    List<CollegeEntity> findByCollegeAddress_PinCodeAndCollegeTypeAndCollegeStatus(String pinCode, Type collegeType, Status collegeStatus);
}

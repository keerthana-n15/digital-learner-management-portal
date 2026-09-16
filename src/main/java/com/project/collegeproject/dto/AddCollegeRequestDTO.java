package com.project.collegeproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor


public class AddCollegeRequestDTO {

    private String collegeCode;
    private String collegeName;
    private String collegeEmail;
    private String collegePhoneNumber;
    private String collegeAddress;
}

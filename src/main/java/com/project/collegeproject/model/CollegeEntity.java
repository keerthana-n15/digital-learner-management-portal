package com.project.collegeproject.model;


import com.project.collegeproject.enums.Status;
import com.project.collegeproject.enums.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "college_table")

public class CollegeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "college_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String collegeCode;

    @Column(nullable = false)
    private String collegeName;

    @Column(nullable = false, unique = true)
    private String collegeEmail;

    @Column(nullable = false, unique = true, length = 10)
    private String collegePhoneNumber;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Type collegeType;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Status collegeStatus;

    @CreatedDate
    private Date startDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity collegeAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "college_id")
    private List<StudentEntity> students;
}

package com.SchoolJasper.SchoolJasper.Models;

import com.SchoolJasper.SchoolJasper.BaseEntity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private int age;
    private String email;
    private String rollNumber;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}

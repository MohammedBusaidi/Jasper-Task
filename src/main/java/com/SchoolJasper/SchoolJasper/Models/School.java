package com.SchoolJasper.SchoolJasper.Models;

import com.SchoolJasper.SchoolJasper.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.OneToMany;
import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class School extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;
    private String schoolName;
    @OneToMany(mappedBy = "school")
    private Set<Student> students;
}

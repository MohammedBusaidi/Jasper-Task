package com.SchoolJasper.SchoolJasper.Models;

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

public class Mark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long markId;
    private float mark;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

}

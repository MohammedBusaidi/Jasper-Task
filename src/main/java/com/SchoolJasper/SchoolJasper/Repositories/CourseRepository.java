package com.SchoolJasper.SchoolJasper.Repositories;

import com.SchoolJasper.SchoolJasper.Models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}

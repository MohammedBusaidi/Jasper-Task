package com.SchoolJasper.SchoolJasper.Services;

import com.SchoolJasper.SchoolJasper.Models.Course;
import com.SchoolJasper.SchoolJasper.Repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public Long createCourse(Course course) {
        LocalDateTime now = LocalDateTime.now();
        course.setCreatedDate(now);
        course.setActive(true);
        courseRepository.save(course);
        return course.getCourseId();
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}

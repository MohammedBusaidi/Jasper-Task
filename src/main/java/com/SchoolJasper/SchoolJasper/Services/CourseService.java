package com.SchoolJasper.SchoolJasper.Services;

import com.SchoolJasper.SchoolJasper.Models.Course;
import com.SchoolJasper.SchoolJasper.Models.School;
import com.SchoolJasper.SchoolJasper.Repositories.CourseRepository;
import com.SchoolJasper.SchoolJasper.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    SchoolService schoolService;

    public Long createCourse(Long schoolId, Course course) {
        LocalDateTime now = LocalDateTime.now();
        School school = schoolService.getSchoolById(schoolId);
        course.setSchool(school);
        course.setCreatedDate(now);
        course.setActive(true);
        courseRepository.save(course);
        return course.getCourseId();
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(Long courseId){
        return courseRepository.findById(courseId).get();
    }

    public void deleteCourse(Long courseId) {
        Course course = courseRepository
                .findById(courseId)
                .get();
        courseRepository.delete(course);
    }
}

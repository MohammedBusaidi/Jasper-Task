package com.SchoolJasper.SchoolJasper.Services;

import com.SchoolJasper.SchoolJasper.Models.Course;
import com.SchoolJasper.SchoolJasper.Models.Student;
import com.SchoolJasper.SchoolJasper.Models.StudentCourse;
import com.SchoolJasper.SchoolJasper.Repositories.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {
    @Autowired
    StudentCourseRepository studentCourseRepository;
    @Autowired
    StudentService studentService;
    @Autowired
    CourseService courseService;

    public StudentCourse assignGrade(Long courseId, Long studentId, StudentCourse studentCourse) {
        Course course = courseService.getCourseById(courseId);
        Student student = studentService.getStudentById(studentId);

        studentCourse.setCourse(course);
        studentCourse.setStudent(student);
        return studentCourseRepository.save(studentCourse);
    }
}

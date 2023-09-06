package com.SchoolJasper.SchoolJasper.Controllers;

import com.SchoolJasper.SchoolJasper.Models.APICustomResponse;
import com.SchoolJasper.SchoolJasper.Models.Course;
import com.SchoolJasper.SchoolJasper.Models.StudentCourse;
import com.SchoolJasper.SchoolJasper.Services.CourseService;
import com.SchoolJasper.SchoolJasper.Services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/course")
public class CourseController extends GenericController {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentCourseService studentCourseService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return createResponse(
                Map.of("courses", courses),
                "List of all courses",
                OK);
    }

    @PostMapping("{schoolId}")
    public ResponseEntity<?> createCourse(
            @PathVariable("schoolId") Long schoolId,
            @RequestBody Course course) {
        Long courseId = courseService.createCourse(schoolId,course);
        return createResponse(
                Map.of("course_Id", courseId),
                "Course has been created successfully",
                CREATED);
    }

    @PostMapping("{course_id}/student/{student_id}")
    public ResponseEntity<APICustomResponse> assignGrade(
            @PathVariable("course_id") Long courseId,
            @PathVariable("student_id") Long studentId,
            @RequestBody StudentCourse studentCourse
    ) {
        studentCourseService.assignGrade(courseId, studentId, studentCourse);
        return createResponse(
                Map.of("course_Id", courseId),
                "Grade has been assigned successfully",
                CREATED);
    }


}

package com.SchoolJasper.SchoolJasper.Controllers;

import com.SchoolJasper.SchoolJasper.Models.APICustomResponse;
import com.SchoolJasper.SchoolJasper.Models.Course;
import com.SchoolJasper.SchoolJasper.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/Course")
public class CourseController extends GenericController {
    @Autowired
    CourseService courseService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return createResponse(
                Map.of("courses", courses),
                "List of all courses",
                OK);
    }


}

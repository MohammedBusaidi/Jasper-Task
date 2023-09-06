package com.SchoolJasper.SchoolJasper.Controllers;

import com.SchoolJasper.SchoolJasper.Models.APICustomResponse;
import com.SchoolJasper.SchoolJasper.Models.Course;
import com.SchoolJasper.SchoolJasper.Models.Student;
import com.SchoolJasper.SchoolJasper.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/student")
public class StudentController extends GenericController{
    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return createResponse(
                Map.of("students", students),
                "List of all students",
                OK);
    }
    @PostMapping
    public ResponseEntity<?> createStudent(
            @RequestBody Student student) {
        Long studentId = studentService.createStudent(student);
        return createResponse(
                Map.of("student_Id", studentId),
                "Student has been created successfully",
                CREATED);
    }
}

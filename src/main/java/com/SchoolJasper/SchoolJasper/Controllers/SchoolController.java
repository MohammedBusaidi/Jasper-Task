package com.SchoolJasper.SchoolJasper.Controllers;

import com.SchoolJasper.SchoolJasper.Models.APICustomResponse;
import com.SchoolJasper.SchoolJasper.Models.School;
import com.SchoolJasper.SchoolJasper.Models.Student;
import com.SchoolJasper.SchoolJasper.Services.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("api/school")
public class SchoolController extends GenericController {
    @Autowired
    SchoolService schoolService;

    @GetMapping
    public ResponseEntity<APICustomResponse> getAllSchools() {
        List<School> schools = schoolService.getAllSchools();
        return createResponse(
                Map.of("schools", schools),
                "List of all schools",
                OK);
    }
    @PostMapping
    public ResponseEntity<?> createSchool(
            @RequestBody School school) {
        Long schoolId = schoolService.createSchool(school);
        return createResponse(
                Map.of("school_Id", schoolId),
                "School has been created successfully",
                CREATED);
    }
}

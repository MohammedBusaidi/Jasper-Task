package com.SchoolJasper.SchoolJasper.Services;

import com.SchoolJasper.SchoolJasper.Models.School;
import com.SchoolJasper.SchoolJasper.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SchoolService {
    @Autowired
    SchoolRepository schoolRepository;

    public Long createSchool(School school) {
        LocalDateTime now = LocalDateTime.now();
        school.setCreatedDate(now);
        school.setActive(true);
        schoolRepository.save(school);
        return school.getSchoolId();
    }

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchoolById(Long id){
        return schoolRepository.findById(id).get();
    }

    public void deleteSchool(Long schoolId) {
        School school = schoolRepository
                .findById(schoolId)
                .get();
        schoolRepository.delete(school);
    }

}

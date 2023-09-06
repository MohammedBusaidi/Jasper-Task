package com.SchoolJasper.SchoolJasper.Services;

import com.SchoolJasper.SchoolJasper.Models.School;
import com.SchoolJasper.SchoolJasper.Repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
}

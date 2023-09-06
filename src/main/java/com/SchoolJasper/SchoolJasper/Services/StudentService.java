package com.SchoolJasper.SchoolJasper.Services;

import com.SchoolJasper.SchoolJasper.Models.School;
import com.SchoolJasper.SchoolJasper.Models.Student;
import com.SchoolJasper.SchoolJasper.Repositories.SchoolRepository;
import com.SchoolJasper.SchoolJasper.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SchoolService schoolService;

    public Long createStudent(Long schoolId, Student student) {
        LocalDateTime now = LocalDateTime.now();
        School school = schoolService.getSchoolById(schoolId);
        student.setSchool(school);
        student.setCreatedDate(now);
        student.setActive(true);
        studentRepository.save(student);
        return student.getStudentId();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId){
        return studentRepository.findById(studentId).get();
    }

    public void deleteStudent(Long studentId) {
        Student student = studentRepository
                .findById(studentId)
                .get();
        studentRepository.delete(student);
    }

}

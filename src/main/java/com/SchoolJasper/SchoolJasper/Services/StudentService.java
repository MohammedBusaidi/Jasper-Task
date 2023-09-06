package com.SchoolJasper.SchoolJasper.Services;

import com.SchoolJasper.SchoolJasper.Models.Student;
import com.SchoolJasper.SchoolJasper.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Long createStudent(Student student) {
        LocalDateTime now = LocalDateTime.now();
        student.setCreatedDate(now);
        student.setActive(true);
        studentRepository.save(student);
        return student.getStudentId();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

}

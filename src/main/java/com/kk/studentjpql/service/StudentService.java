package com.kk.studentjpql.service;
import com.kk.studentjpql.entity.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentService {
    Student CreateStudent(Student student);
    Student UpdateStudent(Student student);
    void DeleteStudent(int id);
    Student GetStudent(int id);
    List<Student> GetAllStudent();
    List<Student> findByMarkLessThan(double limit);
    List<Student> findByMarkBetween(double min, double max);
    List<Student> getByLetter(@Param("letter") String letter);
    List<Student> getByStream(@Param("stream") String stream);
}

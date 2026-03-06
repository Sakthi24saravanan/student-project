package com.kk.studentjpql.service;

import com.kk.studentjpql.entity.Student;
import com.kk.studentjpql.exception.StudentException;
import com.kk.studentjpql.repository.StudentRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository repo;
    public StudentServiceImpl(StudentRepository repo){
        this.repo=repo;
    }
    @Override
    public Student CreateStudent(Student student){
        return repo.save(student);
    }
    @Override
    public Student UpdateStudent(Student student) {
        Student updated = repo.findById(student.getId()).orElseThrow(() -> new StudentException("Updated failed for id: "+student.getId()));
        updated.setMark(student.getMark());
        return repo.save(updated);
    }
    @Override
    public void DeleteStudent(int id){
        repo.deleteById(id);
    }
    @Override
    public Student GetStudent(int id){
        return repo.findById(id).orElseThrow(()->new StudentException("Get Student failed for id: "+id));
    }
    @Override
    public List<Student> GetAllStudent(){
        return repo.findAll();
    }
    @Override
    public List<Student> findByMarkLessThan(double limit){
        return repo.findByMarkLessThan(limit);
    }
    @Override
    public List<Student> findByMarkBetween(double min, double max){
        return repo.findByMarkBetween(min,max);
    }
    @Override
    public List<Student> getByLetter(@Param("letter") String letter){
        return repo.getByLetter(letter);
    }
    @Override
    public List<Student> getByStream(@Param("stream") String stream){
        return repo.getByStream(stream);
    }
}

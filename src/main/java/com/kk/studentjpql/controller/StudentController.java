package com.kk.studentjpql.controller;

import com.kk.studentjpql.entity.Student;
import com.kk.studentjpql.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService ser;
    public StudentController(StudentService ser) {
        super();
        this.ser = ser;
    }
    @PostMapping
    public ResponseEntity<Student> CreateStudent(@RequestBody Student stu){
        Student created=ser.CreateStudent(stu);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @PutMapping
    public ResponseEntity<Student> UpdateStudent(@RequestBody Student stu){
        Student updated=ser.UpdateStudent(stu);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Student> DeleteStudent(@PathVariable int id){
        ser.DeleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/byid/{id}")
    public ResponseEntity<Student> GetStudent(@PathVariable int id){
        Student found=ser.GetStudent(id);
        return ResponseEntity.ok(found);
    }
    @GetMapping
    public ResponseEntity<List<Student>> GetAllStudent(){
        List<Student> emp=ser.GetAllStudent();
        return ResponseEntity.ok(emp);
    }
    @GetMapping("/byletter/{letter}")
    public ResponseEntity<List<Student>> getByLetter(@PathVariable String letter){
        List<Student> emp=ser.getByLetter(letter);
        return ResponseEntity.ok(emp);
    }
    @GetMapping("/bystream/{stream}")
    public ResponseEntity<List<Student>> getByStream(@PathVariable String stream){
        List<Student> emp=ser.getByStream(stream);
        return ResponseEntity.ok(emp);
    }
    @GetMapping("/bymarklessthan/{limit}")
    public ResponseEntity<List<Student>> findByMarkLessThan(@PathVariable double limit){
        List<Student> emp=ser.findByMarkLessThan(limit);
        return ResponseEntity.ok(emp);
    }
    @GetMapping("/bymarkbetween/{min}/{max}")
    public ResponseEntity<List<Student>> findByMarkBetween(@PathVariable double min,@PathVariable double max){
        List<Student> emp=ser.findByMarkBetween(min,max);
        return ResponseEntity.ok(emp);
    }
}

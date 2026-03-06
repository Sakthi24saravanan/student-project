package com.kk.studentjpql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kk.studentjpql.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
public interface StudentRepository extends JpaRepository<Student , Integer> {
    List<Student> findByMarkLessThan(double limit);
    List<Student> findByMarkBetween(double min, double max);
    @Query("SELECT s from Student s where s.name LIKE LOWER(CONCAT('%',:letter, '%'))")
    List<Student> getByLetter(@Param("letter") String letter);
    @Query("SELECT s from Student s where s.stream = :stream")
    List<Student> getByStream(@Param("stream") String stream);

}

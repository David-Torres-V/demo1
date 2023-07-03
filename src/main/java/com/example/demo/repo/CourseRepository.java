package com.example.demo.repo;

import com.example.demo.binding.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CourseRepository extends JpaRepository<Course, Serializable> {


}

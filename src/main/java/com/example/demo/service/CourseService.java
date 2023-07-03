package com.example.demo.service;

import com.example.demo.binding.Course;

import java.util.List;

public interface CourseService {
    public String upsert(Course course);

    public Course getById(Integer id);

    public List<Course> getAll();

    public String deleteById(Integer id);
}

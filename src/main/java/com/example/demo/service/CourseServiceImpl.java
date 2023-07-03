package com.example.demo.service;

import com.example.demo.binding.Course;
import com.example.demo.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;


    @Override
    public String upsert(Course course) {
        courseRepository.save(course);
        return "success";
    }

    @Override
    public Course getById(Integer id) {
        Optional<Course> course = courseRepository.findById(id);

        if(course.isPresent()){
            return course.get();
        }
        return null;
    }

    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public String deleteById(Integer id) {
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
            return "Delete success";
        } else {
            return "No record found";
        }
    }
}

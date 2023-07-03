package com.example.demo.rest;

import com.example.demo.binding.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseRestController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/course")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        return new ResponseEntity<String>(courseService.upsert(course), HttpStatus.CREATED);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Integer id){
        return new ResponseEntity<Course>(courseService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return new ResponseEntity<List<Course>>(courseService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/course")
    public ResponseEntity<String> updateCourse(@RequestBody Course course){

        String status = courseService.upsert(course);
        return new ResponseEntity<String>(status, HttpStatus.OK);
    }

    @DeleteMapping("/course/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable("id") Integer id){
        return new ResponseEntity<String>(courseService.deleteById(id), HttpStatus.OK);
    }

}

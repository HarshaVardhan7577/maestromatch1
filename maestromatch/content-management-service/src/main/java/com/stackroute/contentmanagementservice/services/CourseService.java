package com.stackroute.contentmanagementservice.services;

import java.util.List;
import java.util.Optional;

import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.contentmanagementservice.model.Course;
import com.stackroute.contentmanagementservice.repositories.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return courseRepository.findById(id);
    }

    public List<Course> getCourseByTeacherId(int id) {
        return courseRepository.findByTeacherId(id);
    }
    public List<Course> getCoursesByTeacherId(int id) {
        return courseRepository.findByTeacherId(id);
    }

    public Course createCourse(Course course) {

        return courseRepository.save(course);
    }

    public Course updateCourse(int id, Course courseDetails) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));

        course.setCourseName(courseDetails.getCourseName());
        course.setCourseDesc(courseDetails.getCourseDesc());
        course.setInstrument(courseDetails.getInstrument());
        course.setVideoUrl(courseDetails.getVideoUrl());

        return courseRepository.save(course);
    }

    public void deleteCourse(int id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));

        courseRepository.delete(course);
    }
}

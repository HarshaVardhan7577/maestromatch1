package com.stackroute.contentmanagementservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.stackroute.contentmanagementservice.model.TeacherProfile;
import com.stackroute.contentmanagementservice.services.SequenceGeneratorService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;

import com.stackroute.contentmanagementservice.model.Course;
import com.stackroute.contentmanagementservice.services.CourseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/content/courses")
public class CourseController {
    private final CourseService courseService;

    private int teacherId;

    @KafkaListener(topics ="course", groupId = "course-group")
    public void getTeacherId(@RequestBody String item)throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());


        TeacherProfile product1 = objectMapper.readValue(item, TeacherProfile.class);

        this.teacherId=product1.getUserId();

    }

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired
    private SequenceGeneratorService service;
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courseService.getCourseById(id).orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
    }
    @GetMapping("/teacher")
    public List<Course> getCourseByTeacherId() {
        return courseService.getCourseByTeacherId(this.teacherId);
    }

    @GetMapping("/teacher/{id}")
    public List<Course> getCoursesByTeacherId(@PathVariable int id){
        return courseService.getCoursesByTeacherId(id);
    }

    @PostMapping("/add")
    public Course createCourse(@RequestBody Course course) {
        course.setCourseId(service.getSequenceNumber(Course.SEQUENCE_NAME));
        course.setTeacherId(this.teacherId);
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course courseDetails) {
        return courseService.updateCourse(id, courseDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}


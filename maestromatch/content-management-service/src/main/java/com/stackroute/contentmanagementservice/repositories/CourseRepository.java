package com.stackroute.contentmanagementservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.contentmanagementservice.model.Course;

import java.util.List;

public interface CourseRepository extends MongoRepository<Course,Integer>{
    List<Course> findByTeacherId(int teacherId);
}

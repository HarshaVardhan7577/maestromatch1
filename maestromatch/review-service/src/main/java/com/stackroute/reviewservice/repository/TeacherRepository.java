package com.stackroute.reviewservice.repository;
import org.springframework.stereotype.Repository;

import com.stackroute.reviewservice.model.TeacherReview;

import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface TeacherRepository extends MongoRepository<TeacherReview,Integer> {

}



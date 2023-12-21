package com.stackroute.reviewservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.reviewservice.model.ReviewServiceModel;

@Repository
public interface ReviewServiceRepository extends MongoRepository<ReviewServiceModel, Integer> {
	List<ReviewServiceModel> findByteacherId(int teacherId);
}

package com.stackroute.contentmanagementservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.contentmanagementservice.model.ReferenceMaterial;

public interface ReferenceMaterialRepository extends MongoRepository<ReferenceMaterial,Integer>{
	 List<ReferenceMaterial> findByCourseId(int courseId);
}

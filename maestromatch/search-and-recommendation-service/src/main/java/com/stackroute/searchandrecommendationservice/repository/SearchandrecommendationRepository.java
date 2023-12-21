package com.stackroute.searchandrecommendationservice.repository;

import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.searchandrecommendationservice.model.Teacher;

@Repository
public interface SearchandrecommendationRepository extends ElasticsearchRepository<Teacher, Integer> {

	Optional<Teacher> findByuserId(int userId);

}

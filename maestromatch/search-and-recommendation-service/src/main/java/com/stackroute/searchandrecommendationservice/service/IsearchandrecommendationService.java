package com.stackroute.searchandrecommendationservice.service;

import com.stackroute.searchandrecommendationservice.model.Teacher;

public interface IsearchandrecommendationService {
	Iterable<Teacher> getAllRecommendations();

	Teacher getRecommendation(int id);

	Teacher newRecommendation(Teacher t);

	void deleteRecommendation(int id);

	Teacher updateRecommendation(Teacher t, int id);

}

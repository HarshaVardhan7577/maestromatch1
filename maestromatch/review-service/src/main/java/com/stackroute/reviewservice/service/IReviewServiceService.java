package com.stackroute.reviewservice.service;

import java.util.List;

import com.stackroute.reviewservice.model.ReviewServiceModel;

public interface IReviewServiceService {

	Iterable<ReviewServiceModel> getAllReviews();
	ReviewServiceModel createReview(ReviewServiceModel Rsm);
	ReviewServiceModel getReviewById(int id);
	void deleteReview(int id);
	ReviewServiceModel updateReviewServiceModel(ReviewServiceModel Rsm, int id);
	List<ReviewServiceModel> getByteacherId(int teacherId);


}

package com.stackroute.reviewservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.stackroute.reviewservice.model.ReviewServiceModel;
import com.stackroute.reviewservice.repository.ReviewServiceRepository;

@Service
public class ReviewServiceService implements IReviewServiceService {
	@Autowired
	ReviewServiceRepository Rr;

	@Override
	public Iterable<ReviewServiceModel> getAllReviews() {
		return Rr.findAll();
	}

	@Override
	public ReviewServiceModel createReview(ReviewServiceModel Rsm) {
		return Rr.save(Rsm);
	}

	@Override
	public ReviewServiceModel updateReviewServiceModel(ReviewServiceModel Rsm, int id) {
		ReviewServiceModel Rs1=Rr.findById(id).get();
		Rs1.setFeedback(Rsm.getFeedback());
		Rs1.setRating(Rsm.getRating());
		return Rr.save(Rs1);
	}
	@Override
	public void deleteReview(int id) {
		Rr.deleteById(id);
	}
	@Override
	public ReviewServiceModel getReviewById(int id) {
		return Rr.findById(id).get();
	}

	@Override
	public List<ReviewServiceModel> getByteacherId(int teacherId) {
		// TODO Auto-generated method stub
		return Rr.findByteacherId(teacherId);
	}
	
}
	
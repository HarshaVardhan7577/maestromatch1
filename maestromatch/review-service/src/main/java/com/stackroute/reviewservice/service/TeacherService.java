package com.stackroute.reviewservice.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.stackroute.reviewservice.model.ReviewServiceModel;
import com.stackroute.reviewservice.model.TeacherReview;
import com.stackroute.reviewservice.repository.ReviewServiceRepository;
import com.stackroute.reviewservice.repository.TeacherRepository;

@Service
public class TeacherService implements ITeacherService {
	@Autowired
	TeacherRepository Tr;

	@Override
	public Iterable<TeacherReview> getAllReviews() {
		return Tr.findAll();
	}

	@Override
	public TeacherReview createReview(TeacherReview t) {
		return Tr.save(t);
	}

	@Override
	public TeacherReview updateTeacherReview(TeacherReview t, int id) {
		TeacherReview t1=Tr.findById(id).get();
		t1.setFeedback(t.getFeedback());
		return Tr.save(t1);
	}
	@Override
	public void deleteReview(int id) {
		Tr.deleteById(id);
	}
	@Override
	public TeacherReview getReviewById(int id) {
		return Tr.findById(id).get();
	}
}
	
package com.stackroute.reviewservice.service;

import com.stackroute.reviewservice.model.TeacherReview;

public interface ITeacherService {

	Iterable<TeacherReview> getAllReviews();

	TeacherReview createReview(TeacherReview t);

	TeacherReview getReviewById(int id);

	TeacherReview updateTeacherReview(TeacherReview t, int id);

	void deleteReview(int id);

}

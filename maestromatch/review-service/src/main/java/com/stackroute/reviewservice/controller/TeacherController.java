package com.stackroute.reviewservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.reviewservice.model.ReviewServiceModel;
import com.stackroute.reviewservice.model.TeacherReview;
import com.stackroute.reviewservice.service.SequenceGeneratorService;
import com.stackroute.reviewservice.service.TeacherService;
@RestController
@RequestMapping("review/teacher")
@CrossOrigin
public class TeacherController {

	@Autowired
	TeacherService Ts;
	
	 @Autowired
	    private SequenceGeneratorService service;
	 
	@GetMapping("/All")
    Iterable<TeacherReview> getAllReviews(){
    	return Ts.getAllReviews();
    }

    @PostMapping("/savereview")
    public TeacherReview createReview(@RequestBody TeacherReview review) {

		 review.setId(service.getSequenceNumber(review.SEQUENCE_NAME));
		 TeacherReview savedReview = Ts.createReview(review);
		 return Ts.createReview(review);
    }

    @GetMapping("/{id}")
    public TeacherReview getReviewById(@PathVariable int id) {
        return Ts.getReviewById(id);
    }

    @PutMapping("/update/{id}")
    TeacherReview updateTeacherReview(@RequestBody TeacherReview t,@PathVariable int id) {
		return Ts.updateTeacherReview(t, id);
	}

    
    @DeleteMapping("/delete/{id}")
    public void deleteReview(@PathVariable int id) {
        Ts.deleteReview(id);
    }
}

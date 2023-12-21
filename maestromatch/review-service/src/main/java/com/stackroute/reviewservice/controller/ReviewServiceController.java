package com.stackroute.reviewservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.stackroute.reviewservice.model.ReviewServiceModel;
import com.stackroute.reviewservice.model.UserProfile;
import com.stackroute.reviewservice.service.ReviewServiceService;
import com.stackroute.reviewservice.service.SequenceGeneratorService;

@RestController
@RequestMapping("review/student")
@CrossOrigin
public class ReviewServiceController {
	@Autowired
	ReviewServiceService Rs;

	 @Autowired
	    private SequenceGeneratorService service;
	 
	 private int studentId;

	    @KafkaListener(topics ="booking", groupId = "review-group")
	    public void getTeacherId(@RequestBody String item)throws JsonMappingException, JsonProcessingException {
	        ObjectMapper objectMapper = new ObjectMapper();

	        objectMapper.registerModule(new JavaTimeModule());


	        UserProfile product1 = objectMapper.readValue(item, UserProfile.class);

	        this.studentId=product1.getUserId();

	    }

    @GetMapping("/All")
    Iterable<ReviewServiceModel> getAllReviews(){
    	return Rs.getAllReviews();
    }

    @PostMapping("/savereview")
    public ReviewServiceModel createReview(@RequestBody ReviewServiceModel review) {
    	 
    		 review.setId(service.getSequenceNumber(review.SEQUENCE_NAME));
    		 review.setStudentId(this.studentId);
    		 ReviewServiceModel savedReview = Rs.createReview(review);
    		 return Rs.createReview(review);
         
        
    }

    @GetMapping("/{id}")
    public List<ReviewServiceModel> getReviewById(@PathVariable int id) {
        return Rs.getByteacherId(id);
    }

    @PutMapping("update/{id}")
    ReviewServiceModel updateReviewServiceModel(@RequestBody ReviewServiceModel Rsm,@PathVariable int id) {
		return Rs.updateReviewServiceModel(Rsm, id);
	}

    
    @DeleteMapping("delete/{id}")
    public void deleteReview(@PathVariable int id) {
        Rs.deleteReview(id);
    }

    
}


package com.stackroute.reviewservice.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection="User-Service")
@Data
public class ReviewServiceModel {
	@Transient
    public static final String SEQUENCE_NAME="student_sequence";
	
		@Id
	   private int id;
	   private int studentId;
	   private int teacherId;
	   private String feedback;
	   private int rating;
	   private Date createdAt =new Date();
}
	
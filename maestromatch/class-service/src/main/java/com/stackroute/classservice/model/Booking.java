package com.stackroute.classservice.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

//@AllArgsConstructor
//@NoArgsConstructor
@Document(collection = "Booking")
public class Booking {

	@Transient
	public static final String SEQUENCE_NAME="booking_sequence";
	
	@Id
	private int bookingId;
	
	private int studentId;

	private int teacherId;

	

	private String time;

	private Date date;

	public Booking(int bookingId, int studentId, int teacherId, String time, Date date) {
		super();
		this.bookingId = bookingId;
		this.studentId = studentId;
		this.teacherId = teacherId;
		this.time = time;
		this.date = date;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
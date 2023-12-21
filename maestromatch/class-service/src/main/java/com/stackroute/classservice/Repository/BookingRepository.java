package com.stackroute.classservice.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.classservice.model.Booking;



@Repository
public interface BookingRepository extends MongoRepository<Booking,Integer> {

	List<Booking >findByStudentId(int studentid);
	
	Optional<Booking> findByBookingId(int bookingid);
	
//	Booking findByStudentIdAndTimeAndDate(int studentid, String time, Date date);
}

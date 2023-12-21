package com.stackroute.classservice.Service;

import java.util.List;
import java.util.Optional;

import com.stackroute.classservice.model.TeacherProfile;
import com.stackroute.classservice.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.classservice.Repository.BookingRepository;
import com.stackroute.classservice.model.Booking;

@Service
public class BookingService implements IBookingService {

	private int studentId;
	@Autowired
	BookingRepository br;



	@Override
	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub


		return br.save(booking);
	}

	@Override
	public Booking getBookingById(int bookingId) {
		// TODO Auto-generated method stub
		return br.findById(bookingId).get();
	}

	@Override
	public List<Booking> getAllBookings() {
		// TODO Auto-generated method stub
		return br.findAll();
	}

	@Override
	public List<Booking> getBookingsByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return br.findByStudentId(studentId);
	}

	@Override
	public Booking updateBooking(int bookingId, Booking updatedBooking) {
		Optional<Booking> existingBookingOpt = br.findById(bookingId);
		 System.out.println(existingBookingOpt);

	        if (existingBookingOpt.isPresent()) {
	            Booking existingBooking = existingBookingOpt.get();

	            existingBooking.setStudentId(updatedBooking.getStudentId());
	            existingBooking.setTeacherId(updatedBooking.getTeacherId());
	           
	            existingBooking.setTime(updatedBooking.getTime());
	            existingBooking.setDate(updatedBooking.getDate());
	            
	            
           

	            return br.save(existingBooking);
	        } else {
	            throw new RuntimeException("Booking with ID " + bookingId + " not found");
	        }
	}

	@Override
	public void deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		br.deleteById(bookingId);
	}

}

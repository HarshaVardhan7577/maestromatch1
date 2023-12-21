package com.stackroute.classservice.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stackroute.classservice.model.Booking;

@Service

public interface IBookingService {

	 Booking createBooking(Booking booking);

    Booking getBookingById(int bookingId);

    List<Booking> getAllBookings();

    List<Booking> getBookingsByStudentId(int studentId);
     
    Booking updateBooking(int bookingId, Booking updatedBooking);
    
    void deleteBooking(int bookingId);
}

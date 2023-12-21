package com.stackroute.classservice.Controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.stackroute.classservice.Service.SequenceGeneratorService;
import com.stackroute.classservice.model.TeacherProfile;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;


import com.stackroute.classservice.Service.BookingService;
import com.stackroute.classservice.model.Booking;

@RestController
@CrossOrigin
@RequestMapping("/bookings")
public class BookingController {

    private int studentId;

    @KafkaListener(topics ="booking", groupId = "booking-group")
    public void getStudentId(@RequestBody String item)throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());


        TeacherProfile product1 = objectMapper.readValue(item, TeacherProfile.class);

        this.studentId=product1.getUserId();

    }
	@Autowired
	BookingService bs;
	
	@Autowired
    SequenceGeneratorService service;
	
	
	@PostMapping("/newBooking")
    public  Booking createBooking(@RequestBody Booking booking) {
        booking.setBookingId(service.getSequenceNumber(Booking.SEQUENCE_NAME));
        booking.setStudentId(this.studentId);
        return bs.createBooking(booking);
    }
   @GetMapping("/{bookingId}")
     public Booking getBookingById(@PathVariable int bookingId) {
      return bs.getBookingById(bookingId);
}

    @GetMapping("/bookings")
       public List<Booking> getAllBookings() {
        return bs.getAllBookings();
    }
 
    @GetMapping("/student")
    public List<Booking> getBookingsByStudentId() {
        return bs.getBookingsByStudentId(this.studentId);
    }
    
    @PutMapping("/{bookingId}")
    public Booking updateBooking(@PathVariable int bookingId, @RequestBody Booking updatedBooking) {
        return bs.updateBooking(bookingId, updatedBooking);
    }
    
    @DeleteMapping("/{bookingId}")
    public void deleteBooking(@PathVariable int bookingId) {
        bs.deleteBooking(bookingId);
    }

}

import { Component, OnInit } from '@angular/core';
import { BookingHistoryService } from '../booking-history.service';
import { BookingService } from '../booking.service';
import { Router,ActivatedRoute } from '@angular/router';
import { Teacher } from '../booking/teacher';
import { AuthService } from '../auth.service';
import { Booking } from '../booking/booking';

@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrls: ['./booking-history.component.css']
})
export class BookingHistoryComponent implements OnInit {
  teacher:any[]=[];
  bookingHistoryData: any[] = [];
  studentId:number=0;
  

  constructor(private bookingHistoryService: BookingHistoryService, private bs:BookingService, private route:ActivatedRoute, private auth:AuthService) {}

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.studentId = params['id'];
    });

    for(const book of this.bookingHistoryData){
      this.auth.getTeacherById(book.teacherId).subscribe((data)=>{
        console.log(data);
        this.teacher.push(data);
    });
   
  }
    this.fetchBookingHistory();
    
  console.log(this.teacher);
}

  fetchBookingHistory(): void {
    this.bs.getBookingsbyStudentId(this.studentId).subscribe((data: any[]) => {
      const currentDateTime = new Date();
      this.bookingHistoryData = data.map(booking => {
        
        const bookingDateTime = new Date(booking.date + ' ' + booking.time);

        if (bookingDateTime < currentDateTime) {
          booking.status = 'Completed';
        } else {
          booking.status = 'Upcoming';
        }

        return booking;
      });
    }); 
  }
   


}

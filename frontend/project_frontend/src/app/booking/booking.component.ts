import { Component, ViewChild, TemplateRef } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { BookingService } from '../booking.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Teacher } from './teacher';
import { RestServiceService } from '../rest-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.css']
})
export class BookingComponent {
  teacher:Teacher=new Teacher;
  selectedDate: Date;
  selectedTime: string = '';
  timeOptions: string[] = [
    '8:00 AM',
    '09:00 AM',
    '10:00 AM',
    '11:00 AM',
    '12:00 PM',
    '2:00 PM',
    '3:00 PM',
    '4:00 PM',
    '5:00 PM'
    
    // Add more time options as needed
  ];
  @ViewChild('dialogTemplate', { static: false }) dialogTemplate!: TemplateRef<any>;
recommendationArray: any;

  

  constructor(private dialog: MatDialog, 
    private bookingService: BookingService, 
    private route: ActivatedRoute, 
    private rs:RestServiceService,
    private router:Router,
    private snackBar: MatSnackBar) {
    this.selectedDate = new Date(); // Initialize with the current date or any default date
    this.selectedTime = ''; // Initialize with an empty string or any default time
  }

  getTeacherDeatils(){

  }

  ngOnInit(){
    this.route.params.subscribe((params) => {
      this.teacher.userId= params['teacherId'];
    });
    console.log(this.teacher.userId);
    this.rs.getRecommendation(this.teacher.userId).subscribe(data =>{
      this.teacher=data;
    });
  }

  onSubmit() {
    // Open the dialog on form submission
    const newBooking = {date: this.selectedDate, time: this.selectedTime, teacherId:this.teacher.userId};

    this.bookingService.addBooking(newBooking).subscribe((response:any)=>{
      console.log(newBooking);
      // this.dialog.open(this.dialogTemplate);
      this.snackBar.open('Your Booking Successful', 'Dismiss', {
        duration: 3000, // Duration in milliseconds
      });
    })

    this.router.navigate(['studentdashboard'])
  }

}

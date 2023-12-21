import { Component, OnInit,Output } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { BookingService } from '../booking.service';
import { Teacher } from '../booking/teacher';
import { take } from 'rxjs/operators';

// async ngOnInit(): Promise<any> {
//   const data = await this.service.getData().pipe(take(1)).toPromise();
//   this.data = this.modifyMyData(data);
// }


@Component({
  selector: 'app-student-dash-board',
  templateUrl: './student-dash-board.component.html',
  styleUrls: ['./student-dash-board.component.css']
})
export class StudentDashBoardComponent implements OnInit {

constructor(private auth:AuthService,private route:Router, private bs:BookingService){}
student:any={}
bookings:any={}
@Output() teacher:any[]=[];

async ngOnInit(): Promise<any>{
    this.auth.getStudentById(localStorage.getItem('student')).subscribe((resp:any)=>{
     console.log(resp)
     this.student=resp
    })
    this.bookings= await this.bs.getBookingsbyStudentId(this.student.userId).pipe(take(1)).toPromise();
    console.log(this.bookings);
   
    // console.log(this.bookings);
    for (let book in this.bookings) {
      this.auth.getTeacherById(this.bookings[book].teacherId).subscribe((data)=>{
        this.teacher.push(data);
      })
      console.log(this.teacher);
      
  }
}
  review(){
    this.route.navigate(['review']);
  }

  booking(id:number){
    this.route.navigate(['booking-history',id]);
  }
  
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { CourseService } from '../course.service';

@Component({
  selector: 'app-teacher-dash-board',
  templateUrl: './teacher-dash-board.component.html',
  styleUrls: ['./teacher-dash-board.component.css']
})
export class TeacherDashBoardComponent implements OnInit {
  user: any={}
  constructor(private auth: AuthService,private route:Router) { }
  ngOnInit() {
    this.auth.getTeacherById(localStorage.getItem('user')).subscribe((resp: any) => {
      this.user=resp
      console.log(this.user)
    })
  }

  teacherDashboard(){
this.route.navigate(['teacherdashboard'])
  }
}

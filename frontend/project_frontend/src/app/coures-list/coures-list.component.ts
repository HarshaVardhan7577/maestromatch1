import { Component, ViewChild, TemplateRef, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CourseService } from '../course.service';
import { Course } from '../course';
import { Router } from '@angular/router';


@Component({
  selector: 'app-coures-list',
  templateUrl: './coures-list.component.html',
  styleUrls: ['./coures-list.component.css']
})
export class CouresListComponent implements OnInit {


  courses: Course[] = [];
  // teacherId: number=1;
  showPopup = false;
  @ViewChild('dialogTemplate', { static: false }) dialogTemplate!: TemplateRef<any>;
  constructor(private dialog: MatDialog, private courseService: CourseService, private route: Router) {

  }
  
  ngOnInit(): void {
    this.courseService.getCoursesByTeacherId().subscribe((data:any) => {
      this.courses = data;
    });
  }
  
  
  redirectToDetails(courseId:number){
     
      // console.log(this.courses.at()?.courseId);

    this.route.navigate(['course-details',courseId]);
  }







}

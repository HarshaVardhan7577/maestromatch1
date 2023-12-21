import { Component, ViewChild, TemplateRef, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { CourseService } from '../course.service';
import { Course } from '../course';
import { Router,ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-coures-list',
  templateUrl: './coures-list.component.html',
  styleUrls: ['./coures-list.component.css']
})
export class CouresListComponent implements OnInit {


  courses: Course[] = [];
 teacherId: number=0;
  showPopup = false;
  @ViewChild('dialogTemplate', { static: false }) dialogTemplate!: TemplateRef<any>;
  constructor(private dialog: MatDialog, private courseService: CourseService, private router: Router, private route:ActivatedRoute) {

  }
  
  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.teacherId= params['teacherId'];
    });
    this.courseService.getCoursesByTeacherId().subscribe((data:any) => {
      console.log(data);
      this.courses = data;
    });
    console.log(this.teacherId);
    this.courseService.getCourseByTeacher(this.teacherId).subscribe((data:any)=>{
      console.log(data);
      this.courses=data;
    });
  }
  
  
  redirectToDetails(courseId:number){
     
      // console.log(this.courses.at()?.courseId);

    this.router.navigate(['course-details',courseId]);
  }







}

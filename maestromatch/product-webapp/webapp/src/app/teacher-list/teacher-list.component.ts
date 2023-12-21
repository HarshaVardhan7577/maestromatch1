import { Component,Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teacher-list',
  templateUrl: './teacher-list.component.html',
  styleUrls: ['./teacher-list.component.css']
})
export class TeacherListComponent implements OnInit {

  @Input() teacher:any[]=[];
  
constructor (private router:Router){
  
}
ngOnInit(){
  console.log(this.teacher);
}
onRate(id:number){
  this.router.navigate(['review',id]);
}
redirectToCourseList(teacherId:number){
    this.router.navigate(['course-list',teacherId]);
}




}

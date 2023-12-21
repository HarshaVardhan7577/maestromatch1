import { Component, ViewChild, TemplateRef, OnInit, Input } from '@angular/core';
import { CourseService } from '../course.service';
import { Course } from '../course';
import { ReferenceMaterial } from '../reference-material';
import { RefMatService } from '../ref-mat.service';
import { ActivatedRoute,Router } from '@angular/router';
import { MatDialog } from '@angular/material/dialog';
import {  FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DomSanitizer, SafeResourceUrl } from '@angular/platform-browser';
import { MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-course-details',
  templateUrl: './course-details.component.html',
  styleUrls: ['./course-details.component.css']
})
export class CourseDetailsComponent implements OnInit{

 @Input() declare courseId:number;

  course:Course={
    courseId:0,
    teacherId:0,
    courseName:'',
    instrument:'',
    courseDesc:'',
    videoUrl:''
  };
  refMatList: ReferenceMaterial[] = [];

  refMat:ReferenceMaterial={
    id:0,
    courseId:0,
    title:'',
    content:'',
    reflinks:''
  }

  editForm: FormGroup;
  embedVideoUrl: SafeResourceUrl = ''; 

  constructor(private courseService:CourseService,
    private refMatService:RefMatService,
    private route:ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder, 
    private snackBar: MatSnackBar,
    private dialog: MatDialog,
    private sanitizer: DomSanitizer,
    // private dialogRef: MatDialogRef<>
    ){
      this.editForm = this.formBuilder.group({
        courseName: ['', Validators.required],
        instrument: ['', Validators.required],
        courseDesc: [''],
        videoUrl: ['']
      });

    }

  @ViewChild('dialogTemplate', { static: false }) dialogTemplate!: TemplateRef<any>;
  @ViewChild('deleteDialog', { static: false }) deleteDialog!: TemplateRef<any>;
  @ViewChild('editDialog', { static: false }) editDialog!: TemplateRef<any>;
  @ViewChild('deleteDialogRef', { static: false }) deleteDialogRef!: TemplateRef<any>;


  ngOnInit():void{
    this.route.params.subscribe((params) => {
      this.courseId = params['courseId'];
    });
   
    this.courseService.getCourseById(this.courseId).subscribe(data => {
      this.course=data;
      this.embedVideoUrl = this.sanitizer.bypassSecurityTrustResourceUrl(this.course.videoUrl);
    });

    this.refMatService.getReferenceMaterialsByCourseId(this.courseId).subscribe(data =>{
      this.refMatList=data;
     console.log(data);
    });
    // console.log(this.courseId);

  }
  
  onEdit(courseId:number){
    
    const dialogRef = this.dialog.open(this.editDialog,{
      data:{
        course:this.course,
      }
    });
    console.log(this.course);
    
  }

  editCourse(courseId:number,formData: any) {
    
    console.log(formData);
  this.courseService.updateCourse(courseId, formData).subscribe(data => {
    this.course = data;
  });

  // this.dialogRef.close(this.editDialog);
  this.snackBar.open('Course Updated successfully', 'Dismiss', {
    duration: 3000,
  });

  }
 
  onDelete(){
    const dialogRef = this.dialog.open(this.deleteDialog);
  }
  deleteCourse(){
    this.courseService.deleteCourse(this.courseId).subscribe(()=>{
      this.router.navigate(['teacherdashboard']);
    });
    this.snackBar.open('Course '+this.course.courseName+' Deleted Successfully', 'Dismiss', {
      duration: 3000,
    });
  }

  openRefMatForm(){
    const dialogRef = this.dialog.open(this.dialogTemplate);
      
  }



  onDeleteRef(id:number){
   
    const dialogRef = this.dialog.open(this.deleteDialogRef,
      {
        data: { id }, // Pass the referenceId to the dialog
      });

      dialogRef.afterClosed().subscribe((result) => {
        if (result === true) {
          // Implement your delete logic here
          console.log(id);
          this.refMatService.deleteReferenceMaterial(id).subscribe(
            () => {
              // Handle successful deletion here (e.g., show a message)
              console.log('Reference material deleted successfully');
            },
            (error) => {
              // Handle the error (e.g., display an error message)
              console.error('Error deleting reference material:', error);
            }
          );
          console.log('Deleted reference with ID:', id);
          window.location.reload();
        }
      });
      

      this.router.navigate(['course-details',`${this.courseId}`]);
  }
  
  

 

}

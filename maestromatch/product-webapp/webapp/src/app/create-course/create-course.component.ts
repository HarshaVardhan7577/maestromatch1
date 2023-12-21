import { Component, OnInit } from '@angular/core';
import { FormBuilder,FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { CourseService } from '../course.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.css']
})
export class CreateCourseComponent implements OnInit{

  //  teacherId: number= 1;

  courseForm = new FormGroup({
    courseName: new FormControl(''),
    instrument: new FormControl(''),
    videoUrl: new FormControl(''),
    courseDesc: new FormControl('')
  })

  constructor(private formBuilder: FormBuilder, private snackBar: MatSnackBar, private courseService: CourseService, private route:Router) { }

  ngOnInit() {
    // Initialize the form with default values and validation rules
    this.courseForm.controls["courseName"].setValidators([Validators.required]);
    this.courseForm.controls["instrument"].setValidators([Validators.required]);

    // //getting teacherId from other service

    // this.teacherService.getTeacherId().subscribe(
    //   (teacherId) => {
    //     this.teacherId = teacherId;

    //     // You can also fetch other initial data or perform other setup here
    //   },
    //   (error) => {
    //     console.error('Error fetching teacher ID:', error);
    //    }
    //    );
    
  }

  
  // Define a function to handle form submission
  onSubmit() {
    // console.log(this.teacherId);
    if (this.courseForm.valid) {
      const formData = this.courseForm.value;
      console.log(formData);
      // console.log(this.teacherId)
      this.courseService.addCourse(formData).subscribe(
        (response:any) => {
          console.log('Course created successfully:', response);},
          
          (error:any) => {
            console.error('Error creating course:', error);
          }
          
        );
        
        this.courseForm.reset();
      this.snackBar.open('Added Course Successfully', 'Dismiss', {
        duration: 3000, // Duration in milliseconds
      });

      this.route.navigate(['teacherdashboard']);
      
    }
    
     else {
      // Handle form validation errors
      alert('Please fill out all required fields.');
    }
  }
}

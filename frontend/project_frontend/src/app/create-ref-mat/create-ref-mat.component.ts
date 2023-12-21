import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { FormBuilder,FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatDialogRef } from '@angular/material/dialog';
import { RefMatService } from '../ref-mat.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-create-ref-mat',
  templateUrl: './create-ref-mat.component.html',
  styleUrls: ['./create-ref-mat.component.css']
})
export class CreateRefMatComponent implements OnInit{
@Input() declare courseId:number;



form: FormGroup;
constructor(private formBuilder: FormBuilder, 
  private snackBar: MatSnackBar,
  private dialogRef: MatDialogRef<CreateRefMatComponent>,
  private route:ActivatedRoute,
  private router: Router,
  private refMatService: RefMatService,
  ) {

    
  // Initializing the form with form controls
  this.form = this.formBuilder.group({
    title: ['', Validators.required],
    content: ['', Validators.required],
    reflinks: [''],
  });

}

ngOnInit(){
  console.log(this.courseId);
}

saveForm(){
  
  if (this.form.valid) {
    // Creating an object from the form data
    const formData = this.form.value;
    console.log('Form data:', formData);
    
   
    this.refMatService.addReferenceMaterial(this.courseId,formData).subscribe(
      (response) => {
        
        
        this.router.navigate(['course-details',`${this.courseId}`]);
        
        
        console.log('Form data:', formData);
        console.log('Form data sent successfully:', response);

        this.form.reset();
        window.location.reload();
        this.snackBar.open('Reference materials added successfully', 'Dismiss', {
        duration: 3000, // Duration in milliseconds
        
    });
      },
      (error) => {
        console.error('Error sending form data:', error);
        // Handle errors from the API request
      }
      );
    


    this.dialogRef.close();  

    }
}

}

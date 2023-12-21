import { Component, NgZone,Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { Teachermodel } from '../teachermodel';
import { TeacherService } from '../teacher.service';
import { FormBuilder,FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-teacher-edit-dialog',
  templateUrl: './teacher-edit-dialog.component.html',
  styleUrls: ['./teacher-edit-dialog.component.css']
})
export class TeacherEditDialogComponent {
  editedReview: any = {}; // Property to hold the edited review
  
  constructor(
    private zone: NgZone,
    public dialogRef: MatDialogRef<TeacherEditDialogComponent>,
    private ts: TeacherService,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
   
    this.editedReview = { ...data.review };
  }

  saveEditedReview(): void {
    this.dialogRef.close(this.editedReview);
    
    this.ts.updateTReview(this.editedReview.id, this.editedReview).subscribe(
      (response) => {
        console.log('Review updated successfully:', response);
        // Refresh the review list or perform other actions
        this.refreshReviews();
        
      },
      (error) => {
        console.error('Error updating review:', error);
      }
    );
  }

  // Function to cancel the edit and close the dialog
  cancelEdit(): void {
    this.dialogRef.close();
  }


  refreshReviews(): void {
    const URL = this.editedReview

    this.ts.getTReviews().subscribe(
      (data) => {
        console.log('Data received from the server:', data);
        this.zone.run(() => {
          this.data.reviewArray = data;
        });
      },
      (error) => {
        console.error('Error fetching reviews:', error);
      }
    );
  }
}

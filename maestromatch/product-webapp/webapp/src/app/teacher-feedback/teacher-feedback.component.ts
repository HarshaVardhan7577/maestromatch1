import { Component, NgZone } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { TeacherEditDialogComponent } from './teacher-edit-dialog/teacher-edit-dialog.component';
import { Teachermodel } from './teachermodel';
import { TeacherService } from './teacher.service';
import { FormBuilder,FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-teacher-feedback',
  templateUrl: './teacher-feedback.component.html',
  styleUrls: ['./teacher-feedback.component.css']
})
export class TeacherFeedbackComponent {
  reviewTForm=new FormGroup({
    feedback: new FormControl(''),
  })

  constructor(private zone: NgZone, private ts: TeacherService, private dialog: MatDialog, private formBuilder: FormBuilder) {}

  t: Teachermodel = new Teachermodel();
  feedbackText: string = '';
  reviewArray: Array<any> = [];
  numbers: number[] = [1, 2, 3, 5, 4, 6, 7];

  ngOnInit(): void {
    this.reviewTForm.controls["feedback"].setValidators([Validators.required]);
    this.fetchReviews();

  }
  fetchReviews(): void {
    this.ts.getTReviews().subscribe((data) => {
      this.zone.run(() => {
        this.reviewArray = data;
      });
    });
  }


  submitFeedback(): void {
    if (this.reviewTForm.valid) {
      const feedback = this.reviewTForm.get('feedback')?.value;
      const review = {
        feedback: feedback,
      };
      this.ts.postTReview(this.t).subscribe(
        (Response) => {
          console.log('Review created successfully.');
          this.fetchReviews();
          this.reviewTForm.reset();
        },
        (error) => {
          console.error('Error creating review:', error);
        }
      );
    } else {
      alert('Please provide feedback before submitting.');
    }
  }

  editTReview(review: any): void {
    const dialogRef = this.dialog.open(TeacherEditDialogComponent, {
      data: {
        review: { ...review },
      }
    });

    dialogRef.afterClosed().subscribe((editedTReview: any) => {
      if (editedTReview) {
        this.ts.updateTReview(review.id, editedTReview).subscribe(
          () => {
            console.log('Review updated successfully.');
            this.fetchReviews();
          },
          (error) => {
            console.error('Error updating review:', error);
          }
        );
      }
    });
  }

  deleteTReview(reviewId: number): void {
    // Call your API to delete the review by ID
    this.ts.deleteTReview(reviewId).subscribe(
      () => {
        console.log('Review deleted successfully.');
        // Refresh the review list or perform other actions
        this.fetchReviews();
      },
      (error) => {
        console.error('Error deleting review:', error);
      }
    );
  }

  
}
import { Component, Inject } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-review-edit-dialog',
  templateUrl: './review-edit-dialog.component.html',
  styleUrls: ['./review-edit-dialog.component.css']
})
export class ReviewEditDialogComponent {
  editedReview: any; // Property to hold the edited review
  stars: number[]; // Property to hold the stars
  hoverRating: number; // Property to hold hoverRating
  selectedRating: number; // Property to hold selectedRating

  constructor(
    public dialogRef: MatDialogRef<ReviewEditDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    // Initialize the properties from the data passed to the dialog
    this.editedReview = { ...data.review };
    this.stars = data.stars;
    this.hoverRating = data.hoverRating;
    this.selectedRating = data.selectedRating;
  }

  // Function to save the edited review and close the dialog
  saveEditedReview(): void {
    this.dialogRef.close(this.editedReview);
  }

  // Function to cancel the edit and close the dialog
  cancelEdit(): void {
    this.dialogRef.close();
  }

  // Function to submit the rating
  submitRating(rating: number): void {
    this.selectedRating = rating;
    this.editedReview.rating = this.selectedRating;
  }
}
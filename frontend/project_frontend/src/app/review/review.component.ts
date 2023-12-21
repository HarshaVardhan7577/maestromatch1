import { Component, NgZone } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ReviewEditDialogComponent } from './review-edit-dialog/review-edit-dialog.component'; // Import the dialog component
import { Reviewmodel } from './reviewmodel';
import { RestService } from './rest.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-review',
  templateUrl: './review.component.html',
  styleUrls: ['./review.component.css']
})
export class ReviewComponent {
  constructor(private zone: NgZone, private rs: RestService, private dialog: MatDialog ,private router:Router,private route: ActivatedRoute) {}

  r: Reviewmodel = new Reviewmodel();
  reviewArray: Array<any> = [];
  numbers: number[] = [1, 2, 3, 5, 4, 6, 7];

  stars: number[] = [1, 2, 3, 4, 5]; // Number of rating stars
  selectedRating: number = 0;
  hoverRating: number = 0;
  feedbackText: string = '';

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.r.teacherId= params['id'];
    });
    this.rs.getReviewById(this.r.teacherId).subscribe((data) => {
      this.zone.run(() => {
        this.reviewArray = data;
      });
    });
  }

  submitRating(rating: number): void {
    this.selectedRating = rating;
    this.r.rating = this.selectedRating;
  }

  submitFeedback(): void {
    // Here, you can handle the submission of feedback and rating.
    // Access the feedback text from the component property.
    console.log('Selected Rating:', this.selectedRating);
    console.log('Feedback Text:', this.feedbackText);
    this.rs.postReview(this.r).subscribe(
      (Response) => {
        console.log('Review created successfully.');
        // Refresh the review list or perform other actions
        this.refreshReviews();
      },
      (error) => {
        console.error('Error creating review:', error);
      }
    );
    this.router.navigate(['studentdashboard']);
  }

   // Function to open a dialog for editing a review
  editReview(review: any): void {
    // Pass the "stars" property and rating-related properties to the dialog
    const dialogRef = this.dialog.open(ReviewEditDialogComponent, {
      data: {
        review: { ...review },
        stars: this.stars, // Pass the stars property
        hoverRating: this.hoverRating, // Pass hoverRating
        selectedRating: this.selectedRating // Pass selectedRating
      }
    });

    dialogRef.afterClosed().subscribe((editedReview: any) => {
      // Handle the result after editing
      if (editedReview) {
        // Call your API to update the review with the edited data
        this.rs.updateReview(review.id, editedReview).subscribe(
          () => {
            console.log('Review updated successfully.');
            // Refresh the review list or perform other actions
            this.refreshReviews();
          },
          (error) => {
            console.error('Error updating review:', error);
          }
        );
      }
    });
  }

  // Function to delete a review by ID
  deleteReview(reviewId: number): void {
    // Call your API to delete the review by ID
    this.rs.deleteReview(reviewId).subscribe(
      () => {
        console.log('Review deleted successfully.');
        // Refresh the review list or perform other actions
        this.refreshReviews();
      },
      (error) => {
        console.error('Error deleting review:', error);
      }
    );
  }

  // Function to refresh the review list (you may need to fetch reviews again)
  refreshReviews(): void {
    this.rs.getReviewById(this.r.teacherId).subscribe((data) => {
      this.zone.run(() => {
        this.reviewArray = data;
      });
    });
  }
}
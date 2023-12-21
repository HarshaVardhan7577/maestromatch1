import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { NavbarComponent } from './navbar/navbar.component';


import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';
import { ProgramsComponent } from './programs/programs.component';
import { RegistrationComponent } from './registration/registration.component';

import { ReactiveFormsModule } from '@angular/forms';
import { MatCardModule } from '@angular/material/card';


import { TeachersComponent } from './teachers/teachers.component';

import { MatDialogModule } from '@angular/material/dialog';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatMenuModule } from '@angular/material/menu';


import { MatExpansionModule } from '@angular/material/expansion';
import { RegistrationAsTeacherComponent } from './registration-as-teacher/registration-as-teacher.component';
import { LoginAsStudentComponent } from './login-as-student/login-as-student.component';
import { LoginAsTeacherComponent } from './login-as-teacher/login-as-teacher.component';
import { HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';
import {MatPaginatorModule} from '@angular/material/paginator';
import { MatGridListModule } from '@angular/material/grid-list';
import {MatProgressBarModule} from '@angular/material/progress-bar';
import {MatSidenavModule} from '@angular/material/sidenav';
import { MatListModule } from '@angular/material/list';
import { StudentDashBoardComponent } from './student-dash-board/student-dash-board.component';
import { TeacherDashBoardComponent } from './teacher-dash-board/teacher-dash-board.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { CreateCourseComponent } from './create-course/create-course.component';
import { CouresListComponent } from './coures-list/coures-list.component';
import { CreateRefMatComponent } from './create-ref-mat/create-ref-mat.component';
import { ChatBotComponent } from './chat-bot/chat-bot.component';
import { ReviewComponent } from './review/review.component';
import { ChatboatIconComponent } from './chatboat-icon/chatboat-icon.component';
import { BookingComponent } from './booking/booking.component'
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import { ReviewEditDialogComponent } from './review/review-edit-dialog/review-edit-dialog.component';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { TeacherFeedbackComponent } from './teacher-feedback/teacher-feedback.component';
import { TeacherEditDialogComponent } from './teacher-feedback/teacher-edit-dialog/teacher-edit-dialog.component';

import { BookingHistoryComponent } from './booking-history/booking-history.component';
import { TeacherListComponent } from './teacher-list/teacher-list.component';





@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    ProgramsComponent,
    RegistrationComponent,
    TeachersComponent,

    RegistrationAsTeacherComponent,
    LoginAsStudentComponent,
    LoginAsTeacherComponent,
    StudentDashBoardComponent,
    TeacherDashBoardComponent,
    NotfoundComponent,
    CreateCourseComponent,
    CouresListComponent,
    CreateRefMatComponent,
    ChatBotComponent,
    ReviewComponent,
    ChatboatIconComponent,
    BookingComponent,
    ReviewEditDialogComponent,
    CourseDetailsComponent,
    TeacherFeedbackComponent,
    TeacherEditDialogComponent,

    BookingHistoryComponent,
      TeacherListComponent,


  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    MatCardModule,
    MatInputModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatSelectModule,
    MatExpansionModule,
    MatSidenavModule,
    MatDialogModule,
    MatIconModule,
    MatGridListModule,
    MatListModule,
    FormsModule,
    MatCheckboxModule,
    HttpClientModule,
    MatMenuModule,
    MatProgressBarModule,
    MatPaginatorModule,
    MatDatepickerModule ,
    MatNativeDateModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

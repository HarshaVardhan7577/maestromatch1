import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CouresListComponent } from './coures-list/coures-list.component';
import { CreateCourseComponent } from './create-course/create-course.component';
import { HomeComponent } from './home/home.component';
import { LoginAsStudentComponent } from './login-as-student/login-as-student.component';
import { LoginAsTeacherComponent } from './login-as-teacher/login-as-teacher.component';
import { NotfoundComponent } from './notfound/notfound.component';
import { ProgramsComponent } from './programs/programs.component';
import { BookingComponent } from './booking/booking.component';

import { RegistrationAsTeacherComponent } from './registration-as-teacher/registration-as-teacher.component';
import { RegistrationComponent } from './registration/registration.component';
import { StudentDashBoardComponent } from './student-dash-board/student-dash-board.component';
import { TeacherDashBoardComponent } from './teacher-dash-board/teacher-dash-board.component';
import { TeachersComponent } from './teachers/teachers.component';
import { ReviewComponent } from './review/review.component';
import { ChatBotComponent } from './chat-bot/chat-bot.component';
import { CourseDetailsComponent } from './course-details/course-details.component';
import { TeacherFeedbackComponent } from './teacher-feedback/teacher-feedback.component';
import { BookingHistoryComponent } from './booking-history/booking-history.component';


const routes: Routes = [
  { path: 'teacher', component: ProgramsComponent },
  { path: "", component: HomeComponent },
  { path: 'registrationStdeunt', component: RegistrationComponent },
  { path: 'registrationTeacher', component: RegistrationAsTeacherComponent },
  { path: 'progrmas', component: TeachersComponent },
  { path: 'loginAsStudent', component: LoginAsStudentComponent },
  { path: 'loginAsTeacher', component: LoginAsTeacherComponent },
  { path: 'studentdashboard', component: StudentDashBoardComponent },
  { path: 'review/:id', component: ReviewComponent },
  { path: 'chatBot', component: ChatBotComponent},
  { path: 'booking/:teacherId', component: BookingComponent},
  { path: 'course-details/:courseId',component:CourseDetailsComponent},
  {path: 'teacher-feedback', component:TeacherFeedbackComponent},
  {path:'booking-history', component:BookingHistoryComponent},
  
  {
    path: 'teacherdashboard', component: TeacherDashBoardComponent, children: [{
      path: 'createCourse', component: CreateCourseComponent
    },{
      path: "", component: CouresListComponent,
      
    }]
  },
  { path: '**', component: NotfoundComponent }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login-as-teacher',
  templateUrl: './login-as-teacher.component.html',
  styleUrls: ['./login-as-teacher.component.css']
})
export class LoginAsTeacherComponent {
  profileForm: FormGroup

  constructor(private router: Router, private formBuilder: FormBuilder, private authService: AuthService) {
    this.profileForm = this.formBuilder.group({
      mailId: ['', Validators.required],
      password: ['', Validators.required],
    })
  }

  loginUser(profileForm: FormGroup) {
    console.log(profileForm.value)
    this.authService.loginTeacher(profileForm.value).subscribe((resp: any) => {
      console.log(resp['user'].userId);
      if (resp['token']) {
        localStorage.setItem('bearerToken', resp['token'])
        localStorage.setItem('who', "Teacher")
        localStorage.setItem('user', resp['user'].userId);
        this.router.navigate(['teacherdashboard'])
        this.authService.setIsLoggedIn(true)
      } else {
        console.log("Error");
      }
    }, (err: any) => {
      alert('Invalid Credentails')

    })
  }

  teacherRegistration() {
    this.router.navigate(['registrationTeacher'])
  }
}

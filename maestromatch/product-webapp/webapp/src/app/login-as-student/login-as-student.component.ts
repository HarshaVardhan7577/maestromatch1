import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-login-as-student',
  templateUrl: './login-as-student.component.html',
  styleUrls: ['./login-as-student.component.css']
})
export class LoginAsStudentComponent {


  profileForm: FormGroup

  constructor(private router: Router, private formBuilder: FormBuilder, private authService: AuthService) {
    this.profileForm = this.formBuilder.group({
      mailId: ['', Validators.required],
      password: ['', Validators.required],
    })
  }

  loginUser(profileForm: FormGroup) {
    this.authService.loginStudent(profileForm.value).subscribe((resp: any) => {
      console.log(resp['user'].userId);
      if (resp['token']) {
        localStorage.setItem('bearerToken', resp['token'])
        localStorage.setItem('who', "Student")
        localStorage.setItem('student', resp['user'].userId);
        
        this.authService.setIsLoggedIn(true)
        this.router.navigate(['progrmas'])
      } else {
        console.log("Error");
      }
    }, (err: any) => {
      alert('Invalid Credentails')

    })

  }


  resgitration() {
    this.router.navigate(['registrationStdeunt'])
  }
}

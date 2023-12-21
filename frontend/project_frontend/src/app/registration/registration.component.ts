import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

  profileForm: FormGroup

  constructor(private router: Router, private formBuilder: FormBuilder, private authService: AuthService) {
    this.profileForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      mailId: ['', Validators.required],
      password: ['', Validators.required],
      cpassword: ['', Validators.required],
    })
  }


  loginUser(profileForm: FormGroup) {
    console.log(profileForm.value);
    this.authService.createStudent(profileForm.value).subscribe((resp: any) => {
      console.log(resp)
      this.router.navigate(["loginAsStudent"])
    }, (err: any) => {
      alert('Invalid Credentails')
    })
  }


  loginStudent() {
    this.router.navigate(['loginAsStudent'])
  }


}

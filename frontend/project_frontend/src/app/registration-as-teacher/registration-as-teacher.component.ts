import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
const ins = [
  "Violin",
  "Viola",
  "Cello",
  "Double Bass",
  "Guitar (Acoustic and Electric)",
  "Bass Guitar",
  "Banjo",
  "Mandolin",
  "Harp",
  "Ukulele",
  "Sitar",
  "Oud",
  "Balalaika",
  "Erhu",
  "Koto",
  "Trombone",
  "French Horn",
  "Tuba",
  "Cornet",
  "Bugle",
  "Euphonium",
  "Clarinet",
  "Saxophone",
  "Oboe",
  "Bassoon",
  "Piccolo",
  "Recorder",
  "English Horn",
  "Bagpipes",
  "Pan Flute"
];
@Component({
  selector: 'app-registration-as-teacher',
  templateUrl: './registration-as-teacher.component.html',
  styleUrls: ['./registration-as-teacher.component.css']
})
export class RegistrationAsTeacherComponent {
  instruments: string[] = ins

  profileForm: FormGroup

  constructor(private router: Router, private formBuilder: FormBuilder, private authService: AuthService) {
    this.profileForm = this.formBuilder.group({
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      userName:['',Validators.required],
      mailId: ['', Validators.required],
      password: ['', Validators.required],
      cpassword: ['', Validators.required],
      instrument: ['', Validators.required],
      location:['',Validators.required],
      experience: ['', Validators.required],
      description: ['', Validators.required],
    })
  }
  loginUser(profileForm: FormGroup) {
    console.log(profileForm.value);
    this.authService.createTeacher(profileForm.value).subscribe((resp: any) => {
      console.log(resp)
      this.router.navigate(["loginAsTeacher"])
    }, (err: any) => {
      alert('Invalid Credentails')
    })
  }



  redirect_to_login(){
    this.router.navigate(['loginAsTeacher'])
  }
}

import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  constructor(private auth: AuthService, private router: Router) { }

  IsLoggedIN = false
  Who: any

  ngOnInit() {
    this.auth.getIsLoggedIn().subscribe((status: boolean) => {
      this.IsLoggedIN = status
      this.Who = localStorage.getItem('who');
    })
    if (localStorage.getItem("bearerToken")) {
      this.IsLoggedIN = true;
      this.Who = localStorage.getItem('who');
    }
 
    console.log(this.Who)
  }

  logout() {
    this.IsLoggedIN = false
    this.auth.setIsLoggedIn(false);
    localStorage.removeItem('bearerToken')
    localStorage.removeItem('who')
    this.router.navigate([""])
  }

}

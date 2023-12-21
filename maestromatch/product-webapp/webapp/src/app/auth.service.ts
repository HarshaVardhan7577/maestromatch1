import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';
// import {  } from 'rxjs/dist/types/internal/Subject';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  private isLoggedIn = new Subject<boolean>();
  private id = new Subject<number>();

  setIsLoggedIn(status: boolean) {
    this.isLoggedIn.next(status);
  }

  getIsLoggedIn() {
    return this.isLoggedIn.asObservable();
  }

  setId(id: number) {
    return this.id.next(id)
  }
  getId() {
    return this.id.asObservable();
  }

  public createStudent(data: any) {
    return this.http.post("http://localhost:7070/auth/user/register", data);
  }
  public createTeacher(data: any) {
    return this.http.post("http://localhost:7070/auth/teacher/register", data);
  }

  public loginStudent(data: any) {
    return this.http.post('http://localhost:7070/auth/user/login', data);
  }

  public loginTeacher(data: any) {
    return this.http.post("http://localhost:7070/auth/teacher/login", data);
  }

  public getTeacherById(id: any) {
    return this.http.get(`http://localhost:7070/auth/teacher/${id}`);
  }

  public getStudentById(id: any) {
    return this.http.get(`http://localhost:7070/auth/user/${id}`);
  }

}

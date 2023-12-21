import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Teachermodel } from './teachermodel';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  private baseUrl = 'http://localhost:8080'; // Your base API URL

  constructor(private http: HttpClient) {}


  public getTReviews(): Observable<any> {
    const url = 'http://localhost:8080/review/teacher/All';
    return this.http.get<any>(url);
  }

  public postTReview(tm: Teachermodel): Observable<any> {
    const url = 'http://localhost:8080/review/teacher/savereview';
    return this.http.post(url, tm);
  }

  public updateTReview(id: Number, tm: Teachermodel): Observable<any> {
    const url = `http://localhost:8080/review/teacher/update/${id}`;
    return this.http.put<any>(url, tm);
  }

  public getTReviewById(id: Number): Observable<any> {
    const url = `http://localhost:8080/review/teacher/${id}`;
    return this.http.get<any>(url);
  }

  public deleteTReview(id: Number): Observable<any> {
    const url = `http://localhost:8080/review/teacher/delete/${id}`;
    return this.http.delete(url);
  }
}

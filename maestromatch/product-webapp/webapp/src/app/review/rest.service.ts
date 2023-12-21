import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Reviewmodel } from './reviewmodel';
import { Teachermodel } from './teachermodel';

@Injectable({
  providedIn: 'root'
})
export class RestService {

    constructor(private http: HttpClient) { }

  public getReviews():Observable<any>{
    const url='http://localhost:7070/review/student/All';
    return this.http.get<any>(url);
  }
  public postReview(rm: Reviewmodel){
    const url='http://localhost:7070/review/student/savereview';
    return this.http.post(url,rm);
  }

  public updateReview(id:Number,rm: Reviewmodel): Observable<any> {
    return this.http.put<any>('http://localhost:7070/review/student/update/{id}',rm);
  }

  public getReviewById(id:Number): Observable<any> {
    return this.http.get<any>(`http://localhost:7070/review/student/${id}`);
  }

  public deleteReview(id:Number): Observable<any>{
    return this.http.delete(`http://localhost:7070/review/student/delete/${id}`);
    
  }

  public getTReviews():Observable<any>{
    const url='http://localhost:7070/review/teacher/All';
    return this.http.get<any>(url);
  }
  public postTReview(rm: Reviewmodel){
    const url='http://localhost:7070/review/teacher/savereview';
    return this.http.post(url,rm);
  }

  public updateTReview(id:Number,tm: Teachermodel): Observable<any> {
    return this.http.put<any>('http://localhost:7070/review/teacher/update/{id}',tm);
  }

  public getTReviewById(id:Number): Observable<any> {
    return this.http.get<any>(`http://localhost:7070/review/teacher/${id}`);
  }

   public deleteTReview(id:Number): Observable<any>{
    return this.http.delete(`http://localhost:7070/review/teacher/delete/${id}`);
    
  }
}
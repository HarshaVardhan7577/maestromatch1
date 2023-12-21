// course.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface Course {
  courseId: number;
  teacherId: number;
  courseName: string;
  instrument: string;
  videoUrl: string;
  courseDesc: string;
  
}

@Injectable({
  providedIn: 'root'
})

export class CourseService {
  private baseUrl = 'http://localhost:7070/content/courses';

  constructor(private http: HttpClient) { }

  // Get a course by ID
  getCourseById(id: number): Observable<Course> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.get<Course>(url);
  }

  // Get courses by teacher ID
  getCoursesByTeacherId(): Observable<Course[]> {
    const url = `${this.baseUrl}/teacher`;
    return this.http.get<Course[]>(url);
  }


  getCourseByTeacher(id:number): Observable<Course[]>{
    const url = `${this.baseUrl}/teacher/${id}`;
    return this.http.get<Course[]>(url);
  }


  // Add a course with a teacher ID parameter
  addCourse( courseData: any): Observable<Course> {
    const url = `${this.baseUrl}/add`;
    return this.http.post<Course>(url, courseData);
  }

  // Update a course by ID
  updateCourse(id: number, courseData: any): Observable<Course> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.put<Course>(url, courseData);
  }

  // Delete a course by ID
  deleteCourse(id: number): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}

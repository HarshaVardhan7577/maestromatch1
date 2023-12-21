// reference-material.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs';
interface ReferenceMaterial{
  id : number;
  courseId : number;
  title:string;
  content: string;
  reflinks: string;
}

@Injectable({
  providedIn: 'root'
})
export class RefMatService {
  private baseUrl = 'http://localhost:7070/content/reference-materials';

  constructor(private http: HttpClient) { }

  addReferenceMaterial(courseId: number, referenceMaterialData: any): Observable<ReferenceMaterial> {
    const url = `${this.baseUrl}/course/${courseId}`;
    return this.http.post<ReferenceMaterial>(url, referenceMaterialData);
  }

  getReferenceMaterialsByCourseId(courseId: number): Observable<ReferenceMaterial[]> {
    const url = `${this.baseUrl}/course/${courseId}`;
    return this.http.get<ReferenceMaterial[]>(url);
  }

  updateReferenceMaterial(id: number, referenceMaterialData: any): Observable<ReferenceMaterial> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.put<ReferenceMaterial>(url, referenceMaterialData);
  }

  deleteReferenceMaterial(id: number): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url).pipe(
      catchError((error: any) => {
        // Handle the error here (e.g., log it or throw a custom error)
        console.error('An error occurred:', error);
        // You can choose to re-throw the error or return a default value here
        return throwError('Unable to delete reference material');
      })
    );
  }
}

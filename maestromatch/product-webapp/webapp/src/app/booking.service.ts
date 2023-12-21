import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingService {
private apiUrl="http://localhost:7070/bookings/newBooking";
  constructor(private http: HttpClient) { }

  getBooks(): Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  addBooking(booking: any):Observable<any>{
    return this.http.post<any>(this.apiUrl,booking);
  }
  getBookingsbyStudentId(studentId:number): Observable<any[]>{
    return this.http.get<any>("http://localhost:7070/bookings/student");
  }
}

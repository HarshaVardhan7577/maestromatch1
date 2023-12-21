import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookingHistoryService {
  private apiUrl="http://localhost:7001/bookings";
  constructor(private http: HttpClient) { }

  getBookingHistory() : Observable<any[]> {
    return this.http.get<any[]>(this.apiUrl);
  }
  addBooking(booking: any):Observable<any>{
    return this.http.post<any>(this.apiUrl,booking);
  }
}
  


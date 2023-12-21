import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})


export class RestServiceService {

  constructor(private http: HttpClient) { }

  public getRecommendations():Observable<any>{
    const url='http://localhost:7070/api/matchAllTeachers';
    return this.http.get<any>(url);
  }

  public getRecommendation(id : number):Observable<any>{
    const url=`http://localhost:7070/api/get-recommendations/${id}`;
    return this.http.get<any>(url);
  }

  public getByInstrument(instrument : String):Observable<any>{
    const url=`http://localhost:7070/api/matchAllTeachersWithInstrument?instrument=${instrument}`;
    return this.http.get<any>(url);
  }

  public getByName(firstName : String):Observable<any>{
    const url=`http://localhost:7070/api/matchAllTeachersWithFirstNameAndLastName?firstName=${firstName}`;
    return this.http.get<any>(url);
  }

  public getByLocation(location:String):Observable<any>{
    const url=`http://localhost:7070/api/matchAllTeachersWithLocation?location=${location}`;
    return this.http.get<any>(url);
  }

  public getByAllFields(location:String):Observable<any>{
    const url=`http://localhost:7070/api/matchAllTeachersWithAllFields?location=${location}`;
    return this.http.get<any>(url);
  }

  public getByNameAndInstrument(instrument:String):Observable<any>{
    const url=`http://localhost:7070/api/matchAllTeachersWithtNameAndInstrument?instrument=${instrument}`;
    return this.http.get<any>(url);
  }

  public getByNameAndLocation(instrument:String):Observable<any>{
    const url=`http://localhost:7070/api/matchAllTeachersWithtNameAndLocation?location=${instrument}`;
    return this.http.get<any>(url);
  }

  public getByInstrumentAndLocation(instrument:String):Observable<any>{
    const url=`http://localhost:7070/api/matchAllTeachersWithtInstrumentAndLocation?location=${instrument}`;
    return this.http.get<any>(url);
  }

  
}

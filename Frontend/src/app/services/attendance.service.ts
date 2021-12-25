import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {
  private url = "http://localhost:9001/employee/markAttendance";

  constructor(private http:HttpClient) { }

  //add attendance
  addAttendance(id:number,data:any): Observable<any> {
    return this.http.post(`${this.url}/${id}`,data);

    
  }

}

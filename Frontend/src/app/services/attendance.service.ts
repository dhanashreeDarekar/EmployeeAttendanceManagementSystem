import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AttendanceService {
  private url = "http://localhost:9001/employee/markAttendance";
  private urla = "http://localhost:9001/employee/getAttendance/";
  private urlb = "http://localhost:9001/manager/allAttendance";
  constructor(private http:HttpClient) { }

  //add attendance
  addAttendance(id:number,data:any): Observable<any> {
    return this.http.post(`${this.url}/${id}`,data);
  }

  //for single employee
  getAttDetails(id:number): Observable<any> {
    return this.http.get<any>(this.urla+id);
  }

  empAttDetails(): Observable<any> {
    return this.http.get<any>(this.urlb);
  }


}

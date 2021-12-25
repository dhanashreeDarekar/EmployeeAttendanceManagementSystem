import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AddEmpService {
  private url = 'http://localhost:9001/manager/add';
  constructor(private http:HttpClient ) {}


  // addEmployeeDetails(data:any): Observable<any> {
  //   return this.http.post(`${this.url}`,data);
  // }

  addEmployeeDetails(id:number,data:any): Observable<any> {
    return this.http.post(`${this.url}/${id}`,data);
  }

}

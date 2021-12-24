import { AllEmployees } from './../allEmployee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmpListService {
  private url = 'http://localhost:9001/';

  constructor(private http:HttpClient) { }

  // public getAllEmployees():Observable<any>{
  //   // return this.http.get("http://localhost:9001/manager/all")

  //   return this.http.get(url);

    // getAllEmployees(): Observable<AllEmployees> {
    //   return this.http.get<AllEmployees>(this.url+"manager/all");
    // }

    getAllEmployees(): Observable<any> {
      return this.http.get<any>(this.url+"manager/all");
    }
  }





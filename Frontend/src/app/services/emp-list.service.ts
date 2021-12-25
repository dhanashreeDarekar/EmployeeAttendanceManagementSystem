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


    getAllEmployees(): Observable<any> {
      return this.http.get<any>(this.url+"manager/all");
    }


  }





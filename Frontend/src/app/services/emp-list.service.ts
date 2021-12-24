import { AllEmployees } from './../allEmployee';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class EmpListService {


  constructor(private http:HttpClient) { }

  public getAllEmployees(){
    return this.http.get("http://localhost:9001/manager/all")
  }

}

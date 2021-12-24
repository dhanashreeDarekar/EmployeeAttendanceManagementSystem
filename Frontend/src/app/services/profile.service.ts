import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private url = "http://localhost:9002/employee/";

  constructor(private http:HttpClient) { }

  public getProfileDetails(id:number){
    return this.http.get("http://localhost:9002/employee/"+id)
  }

  // public updateProfileDetails(id:number){
  //   return this.http.put("http://localhost:9002/employee/"+id)
  // }


  // //get the profile 
  // getAll():Observable<any> {
  //   return this.http.get(`${url}`);
  // }

  // //get the profile for 1 employee
  // get(id): Observable<any> {
  //   return this.http.get(`${url}/${id}`);
  // }

  // //get the profile for 1 employee
  // create(data): Observable<any> {
  //   return this.http.post(url,data);
  // }

  // //get the profile for 1 employee
  // update(id,data): Observable<any> {
  //   return this.http.put(`${url}/${id}`,data);
  // }

  // //get the profile for 1 employee
  // delete(id): Observable<any> {
  //   return this.http.delete(`${url}/${id}`,data);
  // }


  





  

}

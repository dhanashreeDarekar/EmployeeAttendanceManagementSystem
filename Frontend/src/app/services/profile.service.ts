import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private url = "http://localhost:9002/profile/";

  constructor(private http:HttpClient) { }


  //get the profile 
  getAll():Observable<any> {
    return this.http.get(`${url}`);
  }

  //get the profile for 1 employee
  get(id): Observable<any> {
    return this.http.get(`${url}/${id}`);
  }

  //get the profile for 1 employee
  create(data): Observable<any> {
    return this.http.post(url,data);
  }

  //get the profile for 1 employee
  update(id,data): Observable<any> {
    return this.http.put(`${url}/${id}`,data);
  }

  //get the profile for 1 employee
  delete(id): Observable<any> {
    return this.http.delete(`${url}/${id}`,data);
  }


  





  

}

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  private url = "http://localhost:9002/";

  constructor(private http:HttpClient) { }

  // getProfileDetails():Observable<any>{
  //   return this.http.get(`${this.url+"employee"}`);
  // }

  // updateProfileDetails():Observable<any>{
  //   return this.http.get(`${this.url}`);
  // }

}

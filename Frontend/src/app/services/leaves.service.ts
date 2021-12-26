import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class LeavesService {

  private url = "http://localhost:9001/employee/requestLeave";
  private urla = "http://localhost:9001/manager/showleave/pending"
  private urlb = "http://localhost:9001/manager/approveLeave/"
  private urlc = "http://localhost:9001/manager/declined/"

  private urld = "http://localhost:9001/employee/getAllLeaves/"

  constructor(private http:HttpClient) { }


  requestLeave(id:number,data:any): Observable<any> {
    return this.http.post(`${this.url}/${id}`,data);
  }


  //retrieve all leaves for manager
  retrieveLeaves(): Observable<any> {
    return this.http.get<any>(this.urla);
  }

  aproveLeave(id:any): Observable<any> {
    return this.http.put<any>(this.urlb,id);
  }
  declineLeave(id:any): Observable<any> {
    return this.http.put<any>(this.urlc,id);
  }

  //show leave of an employee
  getLeaves(id:any): Observable<any> {
    return this.http.get<any>(this.urld+id);
  }


}

import { HttpClientModule,HttpClient ,HttpHeaders} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private url = "http://localhost:9001/";

  authenticated = false;
  constructor(private http:HttpClient) {

   }

   public validateLogin(user:any){

    return this.http.post(this.url+"user/login",user,{
      headers:
      {"Content-Type":"application/json"}
    })

   }
}

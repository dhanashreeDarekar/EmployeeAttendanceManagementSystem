
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {
    username:"",
    password:""
  }

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(){
    console.log("logged in!!");
    if((this.credentials.username!='' && this.credentials.password!='') && (this.credentials.username!=null && this.credentials.password!=null)){
      //we have to create a service

      //token service
      
    }else{
      console.log("fields are empty");
      
    }
  }

}

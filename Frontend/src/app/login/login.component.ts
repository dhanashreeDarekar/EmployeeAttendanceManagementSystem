import { EmpListComponent } from './../emp-list/emp-list.component';
import { LoginService } from './../services/login.service';

import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emps:any;

  user ={
    username:'',
    password:''
  }
  isError :boolean = true;


  constructor(private service:LoginService,private router:Router) { }

  ngOnInit(): void {
  }

  public login(){
    
    let response = this.service.validateLogin(this.user)
    response.subscribe(data=>{
      this.emps = 200;
      if(this.emps==200){
        // alert(data);
        // alert("logged in succesfully..");
        // this.isError=true;
        this.router.navigate(['/emp-list']);

      }
    },err=>{
      this.isError=false;
    }
    )

    // this.service.validateLogin(this.user).subscribe(data=>{
    //   if(data==200){
    //     // alert("logged in succesfully..");
    //     // this.isError=true;
    //     this.router.navigate(['/emp-list']);

    //   }
    // },err=>{
    //   this.isError=false;
    // }
    // )

  }

}

import { department } from './../department';
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

  id:any;

  user ={
    username:'',
    password:''
  }
  isError :boolean = true;


  empDetails:any ={
    emp_id:"",
    emp_name:"",
	  emp_designation:"",
    emp_mobile:"",
    emp_doj:"",
	  emp_email:"",
    department:{
        deptid:"",
        dept_name:""
    }
  }


  constructor(private service:LoginService,private router:Router) { }

  ngOnInit(): void {
  }

  public login(){
    
//we have to send here employee details and store it in localstorage for the session
    this.service.validateLogin(this.user).subscribe(
      data=>{
        if(data!= null){
          this.empDetails = data;

        localStorage.setItem("userId",this.empDetails.emp_id);
        localStorage.setItem("userDepartment",this.empDetails.department.dept_name);
        localStorage.setItem("userDesignation",this.empDetails.emp_designation);
        localStorage.setItem("userName",this.empDetails.emp_name);
        this.isError=true;
        this.router.navigate(['mark-attendance']);


      }
    },
    err=>{
      this.isError=false;
    }
    )

  }


  

}

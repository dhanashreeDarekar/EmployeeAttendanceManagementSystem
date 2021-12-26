import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent implements OnInit {

  userId:any = localStorage.getItem("userId");
  userDepartment = localStorage.getItem("userDepartment");
  userDesignation = localStorage.getItem("userDesignation");
  userName = localStorage.getItem("userName");
  isManager:boolean = true;
  constructor() { }

  ngOnInit(): void {
    //call id here 
    if(this.userDesignation == 'manager'){
      this.isManager = true;
    }else{
      this.isManager = false;
    }
  }


  getEmployeeDetails(){

  }



}

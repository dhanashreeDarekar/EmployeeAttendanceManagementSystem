import { LeavesService } from './../services/leaves.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-leave-apply',
  templateUrl: './leave-apply.component.html',
  styleUrls: ['./leave-apply.component.css']
})
export class LeaveApplyComponent implements OnInit {

  
  id:any = localStorage.getItem("userId");

  leave ={
    date_from:"",
	  date_to:"",
    leave_month:"",
    leave_description:""
  }

  constructor(private service:LeavesService,router:Router) { }

  ngOnInit(): void {
  }

  requestLeave(){

    this.service.requestLeave(this.id,this.leave).subscribe(
      (data) => {
        
        // console.log(data)
        alert("Applied for leave.. Wait for the confirmation..");
        window.location.reload();
      },
      err => {
        alert("Cannot Apply for Leave! Try Again!");
      }
    )
  }

}

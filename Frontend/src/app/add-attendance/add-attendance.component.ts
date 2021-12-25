import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AttendanceService } from './../services/attendance.service';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-add-attendance',
  templateUrl: './add-attendance.component.html',
  styleUrls: ['./add-attendance.component.css']
})
export class AddAttendanceComponent implements OnInit {

  id:any = localStorage.getItem("userId");

  attendance ={
    att_date_to:"",
	  att_month:"",
    date_from:"",
  }

  constructor(private service:AttendanceService,router:Router) { }

  ngOnInit(): void {
  }

  markAttendance(){
    console.log(this.attendance)
    this.service.addAttendance(this.id,this.attendance).subscribe(
      (data) => {
        console.log(this.id);
        console.log(data)
      },
      err => {
        console.log(err)
      }
    )
  }

}

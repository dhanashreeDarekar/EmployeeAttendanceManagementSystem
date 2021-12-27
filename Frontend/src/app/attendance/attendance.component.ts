import { Router } from '@angular/router';
import { AttendanceService } from './../services/attendance.service';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-attendance',
  templateUrl: './attendance.component.html',
  styleUrls: ['./attendance.component.css']
})
export class AttendanceComponent implements OnInit {
  
  attendance:any[]=[];
  id:any = localStorage.getItem("userId");

  constructor(private service:AttendanceService) { }

  ngOnInit(): void {
    this.retrieveAttendance();
  }


  retrieveAttendance():void{
    this.service.getAttDetails(this.id)
    .subscribe(
      (data) =>{
        console.log(data);
        this.attendance = data;
        
      },
      error =>{
        alert(error);
      }
      
    );
  }


  


  

}

import { AttendanceService } from './../services/attendance.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-emp-attendance',
  templateUrl: './emp-attendance.component.html',
  styleUrls: ['./emp-attendance.component.css']
})
export class EmpAttendanceComponent implements OnInit {

  
  attendance:any[]=[];

  constructor(private service:AttendanceService) { }

  ngOnInit(): void {
    this.retrieveAttendance();
  }

  retrieveAttendance():void{
    this.service.empAttDetails()
    .subscribe(
      (data) =>{
        console.log(data);
        this.attendance = data;
      },
      error =>{
        alert(error)
      }
      
    );
  }

}

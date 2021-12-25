import { AllEmployees } from './../allEmployee';
import { EmpListService } from './../services/emp-list.service';
import { Component, OnInit } from '@angular/core';
 import { Observable } from 'rxjs';

@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  employees:any[]=[];

  constructor(private service:EmpListService) { }

  ngOnInit(): void {
    this.retrieveEmployees();
  }

  retrieveEmployees():void{
    this.service.getAllEmployees()
    .subscribe(
      (data) =>{
        console.log(data);
        this.employees = data;
        
      },
      error =>{
        alert(error)
      }
      
    );
  }

}

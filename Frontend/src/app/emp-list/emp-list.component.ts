import { EmpListService } from './../services/emp-list.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-emp-list',
  templateUrl: './emp-list.component.html',
  styleUrls: ['./emp-list.component.css']
})
export class EmpListComponent implements OnInit {

  employees:any;

  constructor(private service:EmpListService) { }

  ngOnInit(): void {
    this.service.getAllEmployees()
    .subscribe(
      data => {
        this.employees = data;
      },
      error =>
      alert(error)
    )
  }

}

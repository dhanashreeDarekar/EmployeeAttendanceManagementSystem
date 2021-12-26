import { LeavesService } from './../services/leaves.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-my-leaves',
  templateUrl: './my-leaves.component.html',
  styleUrls: ['./my-leaves.component.css']
})
export class MyLeavesComponent implements OnInit {

  leaves:any[]=[];
  
  id:any = localStorage.getItem("userId");
  constructor(private service:LeavesService) { }

  myLeaveStatus:any

  ngOnInit(): void {
    this.getLeaves();

    
  }


  getLeaves(){
    this.service.getLeaves(this.id)
    .subscribe(
      (data) =>{

        this.leaves = data;
        this.leaves.forEach( (element) => {
          if(element.approved === 0){
            element.approved = "Pending";
          }else if (element.approved === 1){
            element.approved = "Approved";
          }else {
            element.approved = "Declined";
          }
      });
        
      },
      error =>{
        alert(error)
      }
      
    );
  }
}

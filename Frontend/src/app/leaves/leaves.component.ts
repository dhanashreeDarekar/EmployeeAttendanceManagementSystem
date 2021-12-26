import { LeavesService } from './../services/leaves.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-leaves',
  templateUrl: './leaves.component.html',
  styleUrls: ['./leaves.component.css']
})
export class LeavesComponent implements OnInit {

  leaves:any[]=[];

  constructor(private service:LeavesService, private router:Router) { }

  ngOnInit(): void {
    this.retrieveLeaves();
  }


  retrieveLeaves():void{
    this.service.retrieveLeaves()
    .subscribe(
      (data) =>{
        console.log(data);
        this.leaves = data;
        
      },
      error =>{
        alert(error)
      }
      
    );
  }

  leaveApprove(id:any){
    this.service.aproveLeave(id)
    .subscribe(
      (data) =>{
        window.location.reload();
        this.router.navigate(['/leaves']);
      },
      error =>{
        alert(error)
      }
    );
  }

  leaveDecline(id:any){
    this.service.declineLeave(id)
    .subscribe(
      (data) =>{

        window.location.reload();


      },
      error =>{
        alert(error)
      }
    );

  }

  

}

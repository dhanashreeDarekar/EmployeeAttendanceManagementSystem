import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent implements OnInit {

  userId:any = localStorage.getItem("userId");

  isEmployee:boolean = true;
  constructor() { }

  ngOnInit(): void {
    //call id here 
    //if(this.isEmployee == true){

    // }
  }



}

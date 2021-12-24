import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProfileService } from '../services/profile.service';
import { Injectable } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  currentProfile:any;
  
  constructor(private service:ProfileService) { }

  ngOnInit(): void {
    // this.getProfileDetails(id);
  }

  getProfileDetails(id:number):void{

    //get the profile data from id of current employee
    this.service.getProfileDetails(id).subscribe(
      data =>{
        this.currentProfile = data;
        console.log(data);
      },
      error =>{
        console.log(error);
      }
    )
  }

  // updateProfile():void {
  //   this.service.update(this.currentProfile.id,this.currentProfile)
  //   .subscribe(
  //     response =>{
  //       console.log(response);
  //       this.message = "Profile Updated Succesfully";
  //     },
  //     error => {
  //       console.log(error);
  //     }
  //   )
  // }


}

import { department } from './../department';
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


  currentProfile ={
    emp_id:"",
    emp_name:"",
	  emp_designation:"",
    emp_mobile:"",
    emp_doj:"",
	  emp_email:"",
    department:{
        deptid:"",
        dept_name:""
    }
  }

  id:any = localStorage.getItem("userId");

  constructor(private service:ProfileService) { }

  ngOnInit(): void {
    this.getProfileDetails(this.id);
  }

  //GET PROFILE DETAILS
  getProfileDetails(id:number):void{
    this.service.getProfileDetails(id)
    .subscribe(
      data =>{
       
        this.currentProfile = data;
        
      },
      error =>{
        alert(error)
      }
      
    );
  }


  //UPDATE PROFILE DETAILS
  updateProfileDetails():void{
    // alert(this.currentProfile.emp_name)
    this.service.updateProfileDetails(this.id,this.currentProfile)
    .subscribe(
      data =>{
        console.log(this.id);
        console.log(data)
        // this.currentProfile = data;
        
      },
      error =>{
        alert(error)
      }
      
    );
  }



}

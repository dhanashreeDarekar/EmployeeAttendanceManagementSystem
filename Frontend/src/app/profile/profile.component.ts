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

  

  constructor() { }

  ngOnInit(): void {
  }

  // getProfileDetails(){
  //   this.service.getProfileDetails().subscribe(data=>{
  //     this.profile = data;
  //   })
  // }

}

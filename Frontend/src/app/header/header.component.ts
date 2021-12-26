import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  logout() {
    localStorage.removeItem("userId");
    localStorage.removeItem("userDesignation");
    localStorage.removeItem("userDepartmrnt");
    localStorage.removeItem("userName");

    this.router.navigate(['/']).then(()=>{
      window.location.reload();
    })

    
  }

}

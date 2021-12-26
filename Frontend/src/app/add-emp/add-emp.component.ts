import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AddEmpService } from '../services/add-emp.service';
@Component({
  selector: 'app-add-emp',
  templateUrl: './add-emp.component.html',
  styleUrls: ['./add-emp.component.css']
})
export class AddEmpComponent implements OnInit {

  id:any;

  employee ={
    emp_name:"",
	  emp_designation:"",
    emp_mobile:"",
	  emp_email:""
  }

  constructor(private service:AddEmpService) { }

  ngOnInit(): void {
    // this.addEmployee();
  }

  addEmployee(){
    this.service.addEmployeeDetails(this.id,this.employee).subscribe(
      data =>{
        // alert(data)
        alert("Employee Added Succesfully");
        window.location.reload();
      },
      err =>{
        // alert(err)
      }
    )

}



// addEmployee(){
//   alert(this.employee.emp_name)
//   this.service.addEmployeeDetails(this.employee).subscribe(
//     data =>{
//       // alert(data)
//       console.log(data);
//     },
//     err =>{
//       // alert(err)
//     }
//   )

// }


  
}

package com.miniproject.module.AttendanceManagementSystem.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
import com.miniproject.module.AttendanceManagementSystem.Entity.Login;

import Services_Cls.EmployeeService;
import Services_Cls.LoginService;

@RestController
@RequestMapping("Employee")
public class EmployeeController {

	private EmployeeService empservice;
	public EmployeeController(EmployeeService empservice) {
		this.empservice = empservice;
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getInformation(@PathVariable("id") Long id){
		Employee emp = empservice.findEmployeeById(id);
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}
	
	@PutMapping("/updates")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp){
		Employee ee = empservice.updateEmployee(emp);
		return new ResponseEntity<>(ee , HttpStatus.OK);
	}
/*	
	@PatchMapping("/change/{password}")
		public ResponseEntity<Employee> changePass(@PathVariable("password") String password){
			Login log = loginservice.changePassword(password);
			return new ResponseEntity<>(log , HttpStatus.OK);
		}
	*/
	
}
	


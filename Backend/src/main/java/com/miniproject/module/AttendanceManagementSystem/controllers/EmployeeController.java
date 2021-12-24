package com.miniproject.module.AttendanceManagementSystem.controllers;


import java.util.List;
import java.util.Optional;

import com.miniproject.module.AttendanceManagementSystem.Entity.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.miniproject.module.AttendanceManagementSystem.Entity.Login;

import com.miniproject.module.AttendanceManagementSystem.Services_Cls.AttendanceService;
import com.miniproject.module.AttendanceManagementSystem.Services_Cls.EmployeeService;
//import Services_Cls.LoginService;

@Configuration
@RestController
@RequestMapping("/employee/")
public class EmployeeController {

	
	private final AttendanceService attendanceservice;
	private final EmployeeService empservice;

	public EmployeeController(@Lazy AttendanceService attendanceservice, @Lazy EmployeeService empservice) {
		this.attendanceservice = attendanceservice;
		this.empservice = empservice;
		
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getInformation(@PathVariable("id") int id){
		Optional<Employee> emp = empservice.findEmployeeById(id);
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp){
		Employee ee = empservice.updateEmployee(emp);
		return new ResponseEntity<>(ee , HttpStatus.OK);
	}
	
	@PostMapping("/markAttendance")
	public String markAttendance(@RequestBody Attendance_Cls request) {
			attendanceservice.apply_Attendance(request);
			return "Attendance Mark Successfully ";
	}
	

	@PostMapping("/appyLeave")
	public ResponseEntity<Leave> ApplyForLeave(@RequestBody Leave request ) {
		System.out.println("Hello");
		Leave lv =  empservice.applyForLeave(request);
		return new ResponseEntity<>(lv , HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllLeaves/{empid}")
	public ResponseEntity<List<Leave>> ViewStatusForLeave(@PathVariable("empid") int empid) {
		List<Leave> l = empservice.viewStatus(empid);
//		Leave lv;
//		if(l.isPresent())
//		lv= l.get();
//		else
//			lv = null;
		return new ResponseEntity<>(l,HttpStatus.OK);
	}
/*	
	@PatchMapping("/change/{password}")
		public ResponseEntity<Employee> changePass(@PathVariable("password") String password){
			Login log = loginservice.changePassword(password);
			return new ResponseEntity<>(log , HttpStatus.OK);
		}
	*/
	
}
	


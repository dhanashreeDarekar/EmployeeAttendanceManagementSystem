package com.miniproject.module.AttendanceManagementSystem.controllers;


import java.util.Optional;

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

import com.miniproject.module.AttendanceManagementSystem.Entity.AttendanceRequest;
import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
import com.miniproject.module.AttendanceManagementSystem.Entity.Leave;
import com.miniproject.module.AttendanceManagementSystem.Entity.LeaveRequest;
//import com.miniproject.module.AttendanceManagementSystem.Entity.Login;

import com.miniproject.module.AttendanceManagementSystem.Services_Cls.AttendanceService;
import com.miniproject.module.AttendanceManagementSystem.Services_Cls.EmployeeService;
//import Services_Cls.LoginService;

@Configuration
@RestController
@RequestMapping("/Employee")
public class EmployeeController {


	private final AttendanceService attendanceservice;
	private final EmployeeService empservice;

	public EmployeeController(@Lazy AttendanceService attendanceservice, @Lazy EmployeeService empservice) {
		this.attendanceservice = attendanceservice;
		this.empservice = empservice;
		
	}
//	public EmployeeController()
//	{
//
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Employee>> getInformation(@PathVariable("id") int id){
		Optional<Employee> emp = empservice.findEmployeeById(id);
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}
	
	@PutMapping("/updates")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee emp){
		Employee ee = empservice.updateEmployee(emp);
		return new ResponseEntity<>(ee , HttpStatus.OK);
	}
	
	@PostMapping("/markattendance")
	public String markAttendance(@RequestBody  AttendanceRequest request) {
			attendanceservice.apply_Attendance(request);
			return "Attendance Mark Successfully ";
	}
	
//	@PostMapping("/appyleave")
//	public String ApplyForLeave(@RequestBody LeaveRequest request ) {
//		return empservice.applyForLeave(request);
//	}
//
//	@GetMapping("/applyleave/{empid}")
//	public ResponseEntity<Leave> ViewStatusForLeave(@PathVariable("empid") int empid) {
//		Optional<Leave> l = empservice.viewStatus(empid);
//		Leave lv;
//		if(l.isPresent())
//		lv= l.get();
//		else
//			lv = null;
//		return new ResponseEntity<>(lv,HttpStatus.OK);
//	}
/*	
	@PatchMapping("/change/{password}")
		public ResponseEntity<Employee> changePass(@PathVariable("password") String password){
			Login log = loginservice.changePassword(password);
			return new ResponseEntity<>(log , HttpStatus.OK);
		}
	*/
	
}
	


package com.miniproject.module.AttendanceManagementSystem.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.miniproject.module.AttendanceManagementSystem.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import Repository_Cls.DepartmentRepo;
import com.miniproject.module.AttendanceManagementSystem.Services_Cls.DepartmentService;
import com.miniproject.module.AttendanceManagementSystem.Services_Cls.ManagerServices;
//@Component
@Configuration
@RestController
@RequestMapping("/Manager")
public class ManagerController {

	private final ManagerServices managerservices;
	private final DepartmentService deptservice ;
//	private Employee employeeservice;
//	@Bean
//	public ManagerServices managerServices(){return new ManagerServices();}
//	@Bean
//	public DepartmentService deptservice(){return new DepartmentService();}
//	@Autowired
	public ManagerController(@Lazy ManagerServices managerservices ,@Lazy DepartmentService deptservice) {
		this.managerservices = managerservices;
		this.deptservice = deptservice;
//		this.employeeservice = employeeservice;
	}
//	public ManagerController()
//	{
//
//	}
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> emp = managerservices.findAllEmployee();
		return new ResponseEntity<>(emp , HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") int id){
		Optional<Employee> emp = managerservices.findEmployeeById(id);
		Employee em;
		if(emp.isPresent())
			em= emp.get();
		else
			em = null;
		System.out.println("run hoxzx");
		return new ResponseEntity<>(em , HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee newEmp = managerservices.addEmp(employee);
		return new ResponseEntity<>(newEmp , HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> delEmp(@PathVariable("id") int id){
		managerservices.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/alldept") // for displaying all department
	public ResponseEntity<List<Department>> allDepartment(){
		System.out.println("jhjhj");
//		deptservice =new DepartmentService();
		List<Department> dpt = deptservice.finAllDept();
		return new ResponseEntity<>(dpt,HttpStatus.OK);
		}
	
//	@GetMapping("/alldept/{deptid}")
//	public ResponseEntity<List<Employee>> findEmployeesByDeptId(@PathVariable("deptid") int deptid){
//		List<Employee> employee = deptservice.findEmployeesByDeptId(deptid);
//		return new ResponseEntity<>(employee , HttpStatus.OK);
//	}
	@GetMapping("/attendanceview/{empid}")
	public ResponseEntity<Attendance_Cls> viewAttendanceByIds(@PathVariable("empid") int empid){
		Optional<Attendance_Cls> newAttendance = managerservices.viewAttendanceById(empid);
		Attendance_Cls at;
		if(newAttendance.isPresent())
			at= newAttendance.get();
		else
			at = null;
		return new ResponseEntity<>(at , HttpStatus.OK);
	}
	
	@GetMapping("/attendanceview")
	public ResponseEntity<List<Attendance_Cls>> viewAttendance(){
		List<Attendance_Cls> attendancess =  managerservices.viewAttendance();
		return new ResponseEntity<>(attendancess ,HttpStatus.OK);
	}
	/*
	 
	@GetMapping("/alldept/id/{empid} ")
	public ResponseEntity<Employee> selectPerticularEmployee(@PathVariable("empid") Long empid){
		Employee e = employeeservice.getPerticularEmp(empid);
		return new ResponseEntity<>(e , HttpStatus.OK);
	}
	*/
	@GetMapping("/showleave")
	public ResponseEntity<List<Leave>> showLeave(){
		List<Leave> ll = managerservices.showLeaveReq();
		return new ResponseEntity<>(ll , HttpStatus.OK);
	}
	
	@GetMapping("/showleave/{empid}")
	public ResponseEntity<Leave> showEmpLeave(@PathVariable("empid") int empid){
		Optional<Leave> ll = managerservices.getLeaveByEmpid(empid);
		Leave lv;
		if(ll.isPresent())
			lv= ll.get();
		else
			lv = null;
		return new ResponseEntity<>(lv , HttpStatus.OK);
	}

	@PostMapping("/showleave/empid")
	public void AcceptLeave(@RequestBody LeaveRequest request){
		managerservices.LeaveStatus(request);
	}
}

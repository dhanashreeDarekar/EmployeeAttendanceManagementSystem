package com.miniproject.module.AttendanceManagementSystem.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import com.miniproject.module.AttendanceManagementSystem.Entity.*;
import com.miniproject.module.AttendanceManagementSystem.Services_Cls.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import Repository_Cls.DepartmentRepo;

import javax.persistence.PostUpdate;

//@Component
@Configuration
@RestController
@RequestMapping("/manager")
public class ManagerController {

	private final ManagerServices managerservices;
	private final DepartmentService deptservice ;
	private final LeaveService leaveService;
	private final EmployeeService employeeService;
	private final AttendanceService attendanceService;
	

	public ManagerController(@Lazy ManagerServices managerservices ,@Lazy DepartmentService deptservice,@Lazy LeaveService leaveService,@Lazy EmployeeService employeeService,@Lazy AttendanceService attendanceService) {
		this.managerservices = managerservices;
		this.deptservice = deptservice;
		this.leaveService = leaveService;
		this.employeeService = employeeService;
		this.attendanceService = attendanceService;
	}

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
		return new ResponseEntity<>(em , HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		Employee newEmp = managerservices.addEmp(employee);
		return new ResponseEntity<>(newEmp , HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delEmp(@PathVariable("id") int id){
		managerservices.deleteEmployee(id);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}
	
	@GetMapping("/alldept") // for displaying all department
	public ResponseEntity<List<Department>> allDepartment(){

		List<Department> dpt = deptservice.finAllDept();
		return new ResponseEntity<>(dpt,HttpStatus.OK);
		}
	
	@GetMapping("/alldeptEmployee/{deptid}")
	public ResponseEntity<List<Employee>> findEmployeesByDeptId(@PathVariable("deptid") int deptid){
		List<Employee> employee = employeeService.findEmployeesByDeptId(deptid);
		return new ResponseEntity<>(employee , HttpStatus.OK);
	}
	@GetMapping("/attendanceview/{empid}")
	public ResponseEntity<List<Attendance_Cls>> viewAttendanceByIds(@PathVariable("empid") int empid){
		List<Attendance_Cls> newAttendance = attendanceService.viewByEmpId(empid);
//		Attendance_Cls at;
//		if(newAttendance.isPresent())
//			at= newAttendance.get();
//		else
//			at = null;
		return new ResponseEntity<>(newAttendance, HttpStatus.OK);
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
	@GetMapping("/showleave/Accepted")
	public ResponseEntity<List<Leave>> showAcceptedEmpLeave(){
		List<Leave> ll = leaveService.getLeaveByAccepted();
		return new ResponseEntity<>(ll , HttpStatus.OK);
	}
	@GetMapping("/showleave/NotAccepted")
	public ResponseEntity<List<Leave>> showNotAcceptedEmpLeave(){
		List<Leave> ll = leaveService.getLeaveByNotAccepted();
		return new ResponseEntity<>(ll , HttpStatus.OK);
	}

	@GetMapping("/showleave/{empid}")
	public ResponseEntity<List<Leave>> showEmpLeave(@PathVariable("empid") int empid){
		List<Leave> ll = leaveService.checkStatus(empid);

		return new ResponseEntity<>(ll , HttpStatus.OK);
	}
	@PutMapping("/ApproveLeave/{leaveid}")
	public ResponseEntity<Leave> approveLeave(@PathVariable("leaveid") int leaveid)
	{
		Leave lv = leaveService.approveLeave(leaveid);
		return new ResponseEntity<>(lv,HttpStatus.OK);
	}
//	@PostMapping("/showleave/empid")
//	public void AcceptLeave(@RequestBody LeaveRequest request){
//		managerservices.LeaveStatus(request);
//	}
	@DeleteMapping("/DeleteDept/{deptid}")
	public ResponseEntity<String> deletedepartment(@PathVariable("deptid") int deptid)
	{
		deptservice.deleteDepartment(deptid);
		return new ResponseEntity<>("Deleted",HttpStatus.OK);
	}

	@PostMapping("/addDept")
	public ResponseEntity<Department> addDepartment(@RequestBody Department department)
	{
		Department dp = deptservice.addDept(department);
		return new ResponseEntity<>(dp,HttpStatus.OK);
	}

}

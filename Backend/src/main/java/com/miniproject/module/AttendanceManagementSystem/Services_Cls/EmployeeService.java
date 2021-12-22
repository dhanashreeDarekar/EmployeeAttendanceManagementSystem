package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.util.Optional;

import javax.transaction.Transactional;

import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;

@Service
@Transactional
@Component
public class EmployeeService {


	private final EmpRepo emprepo;
	
//	@Autowired
//	private final LeaveService leaveservice;
	
//	@Autowired
//	private ManagerServices managerservice;
	@Autowired
	public EmployeeService(EmpRepo emprepo )
	{
		this.emprepo = emprepo;
//		this.leaveservice = leaveservice;
	}
//	public EmployeeService() {
//
//	}
	public Employee updateEmployee(Employee emp) {
		return emprepo.save(emp);
	}
	
	public Optional<Employee> findEmployeeById(int id) {
		return emprepo.findById(id);
	}
	
	public Optional<Employee> getPerticularEmployee(int empid) {
		return emprepo.findById(empid);
	}
	
	public Optional<Employee> findEmployeeByDeptId(int deptid){
		return  emprepo.findById(deptid);
	}
	
//	public Optional<Employee> getEmployee(String emp_email){
//		return emprepo.findByEmail(emp_email);
//	}
	
//	public String applyForLeave(LeaveRequest request) {
//		int eid = request.getLeave_emp_id();
//		//managerservice.showLeaves(eid);
//		return leaveservice.applyLeave(request);
//	}
	
//	public Optional<Leave> viewStatus(int empid){
//		return leaveservice.checkStatus(empid);
//	}
/*	
	public Leaves showLeave(LeaveRequest request) {
		
		return 
	}
	*/
}

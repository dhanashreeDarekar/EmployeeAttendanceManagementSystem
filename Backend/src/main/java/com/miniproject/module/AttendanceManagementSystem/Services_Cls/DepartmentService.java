package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.Department;
import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;



@Service
@Transactional
@Component
public class DepartmentService {

	@Autowired
	private DepartmentRepo deptrepo;
//	@Bean
//	public DepartmentRepo deptrepo(){return new DepartmentRepo()}


	public DepartmentService(DepartmentRepo deptrepo) {
		this.deptrepo =deptrepo;
	}
	public DepartmentService(){
//		deptrepo = new D
	}
	public List<Department> finAllDept() {
		System.out.println("Deparntment Service");

//		if(deptrepo==null)
//			return "null";
//		else
//			return "ok";
		return deptrepo.findAll();
	}
	
	public Optional<Department> AllEmployees(int dept_id) {
		return deptrepo.findById(dept_id);
	}
	
//	EmployeeService empser = new EmployeeService();
	
//	public List<Employee> findEmployeesByDeptId(int deptid){
//		return (List<Employee>) empser.findEmployeeByDeptId(deptid);
//	}
}

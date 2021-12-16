package com.miniproject.module.AttendanceManagementSystem.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import java.util.*;
@Entity
@Table(name ="Employee")
public class Employee implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO  )
	@Column(nullable = false , updatable = false)
	private Long emp_id;
	private String emp_name;
	private String emp_designation;
	private Date emp_doj = new Date();
	private int emp_dept_id;
	private String emp_mobile;
	private String emp_email;

	@Column(nullable = false , updatable = false)
	private String empcode;

	Employee(Long emp_id , String emp_name ,String emp_designation , Date emp_doj , int emp_deptment , String emp_mobile , String emp_email , String emp_code){
		this.emp_id = emp_id ;
		this.emp_name = emp_name ;
		this.emp_designation = emp_designation;
		this.emp_doj = emp_doj;
		emp_dept_id = emp_deptment;
		this.emp_mobile = emp_mobile;
		this.emp_email = emp_email;
		this.empcode = empcode;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getEmp_designation() {
		return emp_designation;
	}

	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}

	public Date getEmp_doj() {
		return emp_doj;
	}

	public void setEmp_doj(Date emp_doj) {
		this.emp_doj = emp_doj;
	}

	public int getEmp_department() {
		return emp_dept_id;
	}

	public void setEmp_department(int emp_dept) {
		this.emp_dept_id = emp_dept;
	}

	public String getEmp_mobile() {
		return emp_mobile;
	}

	public void setEmp_mobile(String emp_mobile) {
		this.emp_mobile = emp_mobile;
	}

	public String getEmp_email() {
		return emp_email;
	}

	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	
	@OneToMany(mappedBy = "Employee")
    private Set<Department> department = new HashSet<>();
	
	@ManyToOne
    @JoinColumn(name = "att_id")
    private Attendance_Cls attc;
	
    @ManyToOne
    @JoinColumn(name = "leave_id")
    private Leave leave;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "login_id")
    private Login login;

	public void setEmpcode(String empcode) {
		// TODO Auto-generated method stub
		this.empcode = empcode;
	}
	
	public String getEmpCode() {
		return empcode;
	}
	
	@Override
	public String toString() {
		
		return " Employee{" +" id = " + emp_id +
				", name = "+ emp_name +  " / " + 
				" , Designation = " + emp_designation + '/' +
				" ,  Date _of_Joining = " + emp_doj + '/' +
				", employee_department_id = " + emp_dept_id + '/' +
				", Mobile = " + emp_mobile + '/' +
				", Email = " + emp_email + '/' +
				"}; " ;
	}
}

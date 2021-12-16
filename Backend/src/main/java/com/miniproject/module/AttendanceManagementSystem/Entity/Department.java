package com.miniproject.module.AttendanceManagementSystem.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false , updatable = false)
	private int dept_id;
	private String dept_name;
	private int dept_total_employee;
	
	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getDept_total_employee() {
		return dept_total_employee;
	}

	public void setDept_total_employee(int dept_total_employee) {
		this.dept_total_employee = dept_total_employee;
	}

	public Department(int dept_id, String dept_name, int dept_total_employee) {
		super();
		this.dept_id = dept_id;
		this.dept_name = dept_name;
		this.dept_total_employee = dept_total_employee;
	}
	
	@ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee emp;
}

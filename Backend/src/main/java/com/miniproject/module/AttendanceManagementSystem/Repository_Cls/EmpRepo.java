package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee , Integer> {

//	Employee findById(int id);
////
//////	Employee getPerticularEmployee(int empid);
//	Optional<Employee> findByEmail(String emp_email);
}

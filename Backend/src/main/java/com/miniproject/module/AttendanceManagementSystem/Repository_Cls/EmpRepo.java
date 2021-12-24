package com.miniproject.module.AttendanceManagementSystem.Repository_Cls;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
@Repository
<<<<<<< HEAD
public interface EmpRepo extends JpaRepository<Employee , Integer> {
    List<Employee> findAllByDepartment_Deptid(int deptid);
=======
public interface EmpRepo extends CrudRepository<Employee , Integer> {

>>>>>>> 6fb99a9 (updated fe and be)

}

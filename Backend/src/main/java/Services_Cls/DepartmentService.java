package Services_Cls;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.Department;
import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;

import Repository_Cls.DepartmentRepo;

@Service
@Transactional
public class DepartmentService {

	private DepartmentRepo deptrepo;
	
	public DepartmentService(DepartmentRepo deptrepo) {
		this.deptrepo =deptrepo;
	}

	public List<Department> finAllDept() {
		return deptrepo.findAll();
	}
	
	public Department AllEmployees(Long dept_id) {
		return deptrepo.AllEmployeeById(dept_id);
	}
	
	EmployeeService empser = new EmployeeService();
	
	public List<Employee> findEmployeesByDeptId(Long deptid){
		return (List<Employee>) empser.findEmployeeByDeptId(deptid);
	}
}

package Services_Cls;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;

import Repository_Cls.EmpRepo;

@Service
@Transactional
public class EmployeeService {

	private EmpRepo emprepo;
	
	public EmployeeService(EmpRepo emprepo) {
		this.emprepo = emprepo;
	}
	public EmployeeService() {}
	public Employee updateEmployee(Employee emp) {
		return emprepo.save(emp);
	}
	
	public Employee findEmployeeById(Long id) {
		return emprepo.findEmployeeById(id);
	}
	
	public Employee getPerticularEmployee(Long empid) {
		return emprepo.getPerticularEmployee(empid);
	}
	
	public List<Employee> findEmployeeByDeptId(Long deptid){
		return (List<Employee>) emprepo.getById(deptid);
		
	}
}

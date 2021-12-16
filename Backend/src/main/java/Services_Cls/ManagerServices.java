package Services_Cls;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;

import Repository_Cls.ManagerRepo;
import java.lang.Long;
@Service
@Transactional
public class ManagerServices {

	@Autowired
	private final ManagerRepo managerrepo;
	
	@Autowired
	public ManagerServices(ManagerRepo managerrepo) {
		this.managerrepo = managerrepo;
	}
	
	public Employee addEmp(Employee emp) {	
		String s = UUID.randomUUID().toString();
		Long l = Long.parseLong(s);
		emp.setEmp_id(l);
		return managerrepo.save(emp);
	}
	
	public List<Employee> findAllEmployee(){
		return managerrepo.findAll();
	}
	
	public Employee findEmployeeById(Long id) {
		return managerrepo.findEmployeeById(id);
	}
	
	public void deleteEmployee(Long emp_id) {
		managerrepo.deleteById(emp_id);
	}
	
}

package Repository_Cls;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;

public interface ManagerRepo extends JpaRepository<Employee , Long>{

	List<Employee> findAll();

	//Employee findEmployeeById(Long id);

	Employee findEmployeeById(Long id);

}

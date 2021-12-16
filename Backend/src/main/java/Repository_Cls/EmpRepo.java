package Repository_Cls;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;
@Repository
public interface EmpRepo extends JpaRepository<Employee , Long> {

	

	Employee findEmployeeById(Long id);

	Employee getPerticularEmployee(Long empid);

}

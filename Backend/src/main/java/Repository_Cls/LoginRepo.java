package Repository_Cls;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miniproject.module.AttendanceManagementSystem.Entity.Login;

@Repository
public interface LoginRepo extends JpaRepository<Login , Long> {

	
}

package Services_Cls;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

//import com.miniproject.module.AttendanceManagementSystem.Entity.Employee;

import Repository_Cls.LoginRepo;

@Service
@Transactional
public class LoginService {

	private LoginRepo loginrepo;
	
	LoginService(LoginRepo loginrepo){
		this.loginrepo = loginrepo;
	}
	/*
	public Login changePassword(String password) {
		return loginrepo.save(password);
	}*/
}

package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.AttendanceRepo;
import org.springframework.stereotype.Service;

import com.miniproject.module.AttendanceManagementSystem.Entity.AttendanceRequest;
import com.miniproject.module.AttendanceManagementSystem.Entity.Attendance_Cls;

@Service
@Transactional
public class AttendanceService {

	private AttendanceRepo attendancerepo;
	
	public AttendanceService( AttendanceRepo attendancerepo) {
		this.attendancerepo = attendancerepo;
	}
	
	Attendance_Cls att ;
	int aid = 0;
	public void apply_Attendance(AttendanceRequest request) {
		
		int aid = request.getAtt_emp_id();
		att.setAtt_id(aid);
		 attendancerepo.save(att);
	}
	
	public Optional<Attendance_Cls> findAttendanceById(int emp_id) {
		if(emp_id == att.getAtt_id()) {
			aid = att.getAtt_id();
		}
		return attendancerepo.findById(aid);
		
	}
	
	public List<Attendance_Cls> viewAttend(){
		return  attendancerepo.findAll();
	}
}


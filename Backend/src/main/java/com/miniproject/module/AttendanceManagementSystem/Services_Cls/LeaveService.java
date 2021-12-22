package com.miniproject.module.AttendanceManagementSystem.Services_Cls;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.miniproject.module.AttendanceManagementSystem.Entity.Leave;
import com.miniproject.module.AttendanceManagementSystem.Entity.LeaveRequest;

import com.miniproject.module.AttendanceManagementSystem.Repository_Cls.LeaveRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Component
public class LeaveService {

	@Autowired
	private LeaveRepo leaverepo;
	
	public LeaveService(LeaveRepo leaverepo) {
		this.leaverepo = leaverepo;
	}

	Leave ll ;
	public String applyLeave(LeaveRequest request) {
		
		int eid = request.getLeave_emp_id() ;
		ll.setLeave_id(eid);
		leaverepo.save(ll);
		
		return " Applied Leave SuccessFully !!!!";
	}
	
	public List<Leave> viewLeaves(){
		return leaverepo.findAll();
	}
	
	public Optional<Leave> findEmpLeaveById(int empid) {
		return leaverepo.findById(empid);
	}
	
	public void LeaveEmpStatus(LeaveRequest request){
		boolean leave_approved = request.isLeave_approved();
		int leave_emp_id = request.getLeave_emp_id();
//		leaverepo.LeaveStatus(leave_approved , leave_emp_id);
	}
	
	public Optional<Leave> checkStatus(int empid) {
		return leaverepo.findById(empid);
	}
}

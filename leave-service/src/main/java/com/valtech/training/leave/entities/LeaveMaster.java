package com.valtech.training.leave.entities;

import java.time.temporal.ChronoUnit;

import com.valtech.training.leave.commons.LeaveType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LeaveMaster {

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "leaveseq")
	@SequenceGenerator(name = "leaveseq", sequenceName = "leave_seq",allocationSize = 1)
	private long id;
	private int casualLeaves;
	private int sickLeaves;
	private int otherLeaves;
	private long employeeId;
	
	public LeaveMaster() {}
	public LeaveMaster(long id, int casualLeaves, int sickLeaves, int otherLeaves,long employeeId) {
		this.id = id;
		this.casualLeaves = casualLeaves;
		this.sickLeaves = sickLeaves;
		this.otherLeaves = otherLeaves;
		this.employeeId=employeeId;
	}
	
	public void takeLeaves(Leave leave) {
		if(leave.getLeaveType()==LeaveType.CASUAL) {
			casualLeaves -= leave.leavesInDays();
			return;
		}
		if(leave.getLeaveType()==LeaveType.SICK) {
			casualLeaves -= leave.leavesInDays();
			return;
		}
		if(leave.getLeaveType()==LeaveType.OTHERS) {
			casualLeaves -= leave.leavesInDays();
			return;
		}	
	}
	
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public long getEmployeeId() {
		return employeeId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCasualLeaves() {
		return casualLeaves;
	}
	public void setCasualLeaves(int casualLeaves) {
		this.casualLeaves = casualLeaves;
	}
	public int getSickLeaves() {
		return sickLeaves;
	}
	public void setSickLeaves(int sickLeaves) {
		this.sickLeaves = sickLeaves;
	}
	public int getOtherLeaves() {
		return otherLeaves;
	}
	public void setOtherLeaves(int otherLeaves) {
		this.otherLeaves = otherLeaves;
	}
	
}

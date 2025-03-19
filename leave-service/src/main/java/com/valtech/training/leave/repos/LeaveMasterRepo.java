package com.valtech.training.leave.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valtech.training.leave.entities.LeaveMaster;

public interface LeaveMasterRepo extends JpaRepository<LeaveMaster, Long> {

	LeaveMaster findByEmployeeId(long employeeId);

}

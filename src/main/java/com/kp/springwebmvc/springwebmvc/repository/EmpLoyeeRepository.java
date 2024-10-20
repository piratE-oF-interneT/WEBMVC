package com.kp.springwebmvc.springwebmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kp.springwebmvc.springwebmvc.entity.EmployeeEntity;

@Repository

public interface EmpLoyeeRepository extends JpaRepository<EmployeeEntity,Long>{
	
	

}

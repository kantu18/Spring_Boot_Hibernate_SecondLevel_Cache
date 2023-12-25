package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Org_Employee;

@Repository
public interface Employee_Repository extends JpaRepository<Org_Employee, Integer>{

	
	@Query("select emp from Org_Employee emp")
	public List<Org_Employee> getallemployees(PageRequest req);
	
	
}

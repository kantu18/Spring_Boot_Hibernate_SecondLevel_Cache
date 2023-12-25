package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Org_Employee;
import com.example.demo.repository.Employee_Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class Employee_service {

	@Autowired
	private Employee_Repository empRepository;
	
/*	@PersistenceContext
	private EntityManager entityManager;
	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
*/
	@Cacheable(value="employee_cache")
	public List<Org_Employee> getallEmp_details() throws InterruptedException, ExecutionException
	{
		int pagenum=0;
		int pagesize=10;
		
	/*	String sql="select * from employee";
		Query qu= getEntityManager().createQuery(sql);
		qu.setFirstResult(0);
		qu.setMaxResults(10);
		
		qu.getResultList();
	*/	
		PageRequest req=PageRequest.of(pagenum, pagesize);
				return empRepository.getallemployees(req);
	}
	
	@CachePut(value = "employee_cache",key="#employee.id", condition ="#employee.id != null" )
	@CacheEvict(value = "employee_cache", allEntries = true )
	public Org_Employee saveEmp_details(Org_Employee employee) throws InterruptedException, ExecutionException
	{		 		
		Org_Employee savedEmployee = empRepository.save(employee);
	    return savedEmployee != null ? savedEmployee : employee;
		
	}
	@Cacheable(value="employee_cache", key="#id")
	public Optional<Org_Employee> findbyId(int id) throws InterruptedException, ExecutionException
	{
		ExecutorService exe=Executors.newCachedThreadPool();
		CompletableFuture<Optional<Org_Employee>> como=CompletableFuture.supplyAsync(() -> {
			return empRepository.findById(id);
		},exe);
		return como.get();
	}
}

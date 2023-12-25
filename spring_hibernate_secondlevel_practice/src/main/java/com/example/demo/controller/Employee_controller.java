package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Org_Employee;
import com.example.demo.service.Employee_service;


@RestController
@RequestMapping("/api")
public class Employee_controller {

	
	@Autowired
	private Employee_service eService;
	
	@GetMapping("/getall")
	public ResponseEntity<List<Org_Employee>> getAllEmployee_details() throws InterruptedException, ExecutionException
	{
		List<Org_Employee> fetch_details = eService.getallEmp_details();
		return new ResponseEntity<List<Org_Employee>>(fetch_details, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Org_Employee> savedetails(@RequestBody Org_Employee employee) throws InterruptedException, ExecutionException
	{
		Org_Employee emp_details=eService.saveEmp_details(employee);
		return new ResponseEntity<Org_Employee>(emp_details,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Optional<Org_Employee>> finddetails_of_employee(@PathVariable int id) throws InterruptedException, ExecutionException
	{
		Optional<Org_Employee> fetchbyid= eService.findbyId(id);
		return new ResponseEntity<Optional<Org_Employee>>(fetchbyid,HttpStatus.OK);
	}
}

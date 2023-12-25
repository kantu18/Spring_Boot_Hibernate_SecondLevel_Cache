package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dept_id;
	@Column(name="COUNTRY")
	private String Country;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="ZIPCODE")
	private Long zipcode;
	
	//one-one relationship with the employee table and using joincolumn 
	//to name that particular column which is linked with employee table.
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="EMP_ID")
	private Org_Employee emp_id;

	//Many to many relation with the product table and using 
	//joincolumn and inverse joincolumn to rename the columns of newly created table.
	
	@ManyToMany()
	@JoinTable(name="deptartment_prod", joinColumns = {@JoinColumn(name="d_id")}, inverseJoinColumns = {@JoinColumn(name="p_id")})
	private List<Product> prod;
	
	public Department() {
		super();
		}

	public Department(int dept_id, String country, String address, Long zipcode, Org_Employee emp_id) {
		super();
		this.dept_id = dept_id;
		Country = country;
		this.address = address;
		this.zipcode = zipcode;
		this.emp_id = emp_id;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getZipcode() {
		return zipcode;
	}

	public void setZipcode(Long zipcode) {
		this.zipcode = zipcode;
	}

	public Org_Employee getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Org_Employee emp_id) {
		this.emp_id = emp_id;
	}

	@Override
	public String toString() {
		return "Department [dept_id=" + dept_id + ", Country=" + Country + ", address=" + address + ", zipcode="
				+ zipcode + ", emp_id=" + emp_id + "]";
	}
	
}

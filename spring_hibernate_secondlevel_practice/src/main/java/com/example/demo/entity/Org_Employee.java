package com.example.demo.entity;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Org_Employee")
@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class Org_Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="EMP_NAME")
	private String emp_name;
	@Column(name="ADDRESS")
	private String address;
	@Column(name="AGE")
	private int age;
	@Column(name="SALARY")
	private Long salary;
	
	//one-many relationship with the product table where many products are brought by a single employee
	//hence in this class many-to-one relationship is used with mapped by to not create an extra column in the employee table.
		
	@OneToMany(mappedBy = "employee",fetch = FetchType.EAGER)
	private List<Product> product;

	
	public Org_Employee() {
		super();
	}

	public Org_Employee(Integer id, String emp_name, String address, int age, Long salary, List<Product> product) {
		super();
		this.id = id;
		this.emp_name = emp_name;
		this.address = address;
		this.age = age;
		this.salary = salary;
		this.product = product;
	}
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmp_name() {
		return emp_name;
	}

	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getSalary() {
		return salary;
	}

	public void setSalary(Long salary) {
		this.salary = salary;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Org_Employee [id=" + id + ", emp_name=" + emp_name + ", address=" + address + ", age=" + age
				+ ", salary=" + salary + ", product=" + product + "]";
	}
	
}

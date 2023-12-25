package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Product")
public class Product {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	@Column(name="prod_name")
	private String prod_name;
	
	@Column(name="Price")
	private Long price;
	
	//many-to-one relationship with the employee table where many products are brought by a single employee
	//hence in this class many-to-one relationship is used with joincolumn to name the mapped column inside product table with employee table.
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="EMP_PRODUCTS")
	private Org_Employee employee;

	//Many to many relation with the product table and using 
	//joincolumn and inverse joincolumn to rename the columns of newly created table.
		
	@ManyToMany(mappedBy = "prod", fetch = FetchType.EAGER)
	private List<Department> dept;
	
	public Product() {
		super();
	}

	public Product(int id, String prod_name, Long price, Org_Employee employee) {
		super();
		this.id = id;
		this.prod_name = prod_name;
		this.price = price;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Org_Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Org_Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", prod_name=" + prod_name + ", price=" + price + ", employee=" + employee + "]";
	}
	
}

package fr.treeptik.jdbc;

import java.util.Date;



public class Employee {
	private int id;
	private String name;
	private int salary;
	private String startDate;
	private Adresse adresse = new Adresse();
	private Department department = new Department();
	private String lastName;
	private int manager_id;
	

	public Employee(){
		
	}
	

	
	public Employee(int id, String name, int salary, String startDate,
			Adresse adresse, Department department, String lastName,
			int manager_id) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.startDate = startDate;
		this.adresse = adresse;
		this.department = department;
		this.lastName = lastName;
		this.manager_id = manager_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}



	public String getStartDate() {
		return startDate;
	}



	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	

}

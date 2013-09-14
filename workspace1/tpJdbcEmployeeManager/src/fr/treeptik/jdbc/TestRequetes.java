package fr.treeptik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class TestRequetes {

	public static Employee save(Employee employee, Adresse adresse)
			throws InstantiationException, IllegalAccessException, Exception {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employee_manager", "root", "root");

		con.setAutoCommit(false);

		PreparedStatement preparedStatement1 = con
				.prepareStatement("insert into adresse (city,state,street,zip)values(?,?,?,?)");
		
		preparedStatement1.setString(1, adresse.getCity());
		System.out.println(adresse.getCity());
		
		preparedStatement1.setString(2, adresse.getState());
		System.out.println(adresse.getState());
	
		preparedStatement1.setString(3, adresse.getStreet());
		
		preparedStatement1.setString(4, adresse.getZip());

		ResultSet result = preparedStatement1.executeQuery();
		int x = result.getInt(0);

		PreparedStatement preparedStatement2 = con
				.prepareStatement("Insert Into employee(name,salary,startdate,adresse_id,department_id,lastName)"
						+ " Values(?,?,?,?,?,?)");

		preparedStatement2.setString(1, employee.getName());
		preparedStatement2.setInt(2, employee.getSalary());

		java.util.Date startDate = new java.util.Date();
		preparedStatement2.setDate(3, new java.sql.Date(startDate.getTime()));
		preparedStatement2.setInt(4, x);
		preparedStatement2.setInt(5, employee.getDepartment().getId());
		preparedStatement2.setString(6, employee.getLastName());

		preparedStatement2.executeUpdate();

		ResultSet resultSet1 = preparedStatement2.executeQuery();
		con.commit();
		con.rollback();
		return employee;
	}

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		System.out.println("\n");
		Employee employer = new Employee();
		Adresse adresse = new Adresse();
		Department departement = new Department();

		System.out.println("entrze city");
		Scanner scanner5 = new Scanner(System.in);
		String city = scanner5.nextLine();
		adresse.setCity(city);
		
		System.out.println("entrze le state");
		Scanner scanner14 = new Scanner(System.in);
		String state = scanner14.nextLine();
		adresse.setState(state);

		System.out.println("entrze le street");
		Scanner scanner6 = new Scanner(System.in);
		String street = scanner6.nextLine();
		adresse.setStreet(street);
		

	

		System.out.println("entrze zip");
		Scanner scanner7 = new Scanner(System.in);
		String zip = scanner7.nextLine();
		adresse.setZip(zip);
		
		employer.setAdresse(adresse);

		System.out.println("entrez un nom");
		Scanner scanner2 = new Scanner(System.in);
		String nom = scanner2.nextLine();
		employer.setName(nom);

		System.out.println("entrez un salaire");
		Scanner scanner3 = new Scanner(System.in);
		int salaire = Integer.parseInt(scanner3.nextLine());
		employer.setSalary(salaire);

		System.out.println("entrez une date");
		Scanner scanner4 = new Scanner(System.in);
		String date1 = scanner4.nextLine();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	//	employer.setStartDate(dateFormat.parse(date1));

		System.out.println("entrze lastName");
		Scanner scanner8 = new Scanner(System.in);
		String lastName = scanner5.nextLine();
		employer.setLastName(lastName);
		
		System.out.println("entrez un department id");
		Scanner scanner9 = new Scanner(System.in);
		int dep_id = Integer.parseInt(scanner3.nextLine());
		departement.setId(dep_id);
		employer.setDepartment(departement);
		
		save(employer,adresse);

	}
}

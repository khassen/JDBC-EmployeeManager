package fr.treeptik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class EmployeeManager {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employee_manager", "root", "root");

		con.setAutoCommit(false);
		
		try{
		PreparedStatement preparedStatement1 = con
				.prepareStatement("insert into adresse (city,state,street,zip)values(?,?,?,?)");

		preparedStatement1.setString(1, "nice");

		preparedStatement1.setString(2, "fr");

		preparedStatement1.setString(3,"place op");

		preparedStatement1.setString(4, "06000");

		preparedStatement1.executeUpdate();

	
		PreparedStatement preparedStatement3 = con
				.prepareStatement("select id from adresse where city='nice'");
		ResultSet resultSet = preparedStatement3.executeQuery();
		resultSet.next();
		int x = resultSet.getInt("id");

		PreparedStatement preparedStatement2 = con
				.prepareStatement("Insert Into employee(name,salary,startdate,adresse_id,department_id,lastName)"
						+ " Values(?,?,?,?,?,?)");

		preparedStatement2.setString(1, "lolo");
		preparedStatement2.setInt(2, 1414);


		preparedStatement2.setString(3, "12/02/2000");
		preparedStatement2.setInt(4, x);
		preparedStatement2.setInt(5, 1);
		preparedStatement2.setString(6,"lili");

		preparedStatement2.executeUpdate();

		con.commit();
		}catch(Exception e){
	System.out.println("salut");
		con.rollback();
		}

	}

}

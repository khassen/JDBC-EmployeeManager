package fr.treeptik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RechercheEmployees {

	/**
	 * @param args
	 * @throws Exception 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employee_manager", "root", "root");

		con.setAutoCommit(false);
		
		try{
		PreparedStatement preparedStatement1 = con
				.prepareStatement("select * from employee where employee.name= ?");
		preparedStatement1.setString(1, "rob");
		
		ResultSet result= preparedStatement1.executeQuery();
		
		
		while(result.next()){
			System.out.println("id : " +result.getInt("id"));
			System.out.println("name : " +result.getString("name"));
			System.out.println("salary : " +result.getInt("salary"));
			System.out.println("startDate : " +result.getString("startDate"));
			System.out.println("ad_id : " +result.getInt("adresse_id"));
			System.out.println("dep_id : " +result.getInt("department_id"));
	
			
		}

		con.commit();
		}catch(Exception e){
		con.rollback();
		}

	}

}

package fr.treeptik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SupprimerEmployee {

	public static Connection getConnectionJdbc() throws Exception,
			Exception, Exception {

		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection connection = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/employee_manager", "root", "root");
		return connection;
	}

	public static void main(String[] args) throws InstantiationException,
			IllegalAccessException, Exception {
        Connection connection = getConnectionJdbc();
		connection.setAutoCommit(false);

		try {
			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select count(adresse_id) as nombre, adresse_id from employee "
							+ "where adresse.id =(select adresse_id "
							+ "from employee where id ='id') ");
			ResultSet resultSet = preparedStatement1.executeQuery();
			resultSet.next();

			if (resultSet.getInt("nombre") > 1) {
				
				PreparedStatement preparedStatement2 = connection
						.prepareStatement("delete from employee where id = ?");
				//preparedStatement2.setInt(1, id);
				 preparedStatement2.executeUpdate();
				
			}
			
			if(resultSet.getInt("nombre")< 1 ){
				PreparedStatement preparedStatement3 = connection
						.prepareStatement("delete from employee where id = ?");
				//preparedStatement3.setInt(1, id);
				 preparedStatement3.executeUpdate();
					PreparedStatement preparedStatement4 = connection
							.prepareStatement("delete from adresse where adresse.id = ?");
					//preparedStatement4.setInt(1, id);
					 preparedStatement4.executeUpdate();
			}

			connection.commit();
		} catch (Exception e) {
			System.out.println("salut");
			connection.rollback();
		}

	}
}

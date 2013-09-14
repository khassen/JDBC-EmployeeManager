package fr.treeptik.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestJdbc {

	/**
	 * @param args
	 * @throws Exception
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, Exception {
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/annuaire","root","root");
//		PreparedStatement preparestatement = con.prepareStatement("Insert Into personne(nom,prenom,date_naissance)" +
//				" Values('alexi','marc',2000-01-02)");
		//maniere plus securisée:
		
		con.setAutoCommit(false);
		
		PreparedStatement preparestatement = con.prepareStatement("Insert Into personne(nom,prenom,date_naissance)" +
				" Values(?,?,?)");
		preparestatement.setString(1, "PersonneNom1");
		preparestatement.setString(2, "PersonnePrenom2");
		
		java.util.Date date_naissance = new java.util.Date();
		
		preparestatement.setDate(3,new java.sql.Date(date_naissance.getTime()));
		preparestatement.executeUpdate();
		
		preparestatement = con.prepareStatement("select * " +
				"from personne where nom =?");
		preparestatement.setString(1, "personneNom1");
		
		ResultSet resultSet = preparestatement.executeQuery();
		
		while (resultSet.next()) {
			System.out.println("Id : *"+resultSet.getInt("id"));
			System.out.println("Nom : *"+resultSet.getString("nom"));
			System.out.println("Prenom : *"+resultSet.getString("prenom"));
			System.out.println("Date Naissance : *"+resultSet.getDate("date_naissance"));
			
			System.out.println("*****************");
			
		}
		
		con.commit(); 
		//je l'annule de la base si il y a un probleme
		con.rollback();

	}
}

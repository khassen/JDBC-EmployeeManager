package fr.treeptik.jdbc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class TestClassTestRequetes {
	
	@Test(expected = NullPointerException.class)
	public void testSave() throws InstantiationException, IllegalAccessException, Exception {
		TestRequetes testRequete = new TestRequetes();
		
		Adresse adresse = new Adresse(1,"er","jhj","gh","yu");
		Department dep = new Department(1,"er");
		String date = "21/11/2011 16:00";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	
		Date date2 = dateFormat.parse(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date2);
	//	Employee employer = new Employee(1,"er",1221,date2,adresse,dep,"ze",2);
		
		//testRequete.save(employer, adresse);
	}

}

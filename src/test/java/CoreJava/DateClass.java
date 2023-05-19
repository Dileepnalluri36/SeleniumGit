package CoreJava;

import java.util.*;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.text.SimpleDateFormat;


public class DateClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Current Date or LocalDateTime 
		Date  d = new Date ();
		System.out.println(d.toString());
		
		//Converting Format
	SimpleDateFormat sdf = new SimpleDateFormat("mm-dd-yyyy");
	SimpleDateFormat sd = new SimpleDateFormat("EEEE");
	System.out.println(sdf.format(d));
	System.out.println(sd.format(d));
	
		//Calendars
	Calendar cal = Calendar.getInstance();
	System.out.println(sdf.format(cal.getTime()));
System.out.println(cal.get(Calendar.DAY_OF_MONTH));

	}

}

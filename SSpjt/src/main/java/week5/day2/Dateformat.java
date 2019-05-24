package week5.day2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dateformat {

	public static void main(String[] args) {
		
		//Tip: How to get tomorrow's date?

		// Get the current date
				
		Date date = new Date();
		System.out.println(date);

		// Get only the date (and not month, year, time etc)
				
		DateFormat sdf = new SimpleDateFormat("dd");
		System.out.println(sdf);
		 
		// Get today's date
				
		String today = sdf.format(date);
		System.out.println(today);

		// Convert to integer and add 1 to it
		 
		int tomorrow = Integer.parseInt(today)+1;

		// Print tomorrow's date
				
		System.out.println(tomorrow);
		

	}

}

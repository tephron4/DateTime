/**
 * Code for using the java.time.LocalDate class;
 *
 * Version 1 (Started May 4, 2020)
 * Tobias Ephron
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class dateJ1{
	Scanner s = new Scanner(System.in);

	public static void main(String[] args){
		LocalDate today = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String todayString = today.format(dtf);
		System.out.println(todayString);
	}
}
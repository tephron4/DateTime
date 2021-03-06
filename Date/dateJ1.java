/**
 * Code for using the java.time.LocalDate class;
 *
 * @version Version 1 (Started May 4, 2020)
 * @author Tobias Ephron
 */

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.Font;

public class dateJ1{

	/** 
	 * main method
	 */
	public static void main(String[] args){
		JFrame window = new JFrame("Date V1");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);
		
		LocalDate today = LocalDate.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String todayString = today.format(dtf);
		System.out.println(todayString);

		JLabel date = new JLabel(todayString,JLabel.CENTER);
		date.setFont(new Font("TimesRoman",Font.PLAIN, 32));

		window.add(date);

		window.setVisible(true);
	}
}
/**
 * Code for using the java.time.LocalDate class and updating the date with a loop;
 *
 * @version Version 2 (Started May 5, 2020)
 * @author Tobias Ephron
 */

import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.Font;

public class dateJ2{

	/** JFrame object for the clock window */
	JFrame window;
	/** JLabel object of the text of the current date */
	JLabel date;

	/**
	 * Constructor method for a dateJ2 object
	 */
	public dateJ2(){
		window = new JFrame("Date V2");
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

	/**
	 * main method
	 */
	public static void main(String[] args){
		dateJ2 d2 = new dateJ2();

		while(true){
			try{
				d2.window.remove(d2.date);
			} catch(NullPointerException e){}

			d2.date = new JLabel(LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")),JLabel.CENTER);
			d2.date.setFont(new Font("TimesRoman",Font.PLAIN,32));
			d2.window.add(d2.date);

			//System.out.println("Updated");
		}
	}
}
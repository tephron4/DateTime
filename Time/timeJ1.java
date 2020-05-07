/**
 * Code for using the java.time.LocalTime class.
 *
 * @version Version 1 (Started May 5, 2020)
 * @author Tobias Ephron
 */

import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.Font;

class timeJ1{

	/** JFrame object for the clock window */
	JFrame window;
	/** JLabel object of the text of the current time */
	JLabel time;

	/** 
	 * Constructor method for a timeJ1 object
	 */
	public timeJ1(){
		JFrame window = new JFrame("Time V1");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(400,400);

		LocalTime now = LocalTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("h:mm a");
		String nowString = now.format(dtf);
		System.out.println(now);

		JLabel time = new JLabel(nowString,JLabel.CENTER);
		time.setFont(new Font("TimesRoman",Font.PLAIN,32));

		window.add(time);

		window.setVisible(true);
	}

	/** 
	 * main method
	 */
	public static void main(String[] args){
		timeJ1 t1 = new timeJ1();
	}
}
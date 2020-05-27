/**
 * Code for using the java.time.LocalDateTime class
 *
 * @version Version 1 (Started May 6, 2020)
 * @author Tobias Ephron
 */

import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.Font;

class dtJ1{

	/** JFrame object for the clock window */
	JFrame window;
	/** JPanel object for the panel containing the date and time */
	JPanel panel;
	/** LocalDate object for the current date */
	LocalDate today;
	/** LocalTime object for the current time */
	LocalTime now;
	/** String object for the String representation of the current date */
	String todayString;
	/** String object for the String representation of the current time */
	String nowString;
	/** JLabel object of the text of the current date */
	JLabel date;
	/** JLabel object of the text of the current time */
	JLabel time;
	/** DateTimeFormatter object for the format of the date */
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, MMM d, yyyy");
	/** DateTimeFormatter object for the format of the time */
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");
	/** Font object for the date's font */
	Font dateFont = new Font("TimesRoman",Font.PLAIN,48);
	/** Font object for the time's font */
	Font timeFont = new Font("TimesRoman",Font.PLAIN,32);


	/** 
	 * Constructor method for a dtJ1 object
	 */
	public dtJ1(){
		this.window = new JFrame("Date Time V1");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(400,160);

		this.panel = new JPanel();

		this.today = LocalDate.now();
		this.todayString = today.format(dateFormat);

		this.now = LocalTime.now();
		this.nowString = now.format(timeFormat);

		date = new JLabel(this.todayString);
		date.setFont(dateFont);

		time = new JLabel(this.nowString);
		time.setFont(timeFont);

		this.panel.add(date);
		this.panel.add(time);

		this.window.getContentPane().add(panel);
		this.window.setVisible(true);
	}

	/**  
	 * main method
	 */
	public static void main(String[] args){
		dtJ1 dt = new dtJ1();

		int lastSec = dt.now.getSecond();
		int lastMin = dt.now.getMinute();
		while(true){
			dt.now = LocalTime.now();
			if(dt.now.getMinute() < lastMin){
				dt.updateDate();
				lastMin = dt.now.getMinute();
			}
			if(dt.now.getSecond() != lastSec){
				dt.updateTime();
				lastSec = dt.now.getSecond();
			}
		}
	}

	/**  
	 * Method for updating the current date displayed
	 */
	public void updateDate(){
		try{
			this.window.getContentPane().remove(panel);
			this.panel.remove(date);

			this.today = LocalDate.now();
			this.todayString = this.today.format(dateFormat);

			date = new JLabel(this.todayString);
			date.setFont(dateFont);

			this.panel.add(date);
			this.window.getContentPane().add(panel);
			this.window.revalidate();
			this.window.repaint();
			
		} catch(NullPointerException e){
			System.out.println(e);
		}
	}

	/** 
	 * Method for updating the current time displayed
	 */
	public void updateTime(){
		try{
			this.window.getContentPane().remove(panel);
			this.panel.remove(time);

			this.nowString = this.now.format(timeFormat);

			time = new JLabel(this.nowString);
			time.setFont(timeFont);

			this.panel.add(time);
			this.window.getContentPane().add(panel);
			this.window.revalidate();
			this.window.repaint();

		} catch(NullPointerException e){
			System.out.println(e);
		}
	}
}
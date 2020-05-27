/**
 * Code for using the java.time.LocalDateTime class and creating a customizable date and time window.
 *
 * @version Version 2 (Started May 6, 2020)
 * @author Tobias Ephron
 */

import java.util.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class dtJ2 implements ActionListener{

	public void actionPerformed(ActionEvent e){}

	/** JFrame object for the clock window */
	JFrame window;
	/** JPanel object for the panel containing the date and time */
	JPanel dtPanel;
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
	Font dateFont = new Font("TimesRoman",Font.PLAIN,32);
	/** Font object for the time's font */
	Font timeFont = new Font("TimesRoman",Font.PLAIN,32);

	/** String object for the date format choices */
	String[] dateFormats;
	/**  */
	JComboBox<String> dateChoices;

	/** 
	 * Constructor method for a dtJ2 object
	 */
	public dtJ2(){
		this.window = new JFrame("Date Time V1");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(600,320);

		this.dtPanel = new JPanel(new BorderLayout(5,5));

		this.today = LocalDate.now();
		this.todayString = today.format(dateFormat);

		this.now = LocalTime.now();
		this.nowString = now.format(timeFormat);

		date = new JLabel(this.todayString);
		date.setFont(dateFont);

		time = new JLabel(this.nowString);
		time.setFont(timeFont);

		this.dtPanel.add(date, BorderLayout.CENTER);
		this.dtPanel.add(time, BorderLayout.PAGE_END);

		this.dateFormats = new String[]{"Week Day, Month Day, Year" , "Month Day, Year" , "MM/dd/yyyy" , "dd/MM/yyyy" ,
							"Week Day" ,  "Month Day"};
		this.dateChoices = new JComboBox<String>(dateFormats);
		Rectangle bounds = this.dateChoices.getBounds();
		this.dateChoices.setBounds(bounds.x,bounds.y,bounds.width+20,bounds.height+20);
		this.dateChoices.setSelectedIndex(0);
		this.dateChoices.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String choice = (String)dateChoices.getSelectedItem();
				changeDateFormat(choice);
			}
		});

		this.dtPanel.add(this.dateChoices, BorderLayout.PAGE_START);

		this.window.getContentPane().add(this.dtPanel);
		this.window.setVisible(true);
	}

	/**  
	 * main method
	 */
	public static void main(String[] args){
		dtJ2 dt = new dtJ2();

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
			window.getContentPane().remove(dtPanel);
			dtPanel.remove(date);

			today = LocalDate.now();
			todayString = this.today.format(dateFormat);

			date = new JLabel(this.todayString);
			date.setFont(dateFont);

			dtPanel.add(date, BorderLayout.CENTER);
			window.getContentPane().add(dtPanel);
			window.revalidate();
			window.repaint();
			
		} catch(NullPointerException e){
			System.out.println(e);
		}
	}


	public void changeDateFormat(String format){
		switch(format){
			case "Week Day, Month Day, Year":
				dateFormat = DateTimeFormatter.ofPattern("E, MMM d, yyyy");
				updateDate();
				break;
			case "Month Day, Year":
				dateFormat = DateTimeFormatter.ofPattern("MMM d, yyyy");
				updateDate();
				break;
			case "MM/dd/yyyy":
				dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				updateDate();
				break;
			case "dd/MM/yyyy":
				dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				updateDate();
				break;
			case "Week Day":
				dateFormat = DateTimeFormatter.ofPattern("E");
				updateDate();
				break;
			case "Month Day":
				dateFormat = DateTimeFormatter.ofPattern("MMM d");
				updateDate();
				break;
			default:
				break;
		}
	}

	/** 
	 * Method for updating the current time displayed
	 */
	public void updateTime(){
		try{
			window.getContentPane().remove(dtPanel);
			dtPanel.remove(time);

			nowString = this.now.format(timeFormat);

			time = new JLabel(this.nowString);
			time.setFont(timeFont);

			dtPanel.add(time, BorderLayout.PAGE_END);
			window.getContentPane().add(dtPanel);
			window.revalidate();
			window.repaint();

		} catch(NullPointerException e){
			System.out.println(e);
		}
	}
}
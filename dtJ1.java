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

	JFrame window;
	JPanel panel;
	LocalDate today;
	LocalTime now;
	String todayString;
	String nowString;
	JLabel date;
	JLabel time;
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("E, MMM d, yyyy");
	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("h:mm a");

	Font dateFont = new Font("TimesRoman",Font.PLAIN,48);
	Font timeFont = new Font("TimesRoman",Font.PLAIN,32);

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
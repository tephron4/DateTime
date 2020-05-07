/**
 * Code for using the java.time.LocalTime class and updating the time with a loop.
 *
 * @version Version 2 (Started May 5, 2020)
 * @author Tobias Ephron
 */

import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.awt.Font;

class timeJ2{

	JFrame window;
	LocalTime now;
	String nowString;
	JLabel time;
	DateTimeFormatter dtf;

	public timeJ2(){
		this.window = new JFrame("Time V2");
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.window.setSize(400,400);

		now = LocalTime.now();
		dtf = DateTimeFormatter.ofPattern("h:mm.ss a");
		nowString = now.format(dtf);
		//System.out.println(this.nowString);

		time = new JLabel(this.nowString,JLabel.CENTER);
		time.setFont(new Font("TimesRoman",Font.PLAIN, 32));

		this.window.getContentPane().add(time);
		this.window.setVisible(true);
	}

	public static void main(String[] args){
		timeJ2 t2 = new timeJ2();

		//int i = 0;
		int lastSec = t2.now.getSecond();
		while(true){
			t2.now = LocalTime.now();
			if(t2.now.getSecond() != lastSec){
				t2.updateTime();
				lastSec = t2.now.getSecond();
				//i++;
			}
		}
	}

	public void updateTime(){
		try{
			this.window.getContentPane().remove(time);
			//System.out.println("Removed time");

			this.now = LocalTime.now();
			this.nowString = this.now.format(this.dtf);
			//System.out.println(this.nowString);

			time = new JLabel(this.nowString,JLabel.CENTER);
			time.setFont(new Font("TimesRoman",Font.PLAIN, 32));

			this.window.getContentPane().add(time);
			this.window.revalidate();
			this.window.repaint();
			//System.out.println("Added time");
		} catch(NullPointerException e){
			System.out.println("window does not contain time object");
		}
	}
}
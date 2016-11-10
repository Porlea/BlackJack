package blackJack;

import java.awt.Color;
import java.awt.Font;
import java.util.Date;
import javax.swing.JLabel;

public class Thread{
	/**
	 * 
	 */
	BlackJack bj;
	Date date = new Date();
	JLabel timeLabel = new JLabel();
	private String timer = date.toString();
	
	public Thread(Runnable runnable) {
		timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		timeLabel.setForeground(Color.BLACK);
		timeLabel.setBounds(1000,550, 100, 30);
		BlackJack.frame.add(timeLabel);
	}

	public void start() {
		
		
		timeLabel.setText(timer);
		
		
		
		
	}
	
}

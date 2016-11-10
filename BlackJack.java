package blackJack;


import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class BlackJack {

	/**
	 * 
	 */
	static ArrayList<String> cardsOnTabelForPlayer = new ArrayList<String>();
	static RandomCard rc = new RandomCard();
	static Date date = new Date();
	private static int windowWidth = 1200;
	private static int windowHeight = 600;
	static JLabel numberOfCards;
	static JButton btnRules = new JButton("Rules");
	static JLabel playerCard1 = new JLabel("playerCard1");
	static JLabel playerCard2 = new JLabel("playerCard2");
	static JLabel dealerLabel1 = new JLabel("dealerCard1");
	static JLabel dealerLabel2 = new JLabel("dealerCard2");
	static JFrame frame;
	private static int playerValue = 0;
	private int dealerValue = 0;
	private static int x = windowWidth - 450;
	private static int y = windowHeight - 330;
	private static int dealerX = windowWidth - 430;
	private static int dealerY = windowHeight - 575;
	private static final JButton btnTest = new JButton("test");
	
	static JButton startGameButton = new JButton("Start Game");		
	
	static JButton hitButton = new JButton("Hit");
	static JButton stayButton = new JButton("Stay");
	static JLabel timeDisplay = new JLabel("TimeDisplay");
	JLabel playersName = new JLabel();		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
					frame = new JFrame();
					frame.setResizable(false);
					frame.setTitle("Black Jack");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setBounds(100, 100, getWindowWidth(), getWindowHeight());
					try {
						frame.setContentPane((new JLabel(new ImageIcon(ImageIO.read(new File("pics/BlackJackBackground.png"))))));	
					} catch (IOException e) {
						e.printStackTrace();
					}
		
					stayButton.setBounds(353, 494, 89, 23);
					frame.add(stayButton);

					hitButton.setBounds(217, 494, 89, 23);
					frame.add(hitButton);
					
					btnRules.setBounds(485, 494, 89, 23);
					frame.add(btnRules);

					frame.setVisible(true);
					
		Thread thread = new Thread(null);
		thread.start();

		hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				numberOfCards = new JLabel();
				frame.add(numberOfCards);
				drawCard();
				WinOrLose(playerValue);
			}
		});
		
		btnRules.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			JOptionPane.showMessageDialog(null, "Help");	

			}
		});
	
		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			}
		});
		startGameButton.setBounds(10, 186, 75, 102);
		frame.add(startGameButton);
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTest.setBounds(158, 210, 89, 23);
		
		frame.add(btnTest);
	}
		

	/**
	 * Create the frame.
	 */
	public BlackJack() {

				
		startGame(playerValue, dealerValue);
		
		stayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				
//				rc.getRandomCard();
//				dealerValue += rc.getValueOfCard();
//				dealerLabel2.setIcon(new ImageIcon("pics/" + rc.getColorOfCard() + rc.getValueOfCard() + ".png"));
//				dealerLabel2.setBounds(370, 25, 100, 150);
//				contentPane.add(dealerLabel2);
				int counter = 0;
				while  (counter <3) {//(dealerValue <17 &&
					//numberOfCards = new JLabel();
					//contentPane.add(numberOfCards);
					dealerDrawCard();	
					counter++;
					dealerValue += rc.getValueOfCard();			
				}
				
				if (dealerValue == 21) {
					JOptionPane.showMessageDialog(null,"dealer wins");
					
				}
				
			}
		});

	}

	public static int getWindowWidth() {
		return windowWidth;
	}

	public static int getWindowHeight() {
		return windowHeight;
	}

	
	
	private static void startGame(int playerValue, int dealerValue) {
		
		cardsOnTabelForPlayer.add(rc.getRandomCard());
		
		
		playerCard1.setIcon(new ImageIcon("pics/" + rc.getColorOfCard() + rc.getValueOfCard() + ".png"));
		playerCard1.setBounds(380, 280, 100, 150);
		frame.add(playerCard1);
		
		playerValue += rc.getValueOfCard();

		cardsOnTabelForPlayer.add(rc.getRandomCard());
		playerCard2.setIcon(new ImageIcon("pics/" + rc.getColorOfCard() + rc.getValueOfCard() + ".png"));
		playerCard2.setBounds(350, 270, 100, 150);
		frame.add(playerCard2);
		
		playerValue += rc.getValueOfCard();

		rc.getRandomCard();
		dealerLabel1.setIcon(new ImageIcon("pics/" + rc.getColorOfCard() + rc.getValueOfCard() + ".png"));
		dealerLabel1.setBounds(400, 35, 100, 150);
		frame.add(dealerLabel1);
	}
	public int getPlayerValue() {
		return playerValue;
	}

	public void setPlayerValue(int playerValue) {
		this.playerValue = playerValue;
	}

	public int getDealerValue() {
		return dealerValue;
	}

	public void setDealerValue(int dealerValue) {
		this.dealerValue = dealerValue;
	}

	public int getDealerY() {
		return dealerY;
	}

	public void setDealerY(int dealerY) {
		this.dealerY = dealerY;
	}

	public int getDealerX() {
		return dealerX;
	}

	public void setDealerX(int dealerX) {
		this.dealerX = dealerX;
	}

	public static void WinOrLose(int playerValue) {
		
		if (playerValue > 21) {

			JOptionPane.showMessageDialog(null, "You got Busted");
			String answer = JOptionPane.showInputDialog("Play again? Y/N");
			if (answer.equalsIgnoreCase("y")) {
				main(null);
			} else {
				System.exit(0);
			}
		}	
	}
	public static void drawCard(){
		
		x -= 30;
		y -= 10;

		cardsOnTabelForPlayer.add(rc.getRandomCard());
		numberOfCards.setIcon(new ImageIcon("pics/" + rc.getColorOfCard() + rc.getValueOfCard() + ".png"));
		numberOfCards.setBounds(x, y, 100, 150);
		frame.add(numberOfCards);
	}
	public void dealerDrawCard(){
		dealerX += 30;
		dealerY += 10;

		cardsOnTabelForPlayer.add(rc.getRandomCard());
		numberOfCards.setIcon(new ImageIcon("pics/" + rc.getColorOfCard() + rc.getValueOfCard() + ".png"));
		numberOfCards.setBounds(x, y, 100, 150);
		//contentPane.add(numberOfCards);
	}
}

// startknappen genom att skicka till hit action. 
// MvC model view controller

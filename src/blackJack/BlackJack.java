package blackJack;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 * @author Nicklas This is the main class that is handling everything whit
 *         grafics, buttons actionLiseners and starts the game.
 */
public class BlackJack {

	static JFrame frame;
	static ArrayList<Integer> playersHand = new ArrayList<Integer>();
	static ArrayList<Integer> dealersHand = new ArrayList<Integer>();
	static ArrayList<JLabel> cardsOnTabel = new ArrayList<JLabel>();
	static PopupMessage mess = new PopupMessage();

	static Player player = new Player();
	static Betting bet;

	private static int windowWidth = 1200;
	private static int windowHeight = 600;
	static JLabel numberOfCards;
	static JLabel dealerCards;
	static JLabel score;
	static JLabel TimeDateLabel;
	static JLabel moneyLabel;
	static JLabel nameLabel;
	static JLabel dealerSecondCard;

	private static int playerValue;
	private static int dealerValue;
	private static int x = windowWidth - 820;
	private static int y = windowHeight - 280;
	private static int dealerX = windowWidth - 840;
	private static int dealerY = windowHeight - 550;
	private static int cardCounter = 0;
	static private int numberOfDecks = 2;
	static Deck deck = new Deck(numberOfDecks);

	/**
	 * main method: This method will start the game.
	 * 
	 * @param args start the game.
	 * 
	 */
	public static void main(String[] args) {
		window();
		bettingPanel();
		player.name();
		bet = new Betting();
		bet.betChoice();

	}

	// Getters and Setters

	/**
	 * Gets dealerY and return dealerY
	 * 
	 * @return dealerY gets the Y position of card
	 */
	public static int getDealerY() {
		return dealerY;
	}

	/**
	 * Sets DealerY
	 * 
	 * @param dealerY sets the Y position of card
	 */
	public static void setDealerY(int dealerY) {
		BlackJack.dealerY = dealerY;
	}

	/**
	 * Gets dealerX and return dealerX
	 * 
	 * @return dealerX gets the Y position of card
	 */
	public static int getDealerX() {
		return dealerX;
	}

	/**
	 * Sets DealerX
	 * 
	 * @param dealerX sets the Y position of card
	 */
	public static void setDealerX(int dealerX) {
		BlackJack.dealerX = dealerX;
	}

	/**
	 * Gets DealerValue
	 * 
	 * @return dealerValue gets the total handValue for the dealer
	 */
	public static int getDealerValue() {
		return dealerValue;
	}

	/**
	 * Sets the dealerValue
	 * 
	 * @param dealerValue sets the total handValue for the dealer
	 */
	public static void setDealerValue(int dealerValue) {
		BlackJack.dealerValue = dealerValue;
	}

	/**
	 * Gets the game window width
	 * 
	 * @return windowWidth gets the width of the game window
	 */
	public static int getWindowWidth() {
		return windowWidth;
	}

	/**
	 * Gets the Game window Height
	 * 
	 * @return windowHeight gets the height of the game window
	 */
	public static int getWindowHeight() {
		return windowHeight;
	}

	/**
	 * Gets the number on CardCounter
	 * 
	 * @return cardCounter gets the CardCounter and tells the program when to shuffle
	 */
	public static int getCardCounter() {
		return cardCounter;
	}

	/**
	 * Sets the cardCounter.
	 * 
	 * @param cCounter sets the CardCounter 
	 */
	public static void setCardCounter(int cCounter) {
		cardCounter = cCounter;
	}

	// Methods

	private static void bettingPanel() {
		JPanel scorePanel = new JPanel();

		scorePanel.setBounds(1000, 0, 300, 100);
		scorePanel.setLayout(null);

		moneyLabel = new JLabel();
		moneyLabel.setBounds(100, 0, 50, 30);

		nameLabel = new JLabel();
		nameLabel.setBounds(10, 0, 100, 30);

		frame.add(scorePanel);
		scorePanel.add(nameLabel);
		scorePanel.add(moneyLabel);

	}

	private static void window() {

		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Black Jack");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, getWindowWidth(), getWindowHeight());
		frame.setLocationRelativeTo(null);

		TimeDateLabel = new JLabel();
		TimeDateLabel.setBounds(1030, 450, 200, 200);

		try {

			frame.setContentPane((new JLabel(new ImageIcon(ImageIO.read(new File("pics/BlackJackBackground.png"))))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		buttons();

		frame.setVisible(true);
		frame.add(TimeDateLabel);

		SwingWorker<Void, Void> timeAndDateThread = new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				while (true) {
					try {
						TimeDateLabel.setText(TimeDate.getTime() + "  " + TimeDate.getDate());
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		timeAndDateThread.execute();
	}

	private static void buttons() {

		JButton rulesButton = new JButton("Rules");
		JButton startGameButton = new JButton("Start Game");
		JButton hitButton = new JButton("Hit");
		JButton standButton = new JButton("Stand");

		standButton.setBounds(353, 494, 89, 23);
		frame.add(standButton);

		hitButton.setBounds(217, 494, 89, 23);
		frame.add(hitButton);

		rulesButton.setBounds(485, 494, 89, 23);
		frame.add(rulesButton);

		startGameButton.setBounds(10, 186, 100, 120);
		frame.add(startGameButton);

		hitButton.setEnabled(false);
		standButton.setEnabled(false);

		rulesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mess.rulesMessage();

			}
		});

		startGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				hitButton.setEnabled(true);
				standButton.setEnabled(true);

				startButtonLogic();
				startGameButton.setEnabled(false);
			}
		});

		standButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dealerSecondCard.setVisible(false);
				if (playerValue < 21) {
					standButton.setEnabled(false);
					hitButton.setEnabled(false);

				}

				standButtonLogic();
				startGameButton.setEnabled(false);
				standButton.setEnabled(true);
				hitButton.setEnabled(true);
			}

		});

		/**
		 * It will draw a random card and and add value to players hand it will
		 * print a card
		 */

		hitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (playerValue > 21) {

					hitButton.setEnabled(false);
					standButton.setEnabled(false);
				} else {
					hitButtonLogic();

					startGameButton.setEnabled(false);
				}
				if (playerValue > 21) {

					hitButton.setEnabled(false);
					standButton.setEnabled(false);
				}
			}
		});

	}

	/**
	 * Checks if the value for the cards value is 11-13 then change it to 10 If
	 * the card value is 1 change it to 11
	 * 
	 * @param value
	 *            the value of the card.
	 * @return The new card value. Between 2-11.
	 */

	protected static int cardsBlackJackValue(int value) {

		if (value < 14 && value > 10) {
			return 10;
		} else if (value == 1) {

			return 11;
		} else {
			return value;
		}

	}

	private static void WinOrLose() {
		boolean value;
		if (playerValue > 21) {
			value = mess.bustedMessage();
			messageValue(value);
		} else if (dealerValue == 21) {
			value = mess.dealerWinMessage();
			messageValue(value);
		} else if (dealerValue > 21) {
			value = mess.playerWinMessage();
			bet.winMoney();
			messageValue(value);
		} else if (playerValue < dealerValue) {
			value = mess.dealerWinMessage();
			messageValue(value);
		} else if (playerValue == dealerValue) {
			value = mess.drawMessage();
			messageValue(value);
		} else if (dealerValue > 16 && (playerValue > dealerValue)) {
			value = mess.playerWinMessage();
			bet.winMoney();
			messageValue(value);
		}

	}

	private static void messageValue(boolean value) {
		if (!value) {
			System.exit(0);
		} else {
			bet.betChoice();
			for (JLabel l : cardsOnTabel) {
				frame.remove(l);
				frame.revalidate();
				frame.repaint();
			}
			cardsOnTabel.clear();

			restartGame();
		}
	}

	private static void restartGame() {
		x = windowWidth - 820;
		y = windowHeight - 280;
		setDealerX(windowWidth - 840);
		setDealerY(windowHeight - 550);

		cardsOnTabel.clear();
		startButtonLogic();
	}

	private static void hitButtonLogic() {

		numberOfCards = new JLabel();
		frame.add(numberOfCards);
		x -= 30;
		y -= 10;

		shufflingTime();
		numberOfCards.setIcon(new ImageIcon("pics/" + deck.drawCard() + ".png"));
		numberOfCards.setBounds(x, y, 100, 150);
		cardsOnTabel.add(numberOfCards);
		frame.add(cardsOnTabel.get(cardsOnTabel.size() - 1));

		playerValue += cardsBlackJackValue(deck.getCardValue());
		playersHand.add(cardsBlackJackValue(deck.getCardValue()));

		while (playerValue > 21) {

			for (int i = 0; i < playersHand.size(); i++) {

				if (playersHand.get(i) == 11) {

					playersHand.set(i, 1);
					playerValue = playerValue - 10;
				}
			}

			break;
		}
		WinOrLose();
	}

	private static void standButtonLogic() {

		while (dealerValue < 17) {

			dealerCards = new JLabel();
			frame.add(dealerCards);

			dealerX -= 30;
			dealerY -= 10;

			shufflingTime();
			dealerCards.setIcon(new ImageIcon("pics/" + deck.drawCard() + ".png"));
			dealerCards.setBounds(dealerX, dealerY, 100, 150);

			dealerValue += cardsBlackJackValue(deck.getCardValue());
			dealersHand.add(cardsBlackJackValue(deck.getCardValue()));
			cardsOnTabel.add(dealerCards);

			while (dealerValue > 21) {

				for (int i = 0; i < dealersHand.size(); i++) {

					if (dealersHand.get(i) == 11) {

						dealersHand.set(i, 1);
						dealerValue = dealerValue - 10;
					}

				}

				break;

			}

		}
		WinOrLose();
	}

	private static void startButtonLogic() {
		playerValue = 0;
		dealerValue = 0;

		hitButtonLogic();
		hitButtonLogic();

		dealerCards = new JLabel();
		dealerSecondCard = new JLabel();
		frame.add(dealerCards);

		shufflingTime();
		dealerCards.setIcon(new ImageIcon("pics/" + deck.drawCard() + ".png"));

		dealerCards.setBounds(getDealerX(), getDealerY(), 100, 150); // 420,35
		frame.add(dealerCards);

		setDealerValue(getDealerValue() + cardsBlackJackValue(deck.getCardValue()));

		frame.add(dealerSecondCard);
		dealerSecondCard.setIcon(new ImageIcon("pics/cardBackground.png"));
		dealerSecondCard.setBounds(getDealerX() - 30, getDealerY() - 10, 100, 150); // 400,25

		cardsOnTabel.add(dealerCards);
		cardsOnTabel.add(dealerSecondCard);

	}

	private static void shufflingTime() {
		setCardCounter(getCardCounter() + 1);

		if (getCardCounter() > (51 * numberOfDecks)) {
			mess.shuffleTime();
			deck.shuffle();
			setCardCounter(0);
		}

	}

}
package blackJack;

import java.util.ArrayList;
import java.util.Random;
import java.lang.StringBuilder;

/**
 * This class generates a deck/decks of cards. An instance of this class either
 * generates a single deck of cards (52 cards), or a deck of cards consisting of
 * multiple decks of cards (depending on which contructor is called). The cards
 * in the deck/s are represented by Strings e.g. "S10" where "S" represents
 * Spades, and "10" represents card value 10.
 * 
 * @author David
 */
public class Deck {
	private int numberOfDecks;
	private ArrayList<String> deck = new ArrayList<String>();
	private ArrayList<String> cardsInPlay = new ArrayList<String>();
	private StringBuilder card = new StringBuilder(5);
	private Random random = new Random();

	/**
	 * Default constructor sets number of decks to 1.
	 */
	public Deck() {
		numberOfDecks = 1;
		addCardsToDeck();
	}

	/**
	 * Constructor that specifies the number of decks used in a large deck of
	 * cards.
	 * 
	 * @param numberOfDecks takes and int with the number of decks.
	 */
	public Deck(int numberOfDecks) {
		if (numberOfDecks <= 0) {
			this.numberOfDecks = 1;
		} else if (numberOfDecks >= 99) {
			this.numberOfDecks = 99;
		} else {
			this.numberOfDecks = numberOfDecks;
		}
		addCardsToDeck();
	}

	/**
	 * Draws a random card from the deck. If this method is called when the deck
	 * is empty, it will throw an exception.
	 * 
	 * @return random card as a String e.g. "S10".
	 */
	public String drawCard() {
		try {
			if (deck.isEmpty()) {
				throw new EmptyDeckException();
			}
		} catch (EmptyDeckException e) {
			System.out.println(e.getMessage());
		}
		int random = getRandomInt(0, deck.size() - 1);
		card.replace(0, 6, deck.get(random));
		deck.remove(random);
		cardsInPlay.add(card.toString());
		if (Character.isDigit(card.charAt(1))) {
			return card.substring(2, card.length());
		}
		return card.substring(1, card.length());
	}

	/**
	 * Shuffles the deck.
	 */
	public void shuffle() {
		deck.clear();
		cardsInPlay.clear();
		addCardsToDeck();
	}

	/**
	 * Returns the deck as an ArrayList.
	 * 
	 * @return ArrayList with the deck.
	 */
	public ArrayList<String> getDeck() {
		return deck;
	}

	/**
	 * Returns the cards in play as an ArrayList.
	 * 
	 * @return ArrayList with the cards in play.
	 */
	public ArrayList<String> getCardsInPlay() {
		return cardsInPlay;
	}

	/**
	 * Returns the number of decks.
	 * 
	 * @return int with the number of decks.
	 */
	public int getNumberOfDecks() {
		return numberOfDecks;
	}

	/**
	 * Returns the card value (1-13) of the last drawn card.
	 * 
	 * @return int with the card value of the last drawn card.
	 */
	public int getCardValue() {
		if (card.length() == 3) {
			return Integer.parseInt(card.substring(2));
		}
		if (card.length() == 5) {
			return Integer.parseInt(card.substring(3, 5));
		}
		if (numberOfDecks < 10) {
			return Integer.parseInt(card.substring(2, 4));
		}
		return Integer.parseInt(card.substring(3));
	}

	private void addCardsToDeck() {
		char[] suits = { 'S', 'C', 'D', 'H' };
		for (int i = 0; i < suits.length; i++) {
			for (int j = 1; j <= numberOfDecks; j++) {
				for (int k = 1; k <= 13; k++) {
					card.replace(0, 6, String.valueOf(j) + suits[i] + String.valueOf(k));
					deck.add(card.toString());
				}
			}
		}
	}

	private int getRandomInt(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}

	private class EmptyDeckException extends Exception {

		private static final long serialVersionUID = 1L;

		private EmptyDeckException() {
			super("Error: Cannot draw card because the deck is empty.");
		}

	}
}

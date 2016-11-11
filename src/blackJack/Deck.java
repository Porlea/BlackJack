package blackJack;

import java.util.ArrayList;
import java.util.Random;
import java.lang.StringBuilder;

public class Deck {
	private int numberOfDecks;
	private ArrayList<String> deck = new ArrayList<String>();
	private ArrayList<String> cardsInPlay = new ArrayList<String>();
	private StringBuilder card = new StringBuilder(5);
	private Random random = new Random();

	public Deck() {
		numberOfDecks = 1;
		addCardsToDeck();
	}

	public Deck(int numberOfDecks) {
		if (numberOfDecks <= 0) {
			this.numberOfDecks = 1;
		} else if (numberOfDecks >= 20) {
			this.numberOfDecks = 20;
		} else {
			this.numberOfDecks = numberOfDecks;
		}
		addCardsToDeck();
	}
	
	public ArrayList<String> getDeck (){
		return deck;
	}
	
	public ArrayList<String> getCardsInPlay (){
		return cardsInPlay;
	}

	private void addCardsToDeck() {
		char[] suits = { 'S', 'C', 'D', 'H' };
		for (int i = 0; i < suits.length; i++) {
			for (int j = 1; j <= numberOfDecks; j++){
				for (int k = 2; k <= 14; k++) {
					card.replace(0, 6, String.valueOf(j) + suits[i] + String.valueOf(k));
					deck.add(card.toString());
				}
			}
		}
	}

	public String drawCard() {
		if (deck.isEmpty()){
			return null;
		}
		int random = getRandomInt(0, deck.size() - 1);
		card.replace(0, 6, deck.get(random));
		deck.remove(random);
		cardsInPlay.add(card.toString());
		return card.toString();
	}
	
	public void returnToDeck(String card){
		if (!deck.contains(card)){
			deck.add(card);
		}
	}
	
	public void shuffle(){
		deck.clear();
		cardsInPlay.clear();
		addCardsToDeck();
	}

	private int getRandomInt(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}
}

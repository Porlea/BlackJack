package testing;

import java.util.ArrayList;

import org.junit.Assert;

import org.junit.Test;

import blackJack.Deck;

/**
 * This class tests the deck class with Junit.
 * 
 * @author David
 *
 */
public class TestDeck {

	static Deck deck;
	static ArrayList<String> deckList;
	static ArrayList<String> cardsInPlay;

	@Test
	public void testDrawCard() {
		deck = new Deck(2);
		for (int i = 0; i < 52; i++) {
			String card = deck.drawCard();
			String card2 = deck.drawCard();
			Assert.assertNotSame(card, card2);
		}

	}

	@Test
	public void testShuffle() {
		deck = new Deck();
		deck.shuffle();
		Assert.assertTrue(deck.getCardsInPlay().isEmpty());
	}

	@Test
	public void testGetCardValue() {
		deck = new Deck();
		for (int i = 0; i < 52; i++) {
			deck.drawCard();
			Assert.assertTrue(deck.getCardValue() >= 1 && deck.getCardValue() <= 13);
		}
	}

}

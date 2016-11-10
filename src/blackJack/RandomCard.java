package blackJack;

import java.util.ArrayList;
import java.util.Random;
import java.lang.StringBuilder;

public class RandomCard {

	private static Random random = new Random();
	public static ArrayList<String> cardsPlayed = new ArrayList<String>();
	private static StringBuilder cardName = new StringBuilder();

	public static String getRandomCard() {
		if (cardsPlayed.size() >= 94) {
			cardsPlayed.clear();
		}
		cardName.delete(0, 5);
		generateRandomCard();
		checkCard();
		cardsPlayed.add(cardName.toString());
		return cardName.delete(0, 1).toString();
	}

	private static void checkCard() {
		while (cardsPlayed.contains(cardName)) {
			cardName.delete(0, 5);
			generateRandomCard();
		}
	}

	private static void generateRandomCard() {
		cardName.append(getRandomDeck()).append(getRandomCardColor()).append(getRandomCardValue());
	}

	private static char getRandomCardColor() {
		int value = getRandomInt(1, 4);

		/*
		 * H = Hearts D = Diamond C = Clubs S = Spades
		 */

		switch (value) {
		case 1:
			return 'H';
		case 2:
			return 'D';
		case 3:
			return 'C';
		case 4:
			return 'S';
		default:
			return '!';
		}
	}

	private static int getRandomCardValue() {
		return getRandomInt(1, 13);
	}

	private static int getRandomDeck() {
		int value = getRandomInt(1, 2);
		if (value == 1) {
			return 1;
		} else {
			return 1;
		}
	}

	private static int getRandomInt(int min, int max) {
		return random.nextInt(max - min + 1) + min;
	}
}

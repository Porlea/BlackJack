package blackJack;

import java.util.ArrayList;
import java.util.Random;

public class RandomCard {

	Random random = new Random();
	
	ArrayList<String> cardsInPlay = new ArrayList<String>();
	
	private String deckNumber,colorOfCard,cardName;
	private int valueOfCard;
	
	
	public String getDeckNumber() {
		return deckNumber;
	}

	public int getValueOfCard() {
		return valueOfCard;
	}

	public String getColorOfCard() {
		return colorOfCard;
	}

	public void setColorOfCard(String colorOfCard) {
		this.colorOfCard = colorOfCard;
	}

	public void setValueOfCard(int valueOfCard) {
		this.valueOfCard = valueOfCard;
	}

	public void setDeckNumber(String deckNumber) {
		this.deckNumber = deckNumber;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getRandomCard(){
		
		setDeckNumber(deck());
		setColorOfCard(cardColor());
		setValueOfCard(cardValue());
	
		setCardName(getDeckNumber()+getColorOfCard()+getValueOfCard());
		checkCard(cardName);
		
		return cardName;
}
	
	public String checkCard(String card){
		cardsInPlay.add("");
		
		for (String s : cardsInPlay) {
			System.out.println(s);
				
			if (s.equalsIgnoreCase(card)){
			}
			else {
				cardsInPlay.add(card);		
				return cardName;
				
			}
		}

		return cardName;
	}

	 private String cardColor() {
		int value = getRandomInt(1,4);
		
		/*
		 * H = Hearts 
		 * D = Diamond
		 * C = Clubs
		 * S = Spades
		 */
		
		switch (value){
		case 1:
			return "H";
		case 2:
			return "D";
		case 3:
			return "C";
		case 4:
			return "S";
		default:
			
			break;
		
		}
		
		return null;
	}

	private int cardValue() {
		int value = getRandomInt(1, 13);
		return value;
		}

	private String deck() {
		
		 int value = getRandomInt(1,2);
		 if(value == 1){
			 return "1";
		 }
		 else { 
			 return "2";
		 }
		 
	}
	 public int getRandomInt(int min,int max){
		 
		 return random.nextInt(max-min)+min;
		
	}
}

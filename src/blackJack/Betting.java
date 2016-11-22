package blackJack;
/**
 * 
 * @author Nicklas
 *	This class handles the betting
 */
public class Betting {

	Player player = new Player();
	PopupMessage mess = new PopupMessage();
	private int betValue;

	/**
	 * Here is were the betting is checking if you have enough money
	 */
	public void betChoice() {
		boolean betLoop;
		do {
			betLoop = false;
			betValue = mess.BetMessage();
			if (player.getMoney() < betValue) {
				mess.noMoneyMessage();
				int answer = mess.walkAwayMessage();
				if (answer == 0) {
					betLoop = true;
				}
			
			}
		} while (betLoop);

		player.setMoney(player.getMoney() - betValue);
		BlackJack.moneyLabel.setText(" $" + player.getMoney());

	}

	/**
	 * If the player win, this is the calculation that gives the player winning money 
	 */
	public void winMoney() {

		int totMoney = player.getMoney() + (betValue * 2);
		player.setMoney(totMoney);
		BlackJack.moneyLabel.setText(" $ " + totMoney);
	}
}
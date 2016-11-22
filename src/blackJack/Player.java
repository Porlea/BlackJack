package blackJack;

/**
 * 
 * @author Nicklas This class will hold the player name and the starting money
 *         to the player.
 */
public class Player {

	PopupMessage mess = new PopupMessage();

	private int money = 100;
	private String name;

	/**
	 * Gets the player money
	 * 
	 * @return money gets the players money
	 */
	public int getMoney() {
		return money;
	}

	/**
	 * Sets the change of players money
	 * 
	 * @param money sets the players money
	 */
	public void setMoney(int money) {
		this.money = money;
	}

	/**
	 * Here is were players name will set on the name label and the starting
	 * money
	 */
	public void name() {
		name = mess.playerNameMessage();
		
		BlackJack.nameLabel.setText(name);
		BlackJack.moneyLabel.setText(" $" + money);
	}

}

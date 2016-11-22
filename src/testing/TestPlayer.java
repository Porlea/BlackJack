package testing;
import org.junit.Assert;
import org.junit.Test;
import blackJack.Player;




/**
 * 
 * @author Andreas This class will hold the player name and the starting money
 *         to the player.
 */
public class TestPlayer {
	
	static Player player;
	
	/**
	 * Tests getting player money
	 * 
	 * 
	 */
	@Test
	public void testGetMoney(){
		player = new Player();
		int money = player.getMoney();
		
		Assert.assertEquals(100, money);
	}
	
	
	/**
	 * Tests setting player money
	 * 
	 * 
	 */
	@Test
	public void testSetMoney(){
		player = new Player();
		player.setMoney(1000);
		
		Assert.assertEquals(1000,player.getMoney());
		
	}

}

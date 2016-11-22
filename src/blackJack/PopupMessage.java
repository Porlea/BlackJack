package blackJack;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	/**
	 * PopupMessage represent a popup window with a message depending on witch button the user press.
	 * 
	 * @author andreas lindstrom
	 *
	 */
public class PopupMessage {
	
	  ImageIcon icon = new ImageIcon("pics/PopupIcon.png");
	
		
	 /**
	  * Gives a popup message when the player win.
	  * 
	  * @return true or false depending on player decision.
	  */
	 public boolean playerWinMessage() {
			Object[] options = {"Walk away",
	    						"Make another bet"};

		int choice = JOptionPane.showOptionDialog(null,
								"Great job!"
								+ "\nYou have a higher number than the dealer"
								+ "\nYou win!",
								"You Win",
								JOptionPane.YES_NO_OPTION,
								JOptionPane.QUESTION_MESSAGE,
								icon,
								options,
								options[1]);


		if (choice == JOptionPane.NO_OPTION)
		{
			//make another bet
			return true;
		}
		else if (choice == JOptionPane.YES_OPTION)
		{
			//walk away
			return false;
		}
			return false;
		}
	
	
		/**
		 * Gives a popup message when the dealer win.
		 * 
		 * @return true or false depending on player decision.
		 */
	public boolean dealerWinMessage() {
		Object[] options = {"Walk away",
    						"Make another bet"};

	int choice = JOptionPane.showOptionDialog(null,
							"The dealer have a higher number then you"
							+ "\ndealer wins.",
							"You Lost",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							icon,
							options,
							options[1]);


	if (choice == JOptionPane.NO_OPTION)
	{
		//make another bet
		return true;
	}
	else if (choice == JOptionPane.YES_OPTION)
	{
		//walk away
		return false;
	}
		return false;
	}
	
	
		/**
		 * gives a popup message when there is a draw.
		 * 
		 * @return true or false depending on player decision.
		 */
	public boolean drawMessage() {
		Object[] options = {"Walk away",
    						"Make another bet"};

	int choice = JOptionPane.showOptionDialog(null, 
							"You have the same number as the dealer"
							+ "\ndealer wins.",
							"Draw",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							icon,
							options,
							options[1]);


	if (choice == JOptionPane.NO_OPTION)
	{
		//make another bet
		return true;
	}
	else if (choice == JOptionPane.YES_OPTION)
	{
		//Walk away
		return false;
	}
		return false;
	}
	
	
	
	/**
	 * gives a popup message when the player gets busted.
	 * 
	 * @return true or false depending on player decision.
	 */
	
	public boolean bustedMessage() {
		Object[] options = {"Walk away",
    						"Make another bet"};

	int choice = JOptionPane.showOptionDialog(null, 
							" You got busted, Dealer wins!",
							"Busted",
							JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE,
							icon,
							options,
							options[1]);


	if (choice == JOptionPane.NO_OPTION)
	{
		//make another bet
		return true;
	}
	else if (choice == JOptionPane.YES_OPTION)
	{
		//Walk away
		return false;
	}
		return false;
	}
	
	
											
	/**Gives a Popup message for betting choices.
	 * 
	 * @return betting value.
	 */
	    public int BetMessage(){
    	Object[] options = {"15$",
    			"10$",
    			"5$"};
    	JOptionPane pane = new JOptionPane("Would you like too make another bet? "
    			+ "Press the buttons below.",
				JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,icon,options,options[0]);	
    	
    JDialog dialog = pane.createDialog("Title");
    dialog.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent evt) {
        }
    });
    dialog.setContentPane(pane);
    dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    dialog.pack();

    dialog.setVisible(true);
    String choice = pane.getValue().toString();
    
    if (choice.equalsIgnoreCase("15$")){
		//15$
		return 15;
	   
	  }
	else if (choice.equalsIgnoreCase("10$"))
	{
		//10$
		return 10;
	}
	else if (choice.equalsIgnoreCase("5$"))
	{
		//5$ 
		return 5;
	}
	
		return 0;
	}
	
	
	
		/**
		 * gives a popup message with rules when player press rules button.
		 */
	public void rulesMessage() {
		JOptionPane.showMessageDialog(null, " The game is to get as close to the number 21 as possible by either choosing"
											+ "\n Hit or Stand without getting busted that is if the player gets over 21."
											+ "\n And have a higher number than the dealer."
											+ "\n Blackjack is played with one or more decks of 52 cards and in this game -"
											+ "\n we will play with two decks of cards and a total of 104 playing cards."
											+ "\n  "
											+ "\n To win the game."
											+ "\n to win the game the player needs to have a higher number than the dealer but not over 21.",
											"Rules of the game.",
											JOptionPane.QUESTION_MESSAGE,
											icon );
	}
	
	/**
	 * Shows message when the player don't have enough money
	 */
	
	 public void noMoneyMessage(){
	        JOptionPane.showMessageDialog(null, "Go to Work you do not have enough money",null,JOptionPane.QUESTION_MESSAGE ,icon);
	    }
	 
	 /**
	  * gives the player a choice to walk away.
	  * 
	  * @return 0 if player choose too stay.
	  */
	    
	    public int walkAwayMessage() {
	        
	        Object[] options = {"Yes",
	                "No"};
	int choice = JOptionPane.showOptionDialog(null,
	                "Do you want to walk away? "
	                + "\nPress the buttons below.",
	                null,
	                JOptionPane.YES_NO_CANCEL_OPTION,
	                JOptionPane.QUESTION_MESSAGE,
	                icon,
	                options,
	                options[0]);
	    if (choice == JOptionPane.YES_OPTION)
	    {
	        System.exit(0);
	        return 1;
	    }
	    else 
	        return 0;
	    }
    
	    /**
	     * shows message when the deck is empty and card is shuffling.
	     * 
	     */
	    public void shuffleTime() {
	        JOptionPane.showMessageDialog(null, " Shuffling Time",null,   JOptionPane.QUESTION_MESSAGE,icon );
	        
	    }

	    /**
	     * message to input player name
	     * 
	     * @return 0 if player want to leave game.
	     */
	    public String playerNameMessage(){
	    String[] options = {"OK"};
	    JPanel panel = new JPanel();
	    JLabel lbl = new JLabel("Enter Your name: ");
	    JTextField txt = new JTextField(10);
	    panel.add(lbl);
	    panel.add(txt);
	    int selectedOption = JOptionPane.showOptionDialog(null, panel, "Player name", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon, options , options[0]);

	    if(selectedOption == 0)
	    {
	        String text = txt.getText();
	       return text;
	    }
		return null;
	    }
	    
  }
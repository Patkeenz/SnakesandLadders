// -------------------------------------------------------
// Assignment 1
// Written by: (Patrick Keenan 40175307)
// -------------------------------------------------------
/**
 * <p>Author: Patrick Keenan, Student ID: 40175307 </p>
 * <p>COMP 249 </p>
 * <p>Assignment 1 </p>
 * <p>Due Date: February 8 2021 </p>
 * <p>This class defines the player object and it's methods. It uses the LadderandSnake class.</p>
 */
public class Player { 
	private String player_name;
	private int position;
	private int dice;
	LadderandSnake board = new LadderandSnake();
	
	   /**
	    * Creates a Player object with a name and position.
	    * 
	    * @param player_name a String of the player's given name
	    * @param position an integer of the player's current position 
	    */
	public Player(String player_name, int position) { 
		this.player_name=player_name;	
		this.position = position;
		dice=0;
	}
	
	/** 
	 * Sets the player's current position.
	 * @param position integer of the player's current position
	 */
	public void setPos(int position)	{ 
		this.position=position;
	}
	
	/** 
	 * Gets the player's current position.
	 * @return an integer of the player's current position
	 */
	public int getPos() { 
		return position;
	}
	
	/**
	 * Play's the player's turn, assigning their dice value to the integer received from the flipDice method. Announces their dice value.
	 */
	public void playerTurn() {	
		this.dice = board.flipDice();
		System.out.print("- "+ player_name + " got a dice value of " + dice);
	}
	
	/**
	 * returns the dice value of the player
	 * @return the dice value of the player
	 */
	public int getDice() {
		return dice;
	}
	
	/**
	 * returns the name of the player
	 * @return the name of the player
	 */
	public String getName() {
		return player_name;
	}
	
}

// -------------------------------------------------------
// Assignment 1
// Question: Part 2
// Written by: (Patrick Keenan 40175307)
// -------------------------------------------------------
/**
 * <p>Author: Patrick Keenan, Student ID: 40175307 </p>
 * <p>COMP 249 </p>
 * <p>Assignment 1 </p>
 * <p>Due Date: February 8 2021 </p>
 * <p>This class uses all the methods from the LadderandSnake class required in order to setup and play a game of LadderandSnake 
 *  that follows the directions specified in COMP 249 assignment 1's instructions. It also uses the Player object.</p>
 */
public class PlayLadderandSnake {	
	
	public static void main (String[] args) {
		LadderandSnake start_board = new LadderandSnake(); //create null board to be able to call playerAmount
		int player_amount = start_board.playerAmount(); //set player amount
		LadderandSnake board = new LadderandSnake(player_amount); //creates board with player amount as a parameter
	 	Player[] unset_players = board.createPlayers(player_amount); //create initial array of players that are not ordered
		System.out.println("- Now deciding which player will start playing;");
		Player[] players = board.orderedPlayers(unset_players); //orders players into an array based on their first rolls
		System.out.print("- Reached final decision on order of playing: "); //prints out order of players
		for(int i=0; i<players.length; i++) {
		System.out.print(players[i].getName());
		if (i<players.length-1) {
			System.out.print(", ");
		}
		if (i==players.length-1) {
			System.out.print(". ");
		}
		}
		System.out.println("");
		board.play(players); //board uses play method to play the game with the ordered array of players
	}
}

// -------------------------------------------------------
// Assignment 1
// Question: Part 1
// Written by: (Patrick Keenan 40175307)
// -------------------------------------------------------

import java.util.Scanner;
/**
 * <p>Author: Patrick Keenan, Student ID: 40175307 </p>
 * <p>COMP 249 </p>
 * <p>Assignment 1 </p>
 * <p>Due Date: February 8 2021 </p>
 * <p>This class defines the LadderandSnake object and contains all of the methods needed to play a game of LadderandSnake using
 *   the PlayLadderandSnake driver class and the Player class.</p>
 */
public class LadderandSnake {
			   private int row=10;
			   private int column=10;
			   private int [][] board;
			   private int [][] snakes; 
			   private int [][] ladders;
			   private int player_amount;
			   private Player[] unset_players;
			   private Player[] rankings;
			
			   /**
			    * Creates a 10x10 board used to set the player amount through the createPlayer method
			    */
			   public LadderandSnake() { //default constructor
				   board = new int[10][10];
			       for (int i = 0; i < row; i++) {
			           for (int j = 0; j < column; j++) {
			               board[i][j] = i*row + column +1;
			           }
			       }
			   }
			   /**
			   * Creates a 10x10 board with a certain player amount, sets the positions of the snakes and ladders
			   * 
			   * @param player_amount an integer value that represents the amount of players playing the game
			   */
			   public LadderandSnake(int player_amount) { //constructor with player amount as a parameter
				   System.out.println("- Game is played by "+player_amount+" players;"); //let user know how many players are in the game
				   board = new int[10][10];
			       for (int i = 0; i < row; i++) { //create board from 1 to 100
			          for (int j = 0; j < column; j++) {
			               board[i][j] = i*row + j +1;
			           }
			       }
			       setSnakes(); //set snakes
			       setLadders(); //set ladders
			   }
			   
			   /**
			   * Generates a random integer value from 1 to 6 to be used as a player's dice roll
			   * @return the random value as an integer
			   */
			public int flipDice() {
				return(int) (Math.random() * (6)+1);
			   }
			
			   /**
			   * Creates an array for 8 snakes including their start and end positions which will be used to detect
			   * if a player has landed on a snake 
			   */
			   public void setSnakes() {//sets the snakes on the board
				   snakes = new int [8][2]; //initializes an array of 8 snakes with a beginning and an end
				   snakes[0][0]= 16; //first variable of the array marks which snake it is (ex:snake#1) and second variable marks where the 
				   snakes[0][1]= 6;// beginning[0] and end[1] of the snake is, the final number is the snake's location on the board
				   snakes[1][0]= 48;
				   snakes[1][1]= 30;
				   snakes[2][0]= 64;
				   snakes[2][1]= 60;
				   snakes[3][0]= 79;
				   snakes[3][1]= 19;
				   snakes[4][0]= 93;
				   snakes[4][1]= 68;
				   snakes[5][0]= 95;
				   snakes[5][1]= 24;
				   snakes[6][0]= 97;
				   snakes[6][1]= 76;
				   snakes[7][0]= 98;
				   snakes[7][1]= 78;
			   }
			   /**
			   * Creates an array for 9 ladders including their start and end positions which will be used to detect
			   * if a player has landed on a ladder 
			   */
			   public void setLadders() {//sets the ladders on the board
				   ladders = new int [9][2]; //initializes an array of 9 ladders with a beginning and an end
				   ladders[0][0]= 1;
				   ladders[0][1]= 38;
				   ladders[1][0]= 4;
				   ladders[1][1]= 14;
				   ladders[2][0]= 9;
				   ladders[2][1]= 31;
				   ladders[3][0]= 21;
				   ladders[3][1]= 42;
				   ladders[4][0]= 28;
				   ladders[4][1]= 84;
				   ladders[5][0]= 36;
				   ladders[5][1]= 44;
				   ladders[6][0]= 51;
				   ladders[6][1]= 67;
				   ladders[7][0]= 71;
				   ladders[7][1]= 91;
				   ladders[8][0]= 80;
				   ladders[8][1]= 100;
			   }
			   
			   /**
			   * Demands the user to set the amount of players to a value between 2 and 4. If the player tries to set
			   * the amount of players to a different value four times, the system exits. 
			   * 
			   * @return an integer representing the amount of players in the current game
			   */
			   public int playerAmount() { //makes the user choose the amount of players the game will have
				Scanner user = new Scanner (System.in);
				System.out.println("Welcome to Ladders and Snakes");
				int player_amount=0;
				int attempts=1;
				System.out.print("Enter the # of players for your game - Number must be between 2 and 4 inclusively:");
				while (player_amount<2 || player_amount>4) {//if the player amount is between 2 and 4 the player_amount is returned
					player_amount = user.nextInt();
					if (player_amount<2 || player_amount>4) {
						System.out.print("Bad Attempt "+attempts+" - Invalid # of players. Please enter a # between 2 and 4 inclusively:");
						if (attempts >=4) {
							System.out.println("Bad Attempt 4! You have exhausted all your chances. Program will terminate.");
							System.exit(0); //if the user does not write an appropriate amount of players within 4 attempts the program terminates.
						}
						attempts++;
					}
				}
				return player_amount;
			   }
			   
			   /**
			   * Creates an array of Players of a certain size, while prompting the user to give a name for each player
			   * 
			   * @param player_amount an integer that decides the size of the array
			   * @return an array of players with assigned names
			   */
			   public Player[] createPlayers(int player_amount) {
				   Scanner user = new Scanner (System.in);
				   String player_name = "";
			 	    Player[]unset_players = new Player[player_amount];
					System.out.print("- Enter the name of the " +player_amount+ " players: ");
					for (int i=0; i<player_amount; i++) { //create a certain amount of players equal to the player amount declared by the user
						System.out.println("");
						player_name = user.next();
						Player player = new Player(player_name, 1);
						unset_players[i]=player;
					}	
					user.close();
					return unset_players;
			   }
			   
			   /**
			   * Advances a player from their position by the amount that they rolled in their current turn. 
			   * If the player is at 100 but has not finished advancing they move back the amount of steps they had left. 
			   * If the player lands on 100 it announces that the player is in square 100 and the method returns true. 
			   * If the player is below 100, the method checks if they landed on the beginning of a snake or ladder and 
			   * brings them to the end of that snake or ladder if they landed on it. The player's position is then set 
			   * and the method returns false.
			   * 
			   * @param player the current player that is taking their turn, their position and dice roll is used
			   * @return a boolean that is true if the game is done, otherwise it is false
			   */
			   public boolean move(Player player) {//decides where the player ends up and if they won or not
				   int position = player.getPos();
				   int dice = player.getDice();
				   position = position+dice;
				 
				   if (position==100) {//returns true if the player landed on 100 exactly
					   player.setPos(100);
					   System.out.print("; now in square 100");
					   return true;
				   }
				   else { 
					   if (position>100){//makes the player go back however many moves they had left from 100 if they rolled over 100
					   int new_position = (100-(position-100));
					   position = new_position;
					   }
					   if (position<100) {
					   for (int snake_spot=0; snake_spot<8; snake_spot++) { //check every snake spot to see if the player landed on a snake
						   if (snakes[snake_spot][0]==position) { //if the player landed on a snake, move them down the snake
							   position = snakes[snake_spot][1];
							   player.setPos(position);
							   System.out.println("; gone to square " + snakes[snake_spot][0] + " then down to square "+snakes[snake_spot][1]);
							   return false;
						   }
					   }
					   for (int ladder_spot=0; ladder_spot<8; ladder_spot++) { //check every ladder spot to see if the player landed on a ladder
						   if (ladders[ladder_spot][0]==position) { //if the player landed on a ladder, move them up the ladder
							   position = ladders[ladder_spot][1];
							   player.setPos(position);
							   System.out.println("; gone to square " + ladders[ladder_spot][0] + " then up to square "+ladders[ladder_spot][1]);
							   return false;
						   }
					   }
					   }
					      player.setPos(position); //set the player's position to where they moved to if they did not land on a snake or ladder
						  System.out.println("; now in square " +position); 
						  return false;	   
				   }
			   }

			   /**
			    * Plays the game. Goes through the ordered array of players one player at a time making the current
			    * player take their turn and move from their current position. If the game is finished the winner is
			    * announced. Otherwise, if all players have made a turn, it is announced that the game has not finished.
			    * The process then repeats.
			    * 
			    * @param players the array of players created after they all rolled to see who starts first
			    */
			   public void play(Player[]players) { //plays the game
					boolean finished = false; 
					int turns_taken = 0; 
					while (!finished) { //while the game is not finished, player's take their turns
						Player currentPlayer = players[turns_taken]; //current player takes their turn
						currentPlayer.playerTurn(); //the player takes a turn
						finished = move(currentPlayer); //update the board for the current player with the dice roll they just got
						if (finished) { //if the player won, announce it and exit system
							System.out.println(" ");
							System.out.println("- " +currentPlayer.getName() + " won the game! Congratulations!");
							System.exit(0);
						}
						turns_taken++;
						if (turns_taken==players.length) {
							System.out.println("- Games not over; flipping again");
							turns_taken=0;
						}
					}
			   }
			 
			   /**
			    * Takes an array of type Player and makes each Player roll the dice and orders them from highest to lowest roll. 
			    * Ties will be broken by having the tied players reroll and see who gets the higher roll. 
			    * 
			    * @param unset_players Player array that contains the players in the game, in no specific order
			    * @return an array of type Player with the Players in the order of highest to lowest rolls. 
			    */
			   public Player[] orderedPlayers(Player[]unset_players) {
				   final int length = unset_players.length; //sets final integer to keep the total amount of players needed in the returned array
				   Player [] rankings = new Player[0]; //initializes the rankings array which will be the returned array of this method
				   for (int i=0; i<unset_players.length; i++) {
					   Player current_player = unset_players[i]; //roll for each player that isn't ranked yet 
					   current_player.playerTurn();		   
					   System.out.println("");
				   }
				   while(unset_players.length!=0){
					   Player [] ties = new Player[0]; //initialize ties array that stores the ties
					   int highest=0;
					   Player highest_player=unset_players[0]; 
					   for (int i=0; i<unset_players.length; i++) {
						   Player current_player = unset_players[i];
						   Player error_solver1 = new Player("solver1", 0); //creates a Player to solve an error
						   Player error_solver2 = new Player("solver2", 0);//creates another player to solve the error
						   if (unset_players.length>2 && i<2) { //if there is more than two unset players and i is less than the third player in the array, make error_solver1 the next player in the unset_players array
						   error_solver1 = unset_players[i+1];
						   }
						   if (unset_players.length>3 && i<2) {//if there is more than three unset players and is less than the third player in the array, make error_solver2 the next next player in the unset_players array
						   error_solver2 = unset_players[i+2];
					       }
						   if(current_player.getDice()>highest) { //maximum function to detect which player had the highest roll for the current turn
							   highest_player = current_player; 
							   highest=current_player.getDice();
						   }
						   else if (current_player.getDice()==highest&& current_player.getDice()>=error_solver1.getDice() && current_player.getDice()>=error_solver2.getDice()) {//check if the current roll is tied for current highest and if any of the next players rolls are higher than the current roll
							   if (ties.length==0) { //if the current player is tied with the highest rolling player create an array with both to store the tie
								   Player [] highestcurrent = new Player[2];
								   highestcurrent[0]=current_player;
								   highestcurrent[1]=highest_player;
								   System.out.println("- A tie was achieved between "+highestcurrent[1].getName()+ " and "+highestcurrent[0].getName()+". Attempting to break the tie");
								   ties = highestcurrent; //assign the array with the two highest rolling players to the repeats player array
							   }
							   else { //if two players are tied already, add this player to the ties array
								   Player [] add = new Player[1];
								   add[0] = current_player; //create array for the player being added
								   Player []tie_add = new Player[ties.length+1]; //create storage array to store the addition ties and addition
								   System.arraycopy(ties, 0, tie_add, 0, ties.length); //put the ties into the storage array
								   System.arraycopy(add, 0, tie_add, ties.length, 1); //put add at the end of the storage array
								   ties=tie_add; //update ties array
								   
								   if (ties.length==3) {
									   System.out.println("- A 3-way tie was achieved between " + ties[1].getName() +", "+ ties[0].getName() + ", and "+ ties[2].getName() + ". Attempting to break the tie");
								   }
								   if (ties.length==4) {
									   System.out.println("- A 4-way tie was achieved between " + ties[1].getName() +", "+ ties[0].getName() + ", "+ ties[2].getName() + ", and "+ ties[3].getName() + ". Attempting to break the tie");
								   }
							   }
							   
						   }
						   
					   }
					   if (ties.length==0) {//remove highest_player from unset_players and add highest_player to the end of rankings if there was no tie
						   Player[] unset_storage = new Player[unset_players.length-1]; //create an array to store the new unset_players (one less)
						   for(int i=0; i<unset_players.length; i++) { //the highest player is removed from the unset_players array
							   if (unset_players[i] == highest_player) { 
								   System.arraycopy(unset_players, 0, unset_storage, 0, i); //puts everything that comes before the current player into the storage array
								   System.arraycopy(unset_players, i+1, unset_storage, i, (unset_players.length -(i+1))); //puts everything that comes after the current player into the storage array
							   }
						   }
						   Player [] addition = new Player[1]; //intializes an array of one value to store the current highest rolling player in
						   addition[0] = highest_player;  //assigns highest rolling player to the array
						   Player[] rankings_storage = new Player[rankings.length+1]; //create an array to store the new rankings (one more)
						   for(int i=0;i<rankings.length;i++) {
							   rankings_storage[i]=rankings[i]; //put the current rankings into the respective storage array
						   }
						   System.arraycopy(addition, 0, rankings_storage, rankings.length, (1)); //add the current highest rolling player's array to the storage array
						   rankings = rankings_storage; //assign the new rankings values to the  rankings array
						  unset_players = unset_storage; //assign the new unset players to the unset_players array
					   }
					   else {
						   Player [] tiebreaker = orderedPlayers(ties); //assigns the tiebreaker array to the ties that are now being ordered
						   Player[] rankings_storage = new Player[rankings.length+tiebreaker.length]; //makes an array to store the rankings and the ordered ties
						   System.arraycopy(rankings, 0, rankings_storage, 0, rankings.length);// adds the rankings to the rankings storage array
						   System.arraycopy(tiebreaker, 0, rankings_storage, rankings.length, tiebreaker.length); //adds the ordered tie to the rankings storage array
							  rankings = rankings_storage; //assigns the new rankings values to the  rankings array
							  
						  Player[] unset_storage = new Player[unset_players.length-1]; //creates an array to store the new amount of unset players 
					      Player tied_player1 = ties[0]; //tied player 1 is the first player in ties
							    for (int i=0; i<unset_players.length; i++) {//for each unset player, check if they were the first one that was tied
							    	if (unset_players[i] == tied_player1){//removes the first tied player from the unset players array
								   System.arraycopy(unset_players, 0, unset_storage, 0, i);//puts everything that comes before the tied player into the unset storage array
								   System.arraycopy(unset_players, i+1, unset_storage, i, (unset_players.length -(i+1)));//puts everything that comes after the first tied player into the unset storage array					   	
									unset_players=unset_storage; //updates the unset_players array
							   } 
							    }
						   Player []ties_storage = new Player [ties.length-1]; //creates an array to store the new ties array
							   	for(int i=0; i<ties.length; i++) { //the first tied player is removed from the ties array
								   if (ties[i] == tied_player1) { 
									   System.arraycopy(ties, 0, ties_storage, 0, i); //puts everything that comes before the first tied player into the ties storage array
									   System.arraycopy(ties, i+1, ties_storage, i, (ties.length -(i+1))); //puts everything that comes after the first tied player into the ties storage array
									   ties = ties_storage; //updates the ties array
								   }
							   }
						 
						   Player tied_player2 = ties[0];//tied player 2 is the second player in ties, now the first player in the array
						   Player[] unset_storage2 = new Player[unset_players.length-1]; //creates an array to store the updated amount of unset_players
							    for (int i=0; i<unset_players.length; i++) {//for each unset player, check if they were the second one that was tied
							    	if (unset_players[i] == tied_player2){//removes the second tied player from the unset players array
								   System.arraycopy(unset_players, 0, unset_storage2, 0, i);//puts everything that comes before the second tied player into the unset_storage2 array
								   System.arraycopy(unset_players, i+1, unset_storage2, i, (unset_players.length -(i+1)));//puts everything that comes after the second tied player into the unset_storage2 array					   	
									unset_players=unset_storage2;//updates the unset_players array
							   } 
							    }
						    Player []ties_storage2 = new Player [ties.length-1]; //creates an array to store the new ties array
								for(int i=0; i<ties.length; i++) { //the second tied player is removed from the ties array
									   if (ties[i] == tied_player2) { 
										   System.arraycopy(ties, 0, ties_storage2, 0, i); //puts everything that comes before the second tied player into the ties storage array
										   System.arraycopy(ties, i+1, ties_storage2, i, (ties.length -(i+1))); //puts everything that comes after the second tied player into the ties storage array
										   ties = ties_storage2; //updates the ties array
									   }
								   }
							 if (ties.length>0) { //if there was a 3-way or 4-way tie, proceed
								   Player tied_player3 = ties[0];//tied player 3 is the third player in ties, now the first player in the array
								   Player[] unset_storage3 = new Player[unset_players.length-1]; //creates an array to store the updated amount of unset_players
									    for (int i=0; i<unset_players.length; i++) {//for each unset player, check if they were the third one that was tied
									    	if (unset_players[i] == tied_player3){//removes the third tied player from the unset players array
										   System.arraycopy(unset_players, 0, unset_storage3, 0, i);//puts everything that comes before the third tied player into the unset_storage3 array
										   System.arraycopy(unset_players, i+1, unset_storage3, i, (unset_players.length -(i+1)));//puts everything that comes after the third tied player into the unset_storage3 array					   	
											unset_players=unset_storage3;//updates the unset_players array
									   } 
									    }
								    Player []ties_storage3 = new Player [ties.length-1]; //creates an array to store the new ties array
										for(int i=0; i<ties.length; i++) { //the third tied player is removed from the ties array
											   if (ties[i] == tied_player2) { 
												   System.arraycopy(ties, 0, ties_storage3, 0, i); //puts everything that comes before the third tied player into the ties storage array
												   System.arraycopy(ties, i+1, ties_storage3, i, (ties.length -(i+1))); //puts everything that comes after the third tied player into the ties storage array
												   ties = ties_storage3; //updates the ties array
											   }
										   }
										if (ties.length>0) {
											   Player tied_player4 = ties[0];//tied player 4 is the fourth player in ties, now the fourth player in the array
											   Player[] unset_storage4 = new Player[unset_players.length]; //creates an array to store the updated amount of unset_players ***-1
												    for (int i=0; i<unset_players.length; i++) {//for each unset player, check if they were the fourth one that was tied
												    	if (unset_players[i] == tied_player4){//removes the fourth tied player from the unset players array
													   System.arraycopy(unset_players, 0, unset_storage4, 0, i);//puts everything that comes before the fourth tied player into the unset_storage2 array
													   System.arraycopy(unset_players, i+1, unset_storage4, i, (unset_players.length -(i+1)));//puts everything that comes after the fourth tied player into the unset_storage2 array					   	
														unset_players=unset_storage4;//updates the unset_players array
												   } 
												    }
											    Player []ties_storage4 = new Player [ties.length-1]; //creates an array to store the new ties array
													for(int i=0; i<ties.length; i++) { //the fourth tied player is removed from the ties array
														   if (ties[i] == tied_player2) { 
															   System.arraycopy(ties, 0, ties_storage4, 0, i); //puts everything that comes before the fourth tied player into the ties storage array
															   System.arraycopy(ties, i+1, ties_storage4, i, (ties.length -(i+1))); //puts everything that comes after the fourth tied player into the ties storage array
															   ties = ties_storage4; //updates the ties array
														   }
													   }
											
										}
							 }
								   Player []ties_storageclear = new Player [0]; //creates an updated array to clear the ties array
								   ties=ties_storageclear; //sets the ties array to empty
					   }
					   }
				   	Player[]rankings_finalstorage = new Player[length]; //fixes a problem encountered with 4 way ties where the rankings array would come out in the right order but would have a length of 5 instead of 4
				   	System.arraycopy(rankings, 0, rankings_finalstorage, 0, length); //rankings_finalstorage stores the rankings of the players, but only up to the length equal to the set amount of players 
				   	rankings=rankings_finalstorage; //updates the rankings array
					return rankings;
				   }
			   
}


   


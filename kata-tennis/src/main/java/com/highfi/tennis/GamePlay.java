package com.highfi.tennis;

import com.highfi.tennis.player.Player;
import com.highfi.tennis.services.GameService;
import com.highfi.tennis.services.GameServiceImpl;
import com.highfi.tennis.utils.GameMessage;
import com.highfi.tennis.utils.GamePlayerPosition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class GamePlay {
	
	/**
	 * 
	 * Class main of KATA TENNIS
	 * Last  @Version : V3.0
	 * Other @Version : V1.1, V1.2, V2.0
	 * 
	 * @since Saturday 08 July 2017 AT 03h00 PM.
	 * @author Mohamed ABARCHID
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		Boolean isNotGameOver = Boolean.TRUE;
		/** From here. We decided to fix Player 1 is in the first  Position. */
		Player player1 = new Player(GamePlayerPosition.FIRST_POSITION);
		/** From here. We decided to fix Player 2 is in the second Position. */
		Player player2 = new Player(GamePlayerPosition.SECONDE_POSITION);
		/** Player1 is the name of the first  Player.*/
		player1.setName(GameMessage.PLAYER_1);
		/** Player2 is the name of the second Player. */
		player2.setName(GameMessage.PLAYER_2);
		
		/** Object LIST used to fix the order of the tow players already created above */
		final List<Player> listPlayers = new ArrayList<>();
		listPlayers.add(player1);
		listPlayers.add(player2);
		

		/**
		 * FROM HERE A TENNIS MATCHE IS LAUNCHED/RUNNING
		 */
		GameService gameService = new GameServiceImpl();

		try {
			BufferedReader playerScoring = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("------------START----------");
			while (isNotGameOver) {
				System.out.println("Player  1 : "+player1.getName());
				System.out.println("Player  2 : "+player2.getName());
				System.out.println("Score : "+gameService.displayOldScores() + gameService.displayCurrentScores());
				System.out.println("Current game status : " + GameMessage.gameStatus.toString());
				System.out.println("Match Status : " + GameMessage.matchStatus.toString());
	        	if(gameService.isGameOver(listPlayers)) {
	    			System.out.println("-------------END----------");
	        		return;
	        	}
                System.out.print("Enter 'a' if Player 1 scrors or any other key if Player 2 scrors : ");
                /** Response of the user launching the program */
                String inputedResult = playerScoring.readLine();
                gameService.determineWinnerAndLooser(listPlayers, inputedResult);
	        	GamePlayerPosition winnerPosition = gameService.getWinnerPosition(listPlayers);
	        	GamePlayerPosition looserPosition = gameService.getLooserPosition(listPlayers);

	        	gameService.updateMatchState(listPlayers, winnerPosition.getFixedPosition(), looserPosition.getFixedPosition());
				System.out.println("\n\n\n\n\n");
			}
		} catch (Exception e) {
			throw new Exception(e);// TASK TO DO : Implement TechnicalExceptions Later.
		}	 
	}
}
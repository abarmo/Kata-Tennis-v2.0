package com.highfi.tennis.player;

import com.highfi.tennis.utils.GamePlayerPosition;

/**
 * Object Class Representing a Player with all his necessary parameters.
 * 
 * @since Saturday 08 July 2017 AT 03h00 PM.
 * @author Mohamed ABARCHIDS
 *
 */
public class Player {
	
	/** Name to recognize the player */
	private String name;            
	
	/** 1 Score = 10, 30, 40 Points or An Advantage*/
	private int scores;
	
	/** 1 Games = 40 scores + 1 point or An Advantage + 1 Point*/
	private int games;
	
	/** 1 Set = 6 Games : 1, 2, 3, 4, 5, 6 or 7 Games */
	private int sets;         
	
	/** True , or False, if it is already True so, a Set is wan when 
	 * the Player Scores again while he have Advantage=True*/
	private boolean advantage;
	
	/** If a player have more than 3 Sets, he wins the complete Match*/
	private boolean matcheWinner;
	
	/** Determine if the Player scores, which means we have decided that a Player scores.
	 *  If the variable Wins is true, this Player scores if not the other player obligatory scores */
	private boolean wins;
	
	/** Fix the position of this player in the beginning of the Tennis part until the end of the part.
	 *  Which means fix it in all the execution of the Program*/
	private final GamePlayerPosition fixedPosition;

	
	public Player(GamePlayerPosition order) {
		this.fixedPosition     = order;
	}
	
	public Player(String name, int scores, int games, int sets, boolean advantage, int match, boolean matcheWinner, GamePlayerPosition order) {
		this.name          = name;
		this.scores        = scores;
		this.games         = games;
		this.sets          = sets;
		this.advantage     = advantage;
		this.matcheWinner  = matcheWinner;
		this.fixedPosition = order;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScores() {
		return scores;
	}

	public void setScores(int score) {
		this.scores = score;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}

	public int getSets() {
		return sets;
	}

	public void setSets(int set) {
		this.sets = set;
	}

	public boolean hasAdvantage() {
		return advantage;
	}

	public void setAdvantage(boolean advantage) {
		this.advantage = advantage;
	}

	public boolean isMatcheWinner() {
		return matcheWinner;
	}

	public void setMatcheWinner(boolean matcheWinner) {
		this.matcheWinner = matcheWinner;
	}

	public boolean isWins() {
		return wins;
	}

	public void setWins(boolean wins) {
		this.wins = wins;
	}

	public GamePlayerPosition getGamePlayerPosition() {
		return fixedPosition;
	}
}
package game;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class representing the players of the memory game.
 * 
 * @author Gyákon Jácint
 * 
 */
public class Player {
	
	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(Player.class);
	
	/**
	 * Name of the Player.
	 */
	private String name = "";

	/**
	 * Number of the player's guesses.
	 */
	private int numberOfGuesses = 0;

	/**
	 * Number of the player's pairs.
	 */
	private int numberOfPairs = 0;

	/**
	 * Indicates whether it is this players turn.
	 */
	private boolean myTurn = true;

	/**
	 * Number of the player's wins.
	 */
	private int win = 0;

	/**
	 * Number of the player's ties.
	 */
	private int tie = 0;

	/**
	 * Number of the player's loses.
	 */
	private int lose = 0;

	/**
	 * Constructor for creating a {@code Player} object.
	 * 
	 * @param name
	 *            the name of this player
	 */
	public Player(String name) {
		super();
		this.name = name;
		logger.info("The player: {} is set.",this.name);
	}

	/**
	 * Returns the win of this player.
	 * 
	 * @return the win of this player
	 */
	public int getWin() {
		return win;
	}

	/**
	 * Sets the win of this player.
	 * 
	 * @param win
	 *            the win of this player
	 */
	public void setWin(int win) {
		this.win = win;
	}

	/**
	 * Returns the tie of this player.
	 * 
	 * @return the tie of this player
	 */
	public int getTie() {
		return tie;
	}

	/**
	 * Sets the tie of this player.
	 * 
	 * @param tie
	 *            the tie of this player
	 */
	public void setTie(int tie) {
		this.tie = tie;
	}

	/**
	 * Returns the lose of this player.
	 * 
	 * @return the lose of this player
	 */
	public int getLose() {
		return lose;
	}

	/**
	 * Sets the lose of this player.
	 * 
	 * @param lose
	 *            the lose of this player
	 */
	public void setLose(int lose) {
		this.lose = lose;
	}

	/**
	 * Returns the name of this player.
	 * 
	 * @return the name of this player
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the numberOfGuesses of this player.
	 * 
	 * @return the numberOfGuesses of this player
	 */
	public int getNumberOfGuesses() {
		return numberOfGuesses;
	}

	/**
	 * Sets the numberOfGuesses of this player.
	 * 
	 * @param numberOfGuesses
	 *            the numberOfGuesses of this player
	 */
	public void setNumberOfGuesses(int numberOfGuesses) {
		this.numberOfGuesses = numberOfGuesses;
	}

	/**
	 * Returns the numberOfPairs of this player.
	 * 
	 * @return the numberOfPairs of this player
	 */
	public int getNumberOfPairs() {
		return numberOfPairs;
	}

	/**
	 * Sets the numberOfPairs of this player.
	 * 
	 * @param numberOfPairs
	 *            the numberOfPairs of this player
	 */
	public void setNumberOfPairs(int numberOfPairs) {
		this.numberOfPairs = numberOfPairs;
	}

	/**
	 * Returns <code>true</code> if it is this player's turn, <code>false</code>
	 * otherwise.
	 * 
	 * @return <code>true</code> if it is this player's turn, <code>false</code>
	 * otherwise
	 */
	public boolean isMyTurn() {
		return myTurn;
	}

	/**
	 * Sets the myTurn of the player.
	 * 
	 * @param myTurn
	 *            the myTurn of the player
	 */
	public void setMyTurn(boolean myTurn) {
		this.myTurn = myTurn;
	}

	/**
	 * Returns a hash code value for this object.
	 * 
	 * @return a hash code value for this object
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/**
	 * Compares this event with the specified object for equality. Two
	 * {@code Event} objects are considered equal if and only if their names are equal.
	 * 
	 * @param obj
	 *            the object to compare to
	 * @return <code>true</code> if the objects are equal, <code>false</code>
	 *         otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

}

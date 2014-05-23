package game;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class compares two {@code Player} object in singleplayer mode.
 * 
 * @author Gyákon Jácint
 * 
 */
public class PlayerComparatorSingle implements Comparator<Player> {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(PlayerComparatorSingle.class);
	
	/**
	 * Compares its two arguments for order.
	 * 
	 * @param o1
	 *            the first object to be compared
	 * @param o2
	 *            the second object to be compared
	 * @return a negative integer, zero, or a positive integer as the first
	 *         argument is less than, equal to, or greater than the second
	 */
	public int compare(Player o1, Player o2) {
		logger.info("Comparing the players.");
		if(o1.getNumberOfGuesses() > o2.getNumberOfGuesses()){
			return 1;
		} else if(o1.getNumberOfGuesses() < o2.getNumberOfGuesses()){
			return -1;
		} else {
			return 0;
		}
	}


}

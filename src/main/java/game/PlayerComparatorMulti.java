package game;

import java.util.Comparator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Class compares two {@code Player} object in multiplayer mode.
 * 
 * @author Gyákon Jácint
 * 
 */
public class PlayerComparatorMulti implements Comparator<Player> {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(PlayerComparatorMulti.class);
	
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
		int p1 = (int) (((double) o1.getWin() / (o1.getWin()+o1.getTie()+o1.getLose())) * 100.0);
		int p2 = (int) (((double) o2.getWin() / (o2.getWin()+o2.getTie()+o2.getLose())) * 100.0);
		if (p1 < p2) {
			return 1;
		} else if(p1 > p2){
			return -1;
		} else {
			return 0;
		}
	}

}

package game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import panels.GamePanel;
import panels.GamePanelMulti;
import panels.GamePanelSingle;

/**
 * Class to handle mouse events, implements {@link MouseListener}.
 * 
 * @author Gyákon Jácint
 * 
 */
public class SpecialMouseListener implements MouseListener {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(SpecialMouseListener.class);

	/**
	 * {@link GamePanel} of the game.
	 */
	private GamePanel table;

	/**
	 * The delay of the {@link Thread}.
	 */
	public static int delay = 1000;

	/**
	 * A list of {@link Card} objects.
	 */
	public static List<Card> guess = new LinkedList<Card>();

	/**
	 * Constructor for creating the table, which has to be detected.
	 * 
	 * @param table
	 *            the table of the game
	 */
	public SpecialMouseListener(GamePanel table) {
		this.table = table;
	}

	/**
	 * Calculates where you clicked.
	 * 
	 * @param arg0
	 *            a {@link MouseEvent} argument, which gives us the coordinates
	 *            of the mouse press
	 */
	public void mousePressed(MouseEvent arg0) {
		int x = arg0.getX();
		int y = arg0.getY();
		logger.info("The coordinates: ( {}, {} ).", x, y);
		whatToDo(x, y);
	}

	/**
	 * Decides what to do when the user clicked.
	 * 
	 * @param x
	 *            the first coordinate of the mouse's position
	 * @param y
	 *            the second coordinate of the mouse's position
	 */
	public void whatToDo(int x, int y) {
		int pos = x / 120 + (y / 120) * 4;

		GamePanel.getCards().get(pos).setClicked(!GamePanel.getCards().get(pos).isClicked());

		table.repaint();
		guess.add(GamePanel.getCards().get(pos));

		if (guess.size() == 2) {
			new Thread(new Runnable() {
				public void run() {
					table.removeMouse();
					try {
						Thread.sleep(delay);
					} catch (InterruptedException e) {
						logger.error("The thread was interrupted!");
					}
					checkPair();
					table.addMouse();
				}
			}).start();
		}
	}

	/**
	 * Checks if the two cards, which was selected, is pair or not.
	 */
	public void checkPair() {
		addGuesses();
		if ((guess.get(0).getId()) == (guess.get(1).getId())
				&& (guess.get(0).getDiff()) != (guess.get(1).getDiff())) {
			logger.info("A pair was found.");
			addPairs();
			setFoundValue();
			table.repaint();
			guess.clear();
		} else {

			logger.info("It is not a pair.");
			turnReverser();
			cardTurn();
			table.repaint();
			guess.clear();
		}
	}

	/**
	 * Reverses the {@code myTurn} field of the {@link Card} objects.
	 */
	public void turnReverser() {
		if (GamePanel.isMulti()) {
			logger.info("The other player's turn is coming.");
			GamePanelMulti.getPlayer1().setMyTurn(!GamePanelMulti.getPlayer1().isMyTurn());
			GamePanelMulti.getPlayer2().setMyTurn(!GamePanelMulti.getPlayer2().isMyTurn());
		}
	}

	/**
	 * Sets the {@code clicked} field of the {@link Card} objects to
	 * <code>false</code>.
	 */
	public void cardTurn() {
		for (Card cd : GamePanel.getCards()) {
			logger.info("Turning back the cards.");
			cd.setClicked(false);
		}
	}

	/**
	 * Increments the number of guesses of the players.
	 */
	public void addGuesses() {
		logger.info("Incrementing the number of the guesses.");
		if (GamePanel.isMulti()) {
			if (GamePanelMulti.getPlayer1().isMyTurn()) {
				GamePanelMulti.getPlayer1().setNumberOfGuesses(
						GamePanelMulti.getPlayer1().getNumberOfGuesses() + 1);
			} else {
				GamePanelMulti.getPlayer2().setNumberOfGuesses(
						GamePanelMulti.getPlayer2().getNumberOfGuesses() + 1);
			}
		} else {
			GamePanelSingle.getPlayer().setNumberOfGuesses(
					GamePanelSingle.getPlayer().getNumberOfGuesses() + 1);
		}
	}

	/**
	 * Increments the number of pairs of the players.
	 */
	public void addPairs() {
		logger.info("Incrementing the number of the pairs.");
		if (GamePanel.isMulti()) {
			if (GamePanelMulti.getPlayer1().isMyTurn()) {
				GamePanelMulti.getPlayer1().setNumberOfPairs(
						GamePanelMulti.getPlayer1().getNumberOfPairs() + 1);
			} else {
				GamePanelMulti.getPlayer2().setNumberOfPairs(
						GamePanelMulti.getPlayer2().getNumberOfPairs() + 1);
			}
		} else {
			GamePanelSingle.getPlayer().setNumberOfPairs(GamePanelSingle.getPlayer().getNumberOfPairs() + 1);
		}
	}

	/**
	 * Sets the {@code found} value <code>true</code> of the card, which is
	 * found by the player.
	 */
	public void setFoundValue() {
		for (Card cd : GamePanel.getCards()) {
			if (guess.get(0).getId() == cd.getId()) {
				logger.info("Sets the found cards invisible.");
				cd.setFound(true);
			}
		}
	}

	/**
	 * Not used method.
	 * 
	 * @param arg0
	 *            a {@link MouseEvent} argument
	 */
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not used method.
	 * 
	 * @param arg0
	 *            a {@link MouseEvent} argument
	 */
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not used method.
	 * 
	 * @param arg0
	 *            a {@link MouseEvent} argument
	 */
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * Not used method.
	 * 
	 * @param arg0
	 *            a {@link MouseEvent} argument
	 */
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}

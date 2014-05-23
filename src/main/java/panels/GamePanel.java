package panels;

import game.Card;
import game.SpecialMouseListener;

import java.awt.Graphics;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for painting the cards.
 * 
 * @author Gyákon Jácint
 * 
 */
@SuppressWarnings("serial")
public class GamePanel extends JPanel {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(GamePanel.class);
	
	/**
	 * List of {@link Card} elements.
	 */
	static List<Card> cards;

	/**
	 * Mouse listener to handle mouse events.
	 */
	private MouseListener listener;

	/**
	 * Indicates whether the game is in multiplayer or singleplayer mode.
	 */
	static boolean multi = false;

	/**
	 * The folder of the card's front side.
	 */
	static String cardFolder = "fruits";

	/**
	 * The name of the card's back side image.
	 */
	static String backFile = "adobe";

	/**
	 * Constructor for creating a {@link GamePanel} object, whit a list of {@link Card} objects and a
	 * {@link MouseListener}.
	 */
	public GamePanel() {
		logger.info("Creating the cards.");
		setBounds(0, 0, 720, 480);
		cards = new LinkedList<Card>();

		for (int i = 1; i < 9; i++) {
			String file = this.getCardFolder() + "/" + i + ".png";
			Card card = new Card(i, 0, file);
			cards.add(card);
		}
		for (int i = 1; i < 9; i++) {
			String file = this.getCardFolder() + "/" + i + ".png";
			Card card = new Card(i, 1, file);
			cards.add(card);
		}

		Collections.shuffle(cards);
		listener = new SpecialMouseListener(this);
		addMouseListener(listener);

	}

	@Override
	public void paint(Graphics g) {
		logger.info("Painting the cards.");
		super.paint(g);
		int i = 20, j = 20, c = 0;
		BufferedImage image = null;
		try {
			image = ImageIO.read(App.class.getClassLoader().getResourceAsStream(this.getBackFile() + ".png"));
		} catch (IOException e) {
			logger.error("Can not find the image!");
		}
		for (Card cd : cards) {
			if (!cd.isFound()) {
				if (cd.isClicked()) {
					g.drawImage(cd.getImage(), i, j, null);
				} else {
					g.drawImage(image, i, j, null);
				}
			}
			c++;
			i += 120;
			if ((c % 4) == 0) {
				j += 120;
				i = 20;
			}
		}
	}

	/**
	 * Removes the {@link SpecialMouseListener} from the panel.
	 */
	public void removeMouse() {
		removeMouseListener(listener);
	}

	/**
	 * Adds the {@link SpecialMouseListener} from the panel.
	 */
	public void addMouse() {
		addMouseListener(listener);
	}

	/**
	 * Returns <code>true</code> if the game is in multiplayer mode,
	 *         <code>false</code> otherwise. 
	 * 
	 * @return <code>true</code> if the game is in multiplayer mode,
	 *         <code>false</code> otherwise
	 */
	public static boolean isMulti() {
		return multi;
	}

	/**
	 * Sets the {@code multi} of the panel.
	 * 
	 * @param multi
	 *            the {@code multi} of the panel
	 */
	public static void setMulti(boolean multi) {
		GamePanel.multi = multi;
	}

	/**
	 * Returns a list of {@link Card} objects.
	 * 
	 * @return the cards, which is a list of {@link Card} objects
	 */
	public static List<Card> getCards() {
		return cards;
	}

	/**
	 * Returns the {@code cardFolder} of the cards.
	 * 
	 * @return the {@code cardFolder} of the cards
	 */
	public String getCardFolder() {
		return cardFolder;
	}

	/**
	 * Sets the {@code cardFolder} of the cards.
	 * 
	 * @param cardFolder
	 *            the cardFolder of the cards
	 */
	public static void setCardFolder(String cardFolder) {
		GamePanel.cardFolder = cardFolder;
	}

	/**
	 * Returns the {@code backFile} of the cards.
	 * 
	 * @return the {@code backFile} of the cards
	 */
	public String getBackFile() {
		return backFile;
	}

	/**
	 * Sets the {@code backFile} of the cards.
	 * 
	 * @param backFile
	 *            the backFile of the cards
	 */
	public static void setBackFile(String backFile) {
		GamePanel.backFile = backFile;
	}

}

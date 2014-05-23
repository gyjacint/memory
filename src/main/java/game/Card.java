package game;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import panels.App;

/**
 * Class representing the cards of the memory game.
 * 
 * @author Gyákon Jácint
 * 
 */
public class Card {
	
	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(Card.class);
	
	/**
	 * Id of the card.
	 */
	private int id;

	/**
	 * Makes difference between same cards.
	 */
	private int diff;

	/**
	 * Filename of the card's image.
	 */
	private String FileName;

	/**
	 * Indicates whether the card is clicked.
	 */
	private boolean clicked = false;

	/**
	 * Indicates whether the card is found.
	 */
	private boolean found = false;

	/**
	 * Image of the card.
	 */
	private BufferedImage image = null;

	/**
	 * Constructor for creating a {@code Card} object.
	 * 
	 * @param id
	 *            the id of this card
	 * @param diff
	 *            the diff of this card
	 * @param filename
	 *            the filename of this card
	 */
	public Card(int id, int diff, String filename) {
		this.id = id;
		this.diff = diff;
		FileName = filename;
		
		try {
			this.image = ImageIO.read(App.class.getClassLoader().getResourceAsStream(filename));
		} catch (IOException e) {
			logger.error("Can not find the image of the card!");
		}
		logger.info("The card is set.");
	}

	/**
	 * Returns the id of this card.
	 * 
	 * @return the id of this card
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id of this event.
	 * 
	 * @param id
	 *            the id of this card
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns <code>true</code> if the {@code Card} is clicked, <code>false</code>
	 * otherwise.
	 * 
	 * @return <code>true</code> if the {@code Card} is clicked, <code>false</code>
	 *         otherwise
	 */
	public boolean isClicked() {
		return clicked;
	}

	/**
	 * Sets the clicked of this card.
	 * 
	 * @param clicked
	 *            the clicked of this card
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}

	/**
	 * Returns <code>true</code> if the {@code Card} is found, <code>false</code>
	 * otherwise.
	 * 
	 * @return <code>true</code> if the {@code Card} is found, <code>false</code>
	 *         otherwise
	 */
	public boolean isFound() {
		return found;
	}

	/**
	 * Sets the found of this card.
	 * 
	 * @param found
	 *            the found of this card
	 */
	public void setFound(boolean found) {
		this.found = found;
	}

	/**
	 * Returns the diff of this card.
	 * 
	 * @return the diff of this card
	 */
	public int getDiff() {
		return diff;
	}

	/**
	 * Returns the fileName of this card.
	 * 
	 * @return the fileName of this card
	 */
	public String getFileName() {
		return FileName;
	}

	/**
	 * Returns the image of this card.
	 * 
	 * @return the image of this card
	 */
	public BufferedImage getImage() {
		return image;
	}

}

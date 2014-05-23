package panels;

import game.Card;
import game.Player;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Collections;

import javax.swing.JOptionPane;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xml.XMLSingleStatFactory;

/**
 * Class for painting the name and score, extends {@link GamePanel}.
 * 
 * @author Gyákon Jácint
 *
 */
@SuppressWarnings("serial")
public class GamePanelSingle extends GamePanel {
	
	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(GamePanelSingle.class);
	
	/**
	 * Player of the game.
	 */
	public static Player player;

	/**
	 * Constructor for creating a {@link GamePanelSingle} object.
	 */
	public GamePanelSingle() {
		super();
		logger.info("Creating the players.");
		String s = JOptionPane.showInputDialog("Add meg a neved: ");
		if (s == null || s.equals("")) {
			player = new Player("Player1");
		} else {
			player = new Player(s);
		}
		
		Collections.shuffle(GamePanel.cards);
		for (Card cd : GamePanel.cards) {
			cd.setFound(false);
			cd.setClicked(false);
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		logger.info("Writing the results of the players.");
		panels.App.frame.setTitle("Memória Játék - " + player.getName() + " gyakorol");
		g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		g.drawString(player.getName(), 520, 100);
		g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
		g.setColor(Color.RED);
		g.drawString("Tippek száma: " + player.getNumberOfGuesses(), 520, 150);
		g.drawString("Párok száma: " + player.getNumberOfPairs(), 520, 200);
		if (player.getNumberOfPairs() == 8) {
			stop();
		}

	}

	/**
	 * Stops the game and saves the results.
	 */
	public void stop() {
		XMLSingleStatFactory xml = new XMLSingleStatFactory();
		xml.addXML(player);
		JOptionPane.showMessageDialog(App.frame, "Gratulálok! Nagyon Ügyes vagy!", "Játék Vége",JOptionPane.INFORMATION_MESSAGE);
		App.ChangeToMain();
	}

	/**
	 * Returns the player of the game.
	 * 
	 * @return the player of the game
	 */
	public static Player getPlayer() {
		return player;
	}

	
	
}

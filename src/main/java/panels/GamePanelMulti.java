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

import xml.XMLMultiStatFactory;

/**
 * Class for painting the names and scores, extends {@link GamePanel}.
 * 
 * @author Gyákon Jácint
 *
 */
@SuppressWarnings("serial")
public class GamePanelMulti extends GamePanel {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(GamePanelMulti.class);
	
	/**
	 * Player of the game.
	 */
	public static Player player1;
	
	/**
	 * Player of the game.
	 */
	public static Player player2;

	/**
	 * Constructor for creating a {@link GamePanelMulti} object.
	 */
	public GamePanelMulti() {
		super();
		logger.info("Creating the players.");
		GamePanel.setMulti(true);
		String s1 = JOptionPane.showInputDialog("Add meg az első játékos nevét: ");
		if (s1 == null || s1.equals("")) {
			player1 = new Player("Player1");
		} else {
			player1 = new Player(s1);
		}
		String s2 = JOptionPane.showInputDialog("Add meg a második játékos nevét: ");
		if (s2 == null || s2.equals("")) {
			player2 = new Player("Player2");
		} else {
			player2 = new Player(s2);
		}
		player2.setMyTurn(false);
		Collections.shuffle(GamePanel.cards);
		for (Card cd : GamePanel.cards) {
			cd.setFound(false);
			cd.setClicked(false);
		}
	}

	@Override
	public void paint(Graphics g) {
		logger.info("Writing the results of the players.");
		super.paint(g);
		int startPos = 100;
		if (player1.isMyTurn()) {
			panels.App.frame.setTitle("Memória Játék - " + player1.getName() + " forgat");
			g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			g.setColor(Color.RED);
			g.drawString(player1.getName(), 520, startPos);
			g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 25));
			g.setColor(Color.BLACK);
			g.drawString("Párok száma: " + player1.getNumberOfPairs(), 520, startPos + 50);
			g.drawString("Tippek száma: " + player1.getNumberOfGuesses(), 520, startPos + 100);

			g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
			g.drawString(player2.getName(), 520, startPos + 300);
			g.drawString("Párok száma: " + player2.getNumberOfPairs(), 520, startPos + 320);
			g.drawString("Tippek száma: " + player2.getNumberOfGuesses(), 520, startPos + 340);

		} else {
			panels.App.frame.setTitle("Memória Játék - " + player2.getName() + " forgat");
			g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
			g.setColor(Color.RED);
			g.drawString(player2.getName(), 520, startPos);
			g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
			g.setColor(Color.BLACK);
			g.drawString("Párok száma: " + player2.getNumberOfPairs(), 520, startPos + 50);
			g.drawString("Tippek száma: " + player2.getNumberOfGuesses(), 520, startPos + 100);

			g.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
			g.drawString(player1.getName(), 520, startPos + 300);
			g.drawString("Párok száma: " + player1.getNumberOfPairs(), 520, startPos + 320);
			g.drawString("Tippek száma: " + player1.getNumberOfGuesses(), 520, startPos + 340);
		}
		if ((player1.getNumberOfPairs() + player2.getNumberOfPairs()) == 1) {
			stop();
		}

	}

	/**
	 * Stops the game and saves the results.
	 */
	public static void stop() {
		if (player1.getNumberOfPairs() == player2.getNumberOfPairs()) {
			player1.setTie(player1.getTie()+1);
			player2.setTie(player2.getTie()+1);
			JOptionPane.showMessageDialog(App.frame, "Döntetlen :(", "Játék Vége",JOptionPane.INFORMATION_MESSAGE);
		} else if (player1.getNumberOfPairs() > player2.getNumberOfPairs()) {
			player1.setWin(player1.getWin()+1);
			player2.setLose(player2.getLose()+1);
			JOptionPane.showMessageDialog(App.frame, "A győztes : " + player1.getName(), "Játék Vége",JOptionPane.INFORMATION_MESSAGE);
		} else {
			player2.setWin(player2.getWin()+1);
			player1.setLose(player1.getLose()+1);
			JOptionPane.showMessageDialog(App.frame, "A győztes : " + player2.getName(), "Játék Vége",JOptionPane.INFORMATION_MESSAGE);
		}
		XMLMultiStatFactory xml = new XMLMultiStatFactory();
		xml.addXML(player1);
		xml.addXML(player2);
		App.ChangeToMain();
	}

	/**
	 * Return the player1.
	 * 
	 * @return the player1
	 */
	public static Player getPlayer1() {
		return player1;
	}

	/**
	 * Return the player2.
	 * 
	 * @return the player2
	 */
	public static Player getPlayer2() {
		return player2;
	}

}

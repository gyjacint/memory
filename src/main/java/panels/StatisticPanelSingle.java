package panels;

import game.Player;
import game.PlayerComparatorSingle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Font;
import java.awt.Graphics;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import xml.XMLSingleStatHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Class for creating a panel to show the statistic in singleplayer mode.
 * 
 * @author Gyákon Jácint
 * 
 */
@SuppressWarnings("serial")
public class StatisticPanelSingle extends JPanel {
	
	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(StatisticPanelSingle.class);
	
	/**
	 * List which contains the players of the statistic.
	 */
	List<Player> list = new LinkedList<Player>();

	/**
	 * Create the panel.
	 */
	public StatisticPanelSingle() {
		logger.info("Writing the statistic in singleplayer mode.");
		XMLSingleStatHandler handler = new XMLSingleStatHandler();
		
		list = handler.readXML("single.xml");
		PlayerComparatorSingle c = new PlayerComparatorSingle();
		Collections.sort(list, c);
		setBounds(0, 0, 720, 480);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Statisztika");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(230, 24, 260, 41);
		add(lblNewLabel);

		JButton btnVissza = new JButton("Vissza a Főmenübe");
		btnVissza.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				App.ChangeToMain();
			}
		});
		btnVissza.setBounds(535, 420, 150, 30);
		add(btnVissza);

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setFont(new Font("times new roman", 0, 18));
		g.drawString("Név", 70, 120);
		g.drawString("Tippek", 220, 120);
		g.drawString("Párok", 320, 120);
		g.drawString("Találat (%)", 420, 120);
		int i = 0;
		for (Player p : list) {
			i++;
			g.drawString(new Integer(i).toString() + ".", 40, 120 + 40 * i);
			g.drawString(p.getName(), 70, 120 + 40 * i);
			g.drawString(p.getNumberOfGuesses() + "", 220, 120 + 40 * i);
			g.drawString(p.getNumberOfPairs() + "", 320, 120 + 40 * i);
			g.drawString(((int) (((double) p.getNumberOfPairs() / p.getNumberOfGuesses()) * 100.0)) + "%", 420, 120 + 40 * i);
			if (i > 6) {
				break;
			}
		}
	}
}

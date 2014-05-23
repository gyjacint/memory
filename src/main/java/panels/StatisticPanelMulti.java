package panels;

import game.Player;
import game.PlayerComparatorMulti;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xml.XMLMultiStatHandler;

/**
 * Class for creating a panel to show the statistic in multiplayer mode.
 * 
 * @author Gyákon Jácint
 *
 */
@SuppressWarnings("serial")
public class StatisticPanelMulti extends JPanel {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(StatisticPanelMulti.class);
	
	/**
	 * List which contains the players of the statistic.
	 */
	List<Player> list = new LinkedList<Player>();
	
	/**
	 * Create the panel.
	 */
	public StatisticPanelMulti() {
		logger.info("Writing the statistic in multiplayer mode.");
		XMLMultiStatHandler handler = new XMLMultiStatHandler();
		list = handler.readXML("multi.xml");
		PlayerComparatorMulti c = new PlayerComparatorMulti();
		Collections.sort(list, c);

		setBounds(0, 0, 720, 480);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Statisztika");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(230, 24, 260, 41);
		add(lblNewLabel);

		JButton btnVissza = new JButton("Vissza a főmenübe");
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
		g.drawString("Győzelem(%)", 220, 120);
		g.drawString("Győzelem", 350, 120);
		g.drawString("Döntelten", 450, 120);
		g.drawString("Vereség", 550, 120);
		int i = 0;
		for (Player p : list) {
			i++;
			g.drawString(new Integer(i).toString() + ".", 40, 120 + 40 * i);
			g.drawString(p.getName(), 70, 120 + 40 * i);
			g.drawString(((int) (((double) p.getWin() / (p.getWin()+p.getTie()+p.getLose())) * 100.0)) + "%",
					220, 120 + 40 * i);
			g.drawString(p.getWin() + "", 350, 120 + 40 * i);
			g.drawString(p.getTie() + "", 450, 120 + 40 * i);
			g.drawString(p.getLose() + "", 550, 120 + 40 * i);
			if(i>6){
				break;
			}
		}
	}

}

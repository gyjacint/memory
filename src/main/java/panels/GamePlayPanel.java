package panels;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for creating a panel to show the rules of the game.
 * 
 * @author Gyákon Jácint
 * 
 */
@SuppressWarnings("serial")
public class GamePlayPanel extends JPanel {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(GamePlayPanel.class);

	/**
	 * Create the panel.
	 */
	public GamePlayPanel() {
		logger.info("Writing the rules of the game.");
		setBounds(0, 0, 720, 480);
		setLayout(null);

		JLabel lblAJtkMenete = new JLabel("A Játék Menete");
		lblAJtkMenete.setHorizontalAlignment(SwingConstants.CENTER);
		lblAJtkMenete.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblAJtkMenete.setBounds(0, 24, 720, 41);
		add(lblAJtkMenete);

		String s = "A játékot két féle módban lehet játszani. Ellenfél hiányában, vagy pusztán gyakorlás céljából választható a Gyakorlás mód. Ekkor a játékos ellenfél nélkül játszik, sikeres játék esetén pedig felkreül a gyakorló statisztikára, ahol a szükséges lépsek száma szerinti sorrendben rangsorolva vannak a játékosok."
				+ "A másik lehetséges mód az egymás elleni játék ahol 2 játékos küzd meg egymással, amennyiben az egyik játékos párt talál, újra következik, ellenkező esetben az ellenfele próbálkozhat. A mérkőzést az nyeri, aki a kártyák elfogyása után több párral rendelkezik. Ezután ugyancsak felkerül mindkét játékos a tabellára ahol a győztes játszám/összes játszma alapján kerülnek rangsorolásra."
				+ " Jó szórakozást és sok sikert kívánok a játékhoz!";

		JLabel lblIdeJnMajd = new JLabel();
		lblIdeJnMajd.setText("<html>"+ s +"</html>");
		lblIdeJnMajd.setVerticalAlignment(SwingConstants.TOP);
		lblIdeJnMajd.setBounds(50, 89, 619, 205);
		add(lblIdeJnMajd);

		JButton btnVissza = new JButton("Vissza");
		btnVissza.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				App.ChangeToMain();
			}
		});
		btnVissza.setBounds(590, 420, 100, 30);
		add(btnVissza);

	}

}

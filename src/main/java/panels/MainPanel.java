package panels;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Font;

/**
 * Class for creating a panel to show the Main menu.
 * 
 * @author Gyákon Jácint
 *
 */
@SuppressWarnings("serial")
public class MainPanel extends JPanel {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(MainPanel.class);
	
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		logger.info("Painting the main panel of the game.");
		setLayout(null);
		
		JButton buttonGP = new JButton("A Játék Menete");
		buttonGP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				App.ChangeMainToGamePlay();
			}
		});
		buttonGP.setBounds(259, 123, 202, 59);
		add(buttonGP);
		
		JButton buttonS = new JButton("Gyakorlás");
		buttonS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				App.ChangeMainToSingleGame();
			}
		});
		buttonS.setBounds(259, 202, 202, 59);
		add(buttonS);
		
		JButton buttonM = new JButton("Egymás ellen");
		buttonM.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				App.ChangeMainToMultiGame();
			}
		});
		buttonM.setBounds(259, 281, 202, 59);
		add(buttonM);
		
		JButton buttonE = new JButton("Kilépés");
		buttonE.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		buttonE.setBounds(259, 363, 202, 59);
		add(buttonE);
		
		JLabel labelTitle = new JLabel("Memória Játék");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		labelTitle.setBounds(0, 25, 720, 59);
		add(labelTitle);

	}
}


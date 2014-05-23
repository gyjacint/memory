package panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class for starting the game and to handle the menus and panels.
 * 
 * @author Gyákon Jácint
 *
 */
@SuppressWarnings("serial")
public class App extends JFrame {
	
	/**
	 * Logger of the class.
	 */
	static Logger logger = LoggerFactory.getLogger(App.class);
	
	/**
	 * The frame of the game.
	 */
	public static JFrame frame;
	
	/**
	 * The main panel of the game.
	 */
	public static JPanel mainPanel;
	
	/**
	 * The singleplayer panel of the game.
	 */
	public static JPanel singleGamePanel;
	
	/**
	 * The multiplayer panel of the game.
	 */
	public static JPanel multiGamePanel;
	
	/**
	 * The statistic panel of the game.
	 */
	public static JPanel statisticPanel;
	
	/**
	 * The game rules panel of the game.
	 */
	public static JPanel gamePlayPanel;
	
	/**
	 * The current panel of the frame.
	 */
	public static JPanel currentPanel;
	
	/**
	 * The "Kártya" menu of the frame.
	 */
	public static JMenu cardMenu;
	
	/**
	 * The main method of the frame, which paints the frame with the main panel.
	 * 
	 * @param args the argument of the main method
	 */
	public static void main(String[] args) {
		frame = new JFrame("Memória Játék");
		mainPanel = new MainPanel();

		frame.add(mainPanel);
		currentPanel = mainPanel;
		
		frame.setJMenuBar(App.createMenuBar());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(720, 540);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Method to change {@link MainPanel} to {@link GamePanelSingle}.
	 */
	public static void ChangeMainToSingleGame() {
		frame.remove(currentPanel);
		frame.dispose();
		singleGamePanel = new GamePanelSingle();
		frame.add(singleGamePanel);
		currentPanel = singleGamePanel;
		cardMenu.setVisible(false);
		frame.setVisible(true);
	}

	/**
	 * Method to change {@link MainPanel} to {@link GamePanelMulti}.
	 */
	public static void ChangeMainToMultiGame() {
		frame.remove(currentPanel);
		frame.dispose();
		multiGamePanel = new GamePanelMulti();
		frame.add(multiGamePanel);
		currentPanel = multiGamePanel;
		cardMenu.setVisible(false);
		frame.setVisible(true);
	}

	/**
	 * Method to change {@link MainPanel} to {@link StatisticPanelSingle}.
	 */
	public static void ChangeMainToStatisticSingle() {
		frame.remove(currentPanel);
		frame.dispose();
		statisticPanel = new StatisticPanelSingle();
		frame.add(statisticPanel);
		currentPanel = statisticPanel;
		cardMenu.setVisible(false);
		frame.setVisible(true);
	}
	
	/**
	 * Method to change {@link MainPanel} to {@link StatisticPanelMulti}.
	 */
	public static void ChangeMainToStatisticMulti() {
		frame.remove(currentPanel);
		frame.dispose();
		statisticPanel = new StatisticPanelMulti();
		frame.add(statisticPanel);
		currentPanel = statisticPanel;
		cardMenu.setVisible(false);
		frame.setVisible(true);
	}

	/**
	 * Method to change {@link MainPanel} to {@link GamePlayPanel}.
	 */
	public static void ChangeMainToGamePlay() {
		frame.remove(currentPanel);
		frame.dispose();
		gamePlayPanel = new GamePlayPanel();
		frame.add(gamePlayPanel);
		currentPanel = gamePlayPanel;
		frame.setVisible(true);
	}

	/**
	 * Method to change panel to {@link MainPanel}.
	 */
	public static void ChangeToMain() {
		frame.remove(currentPanel);
		frame.dispose();
		frame.setTitle("Memória Játék");
		frame.add(mainPanel);
		currentPanel = mainPanel;
		cardMenu.setVisible(true);
		frame.setVisible(true);
	}

	/**
	 * Returns the menu of the game.
	 * 
	 * @return the menu of the game
	 */
	public static JMenuBar createMenuBar() {
		
		logger.info("Creating the menus.");
		
		JMenuBar menuBar;
		JMenuItem menuItem;
		JMenu menu, submenu;
		JRadioButtonMenuItem rbMenuItem , rbMenuItem2;

		menuBar = new JMenuBar();
		menu = new JMenu("Játék");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		menuItem = new JMenuItem("Vissza a főmenübe");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeToMain();
			}
		});
		menu.add(menuItem);

		menuItem = new JMenuItem("Kilépés");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		menu.add(menuItem);

		menu = new JMenu("Egyéb");
		menu.setMnemonic(KeyEvent.VK_A);
		menuBar.add(menu);

		menuItem = new JMenuItem("Kredit");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = "Készítő: Gyákon Jácint \nTesztelő: Gyákon Jácint \nTulajdonos: Gyákon Jácint";
				JOptionPane.showMessageDialog(App.frame, s, "Adatok",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menu.add(menuItem);

		submenu = new JMenu("Statisztika");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("Gyakorló statisztika");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeMainToStatisticSingle();
			}
		});
		submenu.add(menuItem);

		menuItem = new JMenuItem("Tabella");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeMainToStatisticMulti();
			}
		});
		submenu.add(menuItem);
		
		menu.add(submenu);
		
		cardMenu = new JMenu("Kártya");
		cardMenu.setMnemonic(KeyEvent.VK_N);
        menuBar.add(cardMenu);
        
        submenu = new JMenu("Előlap");
		submenu.setMnemonic(KeyEvent.VK_S);
		
		ButtonGroup group = new ButtonGroup();
		 
        rbMenuItem = new JRadioButtonMenuItem("Gyümölcsök");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        rbMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamePanel.setCardFolder("fruits");
			}
		});
        group.add(rbMenuItem);
        submenu.add(rbMenuItem);
        
        rbMenuItem = new JRadioButtonMenuItem("Állatok");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        rbMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamePanel.setCardFolder("animals");
			}
		});
        group.add(rbMenuItem);
        submenu.add(rbMenuItem);
		
		cardMenu.add(submenu);
		
		ButtonGroup group2 = new ButtonGroup();
		
		submenu = new JMenu("Hátlap");
		submenu.setMnemonic(KeyEvent.VK_S);
		 
        rbMenuItem2 = new JRadioButtonMenuItem("Adobe");
        rbMenuItem2.setSelected(true);
        rbMenuItem2.setMnemonic(KeyEvent.VK_R);
        rbMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamePanel.setBackFile("adobe");
			}
		});
        group2.add(rbMenuItem2);
        submenu.add(rbMenuItem2);
        
        rbMenuItem2 = new JRadioButtonMenuItem("Zöld");
        rbMenuItem2.setMnemonic(KeyEvent.VK_O);
        rbMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamePanel.setBackFile("green");
			}
		});
        group2.add(rbMenuItem2);
        submenu.add(rbMenuItem2);
        
        rbMenuItem2 = new JRadioButtonMenuItem("Piros");
        rbMenuItem2.setMnemonic(KeyEvent.VK_O);
        rbMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamePanel.setBackFile("red");
			}
		});
        group2.add(rbMenuItem2);
        submenu.add(rbMenuItem2);
        
        rbMenuItem2 = new JRadioButtonMenuItem("Kék");
        rbMenuItem2.setMnemonic(KeyEvent.VK_O);
        rbMenuItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GamePanel.setBackFile("blue");
			}
		});
        group2.add(rbMenuItem2);
        submenu.add(rbMenuItem2);
		
		cardMenu.add(submenu);

		return menuBar;
	}
}

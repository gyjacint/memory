package xml;

import game.Player;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Class for the reading the results table in singleplayer mode.
 * 
 * @author Gyákon Jácint
 * 
 */
public class XMLSingleStatHandler {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(XMLSingleStatHandler.class);

	/**
	 * Reads the XML file of the results table.
	 * 
	 * @param fileName
	 *            the name of the XML file
	 * @return a list of the players
	 */
	public List<Player> readXML(String fileName) {
		logger.info("Trying to read the XML file...");
		Player player = new Player("");
		List<Player> list = new LinkedList<Player>();
		boolean sameName = false;
		try {
			File xmlFile;
//			if (fileName.equals("singletest.xml")) {
//				URL url = XMLSingleStatHandlerTest.class.getClassLoader().getResource(fileName);
//				xmlFile = new File(url.getPath());
//			} else {
				String home = System.getProperty("user.home");
				File mappa = new File(home, ".memorygame");
				xmlFile = new File(mappa, fileName);
//			}

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(xmlFile);

			doc.getDocumentElement().normalize();

			NodeList nodes = doc.getElementsByTagName("player");

			for (int i = 0; i < nodes.getLength(); i++) {
				Node node = nodes.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element) node;
					player = new Player(element.getElementsByTagName("name").item(0).getTextContent());
					player.setNumberOfGuesses(Integer.parseInt(element.getElementsByTagName("moves").item(0)
							.getTextContent()));
					player.setNumberOfPairs(Integer.parseInt(element.getElementsByTagName("pairs").item(0)
							.getTextContent()));
				}
				for (Player p : list) {
					if (p.equals(player)) {
						if (p.getNumberOfGuesses() > player.getNumberOfGuesses()) {
							list.remove(p);
							list.add(player);
							sameName = true;
						} else {
							sameName = true;
						}
					}
				}
				if (!sameName) {
					list.add(player);
				}
				sameName = false;
			}

		} catch (DOMException e) {
			logger.error("A DOMException occurred!");
			logger.error(e.toString());
		} catch (IOException e) {
			logger.error("Can not find the file!");
			logger.error(e.toString());
		} catch (ParserConfigurationException e) {
			logger.error("A ParserConfigurationException occurred!");
			logger.error(e.toString());
		} catch (SAXException e) {
			logger.error("A SAXException occurred!");
			logger.error(e.toString());
		} catch (NumberFormatException e) {
			logger.error("A NumberFormatException occurred! ");
			logger.error(e.toString());
		} catch (NullPointerException e) {
			logger.error("A nullpointerException occurred! ");
			logger.error(e.toString());
		}
		logger.info("Returning the XML file!");
		return list;

	}
}

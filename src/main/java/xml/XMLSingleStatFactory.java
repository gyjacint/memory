package xml;

import game.Player;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Class for the updating the results table in singleplayer mode.
 * 
 * @author Gyákon Jácint
 * 
 */
public class XMLSingleStatFactory {

	/**
	 * Logger of the class.
	 */
	Logger logger = LoggerFactory.getLogger(XMLSingleStatFactory.class);
	
	/**
	 * Updates the XML file of the results table.
	 * 
	 * @param player
	 *            the player of the game
	 */
	public void addXML(Player player) {
		logger.info("Saving the player's results.");
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			String home = System.getProperty("user.home");
			File mappa = new File(home, ".memorygame");
			mappa.mkdir();
			
			XMLSingleStatHandler handler = new XMLSingleStatHandler();
			List<Player> playerList = new LinkedList<Player>();
			
			logger.info("Reading the old statistic.");
			
			playerList = handler.readXML("single.xml");
			
			playerList.add(player);

			File file = new File(mappa, "single.xml");

			Element rootElement = doc.createElement("players");
			doc.appendChild(rootElement);

			for (Player pl : playerList) {

				Element cardElement = doc.createElement("player");
				rootElement.appendChild(cardElement);

				Element name = doc.createElement("name");
				name.appendChild(doc.createTextNode(pl.getName()));
				cardElement.appendChild(name);

				Element moves = doc.createElement("moves");
				moves.appendChild(doc.createTextNode(pl.getNumberOfGuesses() + ""));
				cardElement.appendChild(moves);

				Element pairs = doc.createElement("pairs");
				pairs.appendChild(doc.createTextNode(pl.getNumberOfPairs() + ""));
				cardElement.appendChild(pairs);

			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

		} catch (ParserConfigurationException e) {
			logger.error("A ParserConfigurationException occurred!");
			logger.error(e.toString());
		} catch (TransformerException e) {
			logger.error("A TransformerException occurred!");
			logger.error(e.toString());
		} catch (DOMException e) {
			logger.error("A DOMException occurred!");
			logger.error(e.toString());
		}
	}
}

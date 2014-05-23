package game;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import panels.App;

public class CardTest {

	@Test
	public void testCard() {
		String file = "fruits" + "/" + 1 + ".png";
		Card card = new Card(1, 1, file);
		Card card2 = new Card(1, 1, file);
		assertEquals(card.getId(),card2.getId());
	}

	@Test
	public void testGetIdAndSetId() {
		String file = "fruits" + "/" + 1 + ".png";
		Card card = new Card(1, 1, file);
		card.setId(5);
		assertEquals(5, card.getId());
	}

	@Test
	public void testIsClickedAndSetClicked() {
		String file = "fruits" + "/" + 1 + ".png";
		Card card = new Card(1, 1, file);
		card.setClicked(true);
		assertTrue(card.isClicked());
	}

	@Test
	public void testIsFoundAndSetFound() {
		String file = "fruits" + "/" + 1 + ".png";
		Card card = new Card(1, 1, file);
		card.setFound(true);
		assertTrue(card.isFound());
	}

	@Test
	public void testGetDiff() {
		String file = "fruits" + "/" + 1 + ".png";
		Card card = new Card(1, 1, file);
		assertEquals(1, card.getDiff());
	}

	@Test
	public void testGetFileName() {
		String file = "fruits" + "/" + 1 + ".png";
		Card card = new Card(1, 1, file);
		assertEquals("fruits/1.png", card.getFileName());
	}

	@Test
	public void testGetImage() throws IOException {
		String file = "fruits" + "/" + 1 + ".png";
		Card card = new Card(1, 1, file);
		BufferedImage image = ImageIO.read(App.class.getClassLoader().getResourceAsStream("fruits/1.png"));
		assertSame(image.getHeight(), card.getImage().getHeight());
	}

}

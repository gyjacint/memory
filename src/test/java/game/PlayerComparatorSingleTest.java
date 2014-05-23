package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerComparatorSingleTest {

	@Test
	public void testCompare() {
		Player p1 = new Player("Player1");
		Player p2 = new Player("Player2");
		PlayerComparatorSingle pc = new PlayerComparatorSingle();
		p1.setNumberOfGuesses(5);
		p2.setNumberOfGuesses(3);
		assertEquals(1, pc.compare(p1, p2) );
		p2.setNumberOfGuesses(8);
		assertEquals(-1, pc.compare(p1, p2) );
		p1.setNumberOfGuesses(8);
		assertEquals(0, pc.compare(p1, p2) );
	}

}

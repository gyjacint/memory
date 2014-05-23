package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerComparatorMultiTest {

	@Test
	public void testCompare() {
		Player p1 = new Player("Player1");
		Player p2 = new Player("Player2");
		PlayerComparatorMulti pc = new PlayerComparatorMulti();
		p1.setWin(5);
		p1.setLose(1);
		p2.setWin(3);
		p2.setLose(1);
		assertEquals(-1, pc.compare(p1, p2) );
		p2.setWin(8);
		assertEquals(1, pc.compare(p1, p2) );
		p1.setWin(8);
		assertEquals(0, pc.compare(p1, p2) );
	}

}

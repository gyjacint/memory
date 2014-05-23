package game;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testHashCode() {
		Player player1 = new Player("Kis József");
		Player player2 = new Player("Kis József");
		Player player3 = new Player("Kis Józska");
		Player player4 = new Player(null);
		assertEquals(player1.hashCode(), player2.hashCode());
		assertNotEquals(player1.hashCode(), player3.hashCode());
		assertNotEquals(player1.hashCode(), player4.hashCode());
	}

	@Test
	public void testPlayer() {
		Player player = new Player("Jácint");
		assertEquals("Jácint", player.getName());
	}

	@Test
	public void testGetWinAndSetWin() {
		Player player = new Player("name");
		player.setWin(2);
		assertEquals(2, player.getWin());
	}
	
	@Test
	public void testGetTieAndSetTie() {
		Player player = new Player("name");
		player.setTie(3);
		assertEquals(3, player.getTie());
	}
	
	@Test
	public void testGetLoseAndSetLose() {
		Player player = new Player("name");
		player.setLose(8);
		assertEquals(8, player.getLose());	
	}

	@Test
	public void testGetNumberOfGuessesAndSetNumberOfGuesses() {
		Player player = new Player("name");
		player.setNumberOfGuesses(7);
		assertEquals(7, player.getNumberOfGuesses());	
	}
	
	@Test
	public void testGetNumberOfPairsAndSetNumberOfPairs() {
		Player player = new Player("name");
		player.setNumberOfPairs(-9);
		assertEquals(-9, player.getNumberOfPairs());	
	}

	@Test
	public void testIsMyTurnAndSetMyTurn() {
		Player player = new Player("name");
		player.setMyTurn(true);
		assertEquals(true, player.isMyTurn());	
	}
	
	@Test
	public void testEqualsObject() {
		Player player1 = new Player("Kis József");
		Player player2 = new Player("Kis József");
		Player player3 = new Player("Kis Józska");
		Player player4 = new Player(null);
		Player player5 = new Player(null);
		Card card = new Card(1, 1, "fruits/1.png");
		assertEquals(true, player1.equals(player2));
		assertEquals(true, player1.equals(player1));
		assertEquals(false, player2.equals(player3));
		assertEquals(false, player2.equals(null));
		assertEquals(false, player2.equals(card));
		assertEquals(false, player4.equals(player2));
		assertEquals(true, player4.equals(player5));
	}

}

package game;

import static org.junit.Assert.*;

import org.junit.Test;

import panels.GamePanel;
import panels.GamePanelMulti;
import panels.GamePanelSingle;

public class SpecialMouseListenerTest {

	@Test
	public void testSpecialMouseListenerSingleMode() {

		GamePanel table = new GamePanel();
		GamePanelSingle.player = new Player("Hernando");
		GamePanel.setMulti(false);

		GamePanel.setBackFile("green");
		assertEquals("green", table.getBackFile());
		GamePanel.setCardFolder("animals");
		assertEquals("animals", table.getCardFolder());

		SpecialMouseListener l = new SpecialMouseListener(table);

		SpecialMouseListener.guess.add(new Card(1, 0, "fruits/3.png"));
		SpecialMouseListener.guess.add(new Card(1, 1, "fruits/3.png"));
		l.checkPair();

		SpecialMouseListener.guess.add(new Card(2, 0, "fruits/2.png"));
		SpecialMouseListener.guess.add(new Card(1, 1, "fruits/1.png"));
		l.checkPair();

		SpecialMouseListener.guess.add(new Card(1, 0, "fruits/1.png"));
		SpecialMouseListener.guess.add(new Card(1, 1, "fruits/1.png"));
		l.checkPair();

		l.whatToDo(100, 100);
		assertTrue(GamePanel.getCards().get(0).isClicked());
		assertFalse(GamePanel.getCards().get(1).isClicked());
		l.whatToDo(220, 220);
		assertTrue(GamePanel.getCards().get(5).isClicked());

		table.removeMouse();
		table.addMouse();

	}

	@Test
	public void testSpecialMouseListenerMultiMode() {

		GamePanel table = new GamePanel();
		GamePanelMulti.player1 = new Player("A");
		GamePanelMulti.player2 = new Player("B");
		GamePanelMulti.player1.setMyTurn(true);
		GamePanelMulti.player2.setMyTurn(false);
		GamePanel.setMulti(true);

		SpecialMouseListener l = new SpecialMouseListener(table);

		assertTrue(GamePanelMulti.getPlayer1().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer2().isMyTurn());

		SpecialMouseListener.guess.add(new Card(1, 0, "fruits/3.png"));
		SpecialMouseListener.guess.add(new Card(1, 1, "fruits/3.png"));
		l.checkPair();

		assertTrue(GamePanelMulti.getPlayer1().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer2().isMyTurn());

		SpecialMouseListener.guess.add(new Card(2, 0, "fruits/2.png"));
		SpecialMouseListener.guess.add(new Card(1, 1, "fruits/1.png"));
		l.checkPair();

		assertTrue(GamePanelMulti.getPlayer2().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer1().isMyTurn());

		SpecialMouseListener.guess.add(new Card(1, 0, "fruits/1.png"));
		SpecialMouseListener.guess.add(new Card(1, 1, "fruits/1.png"));
		l.checkPair();

		assertTrue(GamePanelMulti.getPlayer2().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer1().isMyTurn());
		testTurnReverser();

		SpecialMouseListener.guess.add(new Card(1, 0, "fruits/5.png"));
		SpecialMouseListener.guess.add(new Card(2, 1, "fruits/6.png"));
		l.checkPair();

		assertTrue(GamePanelMulti.getPlayer1().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer2().isMyTurn());
		testTurnReverser();

		table.removeMouseListener(l);
		table.addMouseListener(l);

	}

	@Test
	public void testPairGuess() {
		GamePanel table = new GamePanel();
		GamePanelMulti.player1 = new Player("A");
		GamePanelMulti.player2 = new Player("B");
		GamePanelMulti.player1.setMyTurn(true);
		GamePanelMulti.player2.setMyTurn(false);
		GamePanel.setMulti(true);

		SpecialMouseListener l = new SpecialMouseListener(table);

		assertTrue(GamePanelMulti.getPlayer1().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer2().isMyTurn());

		SpecialMouseListener.guess.add(new Card(1, 0, "fruits/3.png"));
		SpecialMouseListener.guess.add(new Card(1, 1, "fruits/3.png"));
		l.checkPair();

		assertTrue(GamePanelMulti.getPlayer1().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer2().isMyTurn());
	}
	
	@Test
	public void testNotPairGuess() {
		GamePanel table = new GamePanel();
		GamePanelMulti.player1 = new Player("A");
		GamePanelMulti.player2 = new Player("B");
		GamePanelMulti.player1.setMyTurn(true);
		GamePanelMulti.player2.setMyTurn(false);
		GamePanel.setMulti(true);

		SpecialMouseListener l = new SpecialMouseListener(table);

		assertTrue(GamePanelMulti.getPlayer1().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer2().isMyTurn());

		SpecialMouseListener.guess.add(new Card(5, 0, "fruits/3.png"));
		SpecialMouseListener.guess.add(new Card(1, 1, "fruits/3.png"));
		l.checkPair();

		assertTrue(GamePanelMulti.getPlayer2().isMyTurn());
		assertFalse(GamePanelMulti.getPlayer1().isMyTurn());
	}

	@Test
	public void testTurnReverser() {
		assertNotEquals(GamePanelMulti.getPlayer1().isMyTurn(), GamePanelMulti.getPlayer2().isMyTurn());
	}

}

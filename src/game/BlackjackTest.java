package game;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;


public class BlackjackTest{
	
//	@Test
//	void mainTest() {
////		fail("Not yet implemented"); // TODO
//	}
	
	@Test
	void getCardTest() {
		int card = game.Blackjack.getCard();
		assertTrue("Error, card is too high", 11 >= card);
		assertTrue("Error, card is too low",  2  <= card);
		}

}
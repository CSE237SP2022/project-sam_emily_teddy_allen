package game;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;



public class BlackjackTest{
	
	@Test
	void getCardTest() {
		Blackjack game = new Blackjack();
		int card = game.getCard();
		assertTrue("Error, card is too high", 11 >= card);
		assertTrue("Error, card is too low",  2  <= card);
		}
	
	@Test
	void arraySumTest() {
		Blackjack game = new Blackjack();
		int [] testArray = new int [] {3,5,9};
		assertEquals(game.arraySum(testArray),17);
	}
	
	@Test
	void newCardTest() {//test that array of dealer cards is one greater than before
		Blackjack game = new Blackjack();
		int [] cards=new int [] {5,10,2};
		assertEquals(cards.length,game.newCard(cards).length-1);
	}
	
	@Test
	void dealerMoveTest() {
		Blackjack game = new Blackjack();
		int [] dealerCards = new int[] {10,10,1};
		int [] playerCards = new int[] {10,10,1};
		//assert that given equal hands at 21, the dealer will win (return statement on method is false)
		assertEquals(game.dealerMove(playerCards,dealerCards),false);
		
	}

}
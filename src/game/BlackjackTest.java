package game;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;



public class BlackjackTest{
	
	@Test
	void getCardTest() {
		int card = game.Blackjack.getCard();
		assertTrue("Error, card is too high", 11 >= card);
		assertTrue("Error, card is too low",  2  <= card);
		}
	
	@Test
	void arraySumTest() {
		int [] testArray = new int [] {3,5,9};
		assertEquals(game.Blackjack.arraySum(testArray),17);
	}
	
	
	@Test
	void newDealerCardTest() { //test that array of dealer cards is one greater than before
		int [] dealer_cards=new int [] {5,10,2};
		assertEquals(dealer_cards.length,game.Blackjack.newDealerCard(dealer_cards).length-1);
	}
	
	@Test
	void dealerMoveTest() {
		int [] dealerCards = new int[] {10,10,1};
		int [] playerCards = new int[] {10,10,1};
		//assert that given equal hands at 21, the dealer will win (return statement on method is false)
		assertEquals(game.Blackjack.dealerMove(playerCards,dealerCards),false);
		
	}

}
package game;
import java.util.Scanner;
import java.util.Arrays;



public class Blackjack {
	int [] playerCards;
	int [] dealerCards;
	int playerTotal;
	int dealerTotal;

	public Blackjack() {
		this.playerCards = new int [] {getCard(),getCard()};
		this.dealerCards = new int [] {getCard(),getCard()};
		this.playerTotal = arraySum(this.playerCards);
		this.dealerTotal = arraySum(this.dealerCards);
	}

	public void intro() {
		System.out.println("********************");
		System.out.println();
		System.out.println("This is Blackjack. Your goal is to get a sum from your cards as close "
				+ "to 21 as possible without going over it. If you hit you will take another card, "
				+ "otherwise you will keep your current cards. After your decision if you're closer"
				+ "to 21 than the dealer, you win!");
		displayPlayerCards();
	}
	public void displayPlayerCards() {
		System.out.println("********************");
		System.out.println();
		System.out.println("Your cards are "+Arrays.toString(playerCards)+" --> "+playerTotal);
	}
	public void play() {
		this.playerCards=playerTurn();
		this.playerTotal=arraySum(this.playerCards);
		if (this.playerTotal>21 || this.dealerTotal==21) {
			System.out.println("Over 21, dealer wins");
			return;
		}
		dealerMove(this.playerCards,this.dealerCards);
	}

	public int getCard() {	
		return (int) ((Math.random() * (10)) + 1);
	}

	public int arraySum(int [] cards) {
		int sum=0;
		for (int card:cards) {
			sum+=card;
		}
		return sum;
	}

	public int [] newCard(int [] cards) {
		int cardsAdded[] = new int[cards.length + 1];
		for (int i = 0; i < cards.length; i++)
			cardsAdded[i] = cards[i];
		cardsAdded[cardsAdded.length-1]=getCard();
		return cardsAdded;
	}

	public String playerInput() {
		System.out.println();
		System.out.println("Would you like to hit (y/n)?");
		Scanner scan = new Scanner(System.in);
		return scan.nextLine();
	}

	public void updatePlayerCards() {
		this.playerCards=newCard(this.playerCards);
		this.playerTotal = arraySum(this.playerCards);
		displayPlayerCards();

	}
	public int [] playerTurn() {

		while (true) {
			String input = playerInput();
			if(input.equals("n")) {
				return this.playerCards;
			}
			else if(input.equals("y")){
				updatePlayerCards();
			}
			if (this.playerTotal>21){
				return this.playerCards;
			}
		}

	}	

	public void displayDealer(int [] dealerCards, int dealerTotal) {
		System.out.println("********************");
		System.out.println();
		System.out.println("Dealer's starting cards are "+Arrays.toString(dealerCards)+" --> "+dealerTotal);
	}
	public void dealerDraw() {
		System.out.println("Dealer drawing again");
		dealerCards=newCard(dealerCards);
		dealerTotal=dealerTotal+dealerCards[dealerCards.length-1];
	}
	public boolean dealer() {

		while (true) {
			if (playerTotal>dealerTotal && playerTotal<=21) {
				dealerDraw();
				displayDealer(dealerCards,dealerTotal);
				if (dealerTotal>=playerTotal & dealerTotal<=21) {
					System.out.println("Dealer wins");
					return false;
				}
				else { 
					dealerDraw();
					displayDealer(dealerCards,dealerTotal);
				}
			}
			else if (dealerTotal<=21){
				displayDealer(dealerCards,dealerTotal);
				System.out.println("Dealer wins");
				return false;
			}
			else { 
				displayDealer(dealerCards,dealerTotal);
				System.out.println("Dealer busts, you win");
				return true;
			}
		}

	}

	public boolean dealerMove(int [] playerCards, int [] dealerCards) {
		int dealerTotal=arraySum(dealerCards);
		displayDealer(dealerCards,dealerTotal);
		return dealer();
	}

	public void main(String args[]) {
		intro();
		play();

	}


}

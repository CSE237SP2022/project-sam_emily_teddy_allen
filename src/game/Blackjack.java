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
	
	public static void main(String args[]) {
		System.out.println("********************");
		System.out.println();
		System.out.println("This is Blackjack. Your goal is to get a sum from your cards as close "
				+ "to 21 as possible without going over it. If you hit you will take another card, "
				+ "otherwise you will keep your current cards. After your decision if you're closer"
				+ "to 21 than the dealer, you win!");

		
		Blackjack game = new Blackjack();
		System.out.println("Your cards are "+Arrays.toString(game.playerCards)+" --> "+game.playerTotal);

		//game starts with player choosing if they want a card
		game.playerCards=newPlayerCard(game.playerCards);
		game.playerTotal=arraySum(game.playerCards);
	
		//if dealer has blackjack or you bust, dealer automatically wins
		if (game.playerTotal>21 || game.dealerTotal==21) {
			System.out.println("Over 21, dealer wins");
			return;
		}
		dealerMove(game.playerCards,game.dealerCards);
	}

	public int getCard() {	
		return (int) ((Math.random() * (10)) + 1);
	}
	
	public int arraySum(int [] arr) {
		int sum=0;
		for (int i:arr) {
			sum+=i;
		}
		return sum;
	}
	
  public int [] newCard(int [] cards) {
		int cardsAdded[] = new int[cards.length + 1];
		for (int i = 0; i < cards.length; i++)
			cardsAdded[i] = cards[i];
		return cardsAdded;
	}
	
	public int [] newPlayerCard(int [] cards) {
		
		boolean addCards=true;
		while (addCards) {
      System.out.println();
			System.out.println("Would you like to hit (y/n)?");
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			if (input.equals("y")) {
				cards=newCard(cards);
				System.out.println("Your current cards are "+Arrays.toString(cards)+" --> "+arraySum(cards));			
				if (arraySum(cards)>21){
					addCards=false;
				}
			}		
			else {
				addCards=false;
			}
		}
		return cards;
	}	

	public boolean dealerMove(int [] playerCards, int [] dealerCards) {
		boolean playerWins=false;
		boolean gameOver=false;
		int playerTotal=arraySum(playerCards);
		int dealerTotal=arraySum(dealerCards);
    System.out.println("********************");
		System.out.println();
		System.out.println("Dealer's starting cards are "+Arrays.toString(dealerCards)+" --> "+dealerTotal);
		while (gameOver==false) {
			if (playerTotal>dealerTotal & playerTotal<=21) { //dealer wants to play another card
				System.out.println("Dealer drawing again");
				dealerCards=newCard(dealerCards);
				dealerTotal=dealerTotal+dealerCards[dealerCards.length-1];
				if (dealerTotal>=playerTotal & dealerTotal<=21) {//dealer's next card wins
					System.out.println("Dealer cards are "+Arrays.toString(dealerCards)+" --> "+dealerTotal);
					System.out.println("Dealer wins");
					gameOver=true;
				}
				else { //dealer's next card doesn't win
					System.out.println("Dealer cards are "+Arrays.toString(dealerCards)+" --> "+dealerTotal);
					System.out.println("Dealer drawing again");
					dealerCards=newCard(dealerCards);
					dealerTotal=dealerTotal+dealerCards[dealerCards.length-1];
					gameOver=false;
				}
			}
			else if (dealerTotal<=21){//dealer doesn't want to play another card (dealer knows they win) and total<=21
				System.out.println("Dealer cards are "+Arrays.toString(dealerCards)+" --> "+dealerTotal);
				System.out.println("Dealer wins");
				gameOver=true;
			}
			else { //dealer busts
				System.out.println("Dealer cards are "+Arrays.toString(dealerCards)+" --> "+dealerTotal);
				System.out.println("Dealer busts, you win");
				gameOver=true;
				playerWins=true;
			}
		}
		return playerWins;
	}
	

}

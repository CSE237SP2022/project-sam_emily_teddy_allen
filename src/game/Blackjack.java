package game;
import java.util.Scanner;
import java.util.Arrays;



public class Blackjack {
	int [] playerCards;
	int [] houseCards;
	int playerTotal;
	int houseTotal;
	
	public Blackjack() {
		this.playerCards = new int [] {getCard(),getCard()};
		this.houseCards = new int [] {getCard(),getCard()};
		this.playerTotal = arraySum(this.playerCards);
		this.houseTotal = arraySum(this.houseCards);
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
		if (game.playerTotal>21 || game.houseTotal==21) {
			System.out.println("Over 21, dealer wins");
			return;
		}
		dealerMove(game.playerCards,game.houseCards);
	}

	public static int getCard() {
		
		return (int) ((Math.random() * (10)) + 1);
	}
	
	public static int arraySum(int [] arr) {
		
		int sum=0;
		for (int i:arr) {
			sum+=i;
		}
		return sum;
	}
	
	public static int [] newPlayerCard(int [] cards) {
		;
		boolean add_cards=true;
		while (add_cards) {
			System.out.println();
			System.out.println("Would you like to hit (y/n)?");
			Scanner scan2 = new Scanner(System.in);
			String result2 = scan2.nextLine();

			
			if (result2.equals("y")) {
				int cards_added[] = new int[cards.length + 1];
				for (int i = 0; i < cards.length; i++)
					cards_added[i] = cards[i];

				cards_added[cards_added.length-1] = getCard();
				cards=cards_added;
				System.out.println("Your current cards are "+Arrays.toString(cards)+" --> "+arraySum(cards));
				
				if (arraySum(cards)>21){
					add_cards=false;
				}
			}
			
			
			else {
				add_cards=false;
			}
		}
		return cards;
	}
	
	public static int [] newDealerCard(int [] cards) {
		
		int cards_added[] = new int[cards.length + 1];
		for (int i = 0; i < cards.length; i++)
			cards_added[i] = cards[i];

		cards_added[cards_added.length-1] = getCard();
		return cards_added;
		
		}

	public static boolean dealerMove(int [] player_cards, int [] house_cards) {
		boolean playerWins=false;
		boolean gameOver=false;
		int player_total=arraySum(player_cards);
		int house_total=arraySum(house_cards);
		System.out.println("********************");
		System.out.println();
		System.out.println("Dealer's starting cards are "+Arrays.toString(house_cards)+" --> "+house_total);

		while (gameOver==false) {
			System.out.println();

			if (player_total>house_total & player_total<=21) { //dealer wants to play another card
				System.out.println("Dealer drawing again");
				house_cards=newDealerCard(house_cards);
				house_total=house_total+house_cards[house_cards.length-1];

				if (house_total>=player_total & house_total<=21) {//dealer's next card wins
					System.out.println("Dealer cards are "+Arrays.toString(house_cards)+" --> "+house_total);
					System.out.println("Dealer wins");
					gameOver=true;
				}
				else { //dealer's next card doesn't win
					System.out.println("Dealer cards are "+Arrays.toString(house_cards)+" --> "+house_total);
					System.out.println("Dealer drawing again");
					house_cards=newDealerCard(house_cards);
					house_total=house_total+house_cards[house_cards.length-1];
					gameOver=false;
				}
			}
			else if (house_total<=21){//dealer doesn't want to play another card (dealer knows they win) and total<=21
				System.out.println("Dealer cards are "+Arrays.toString(house_cards)+" --> "+house_total);
				System.out.println("Dealer wins");
				gameOver=true;
			}
			else { //dealer busts
				System.out.println("Dealer cards are "+Arrays.toString(house_cards)+" --> "+house_total);
				System.out.println("Dealer busts, you win");
				gameOver=true;
				playerWins=true;
			}
		}
		return playerWins;
	}

}

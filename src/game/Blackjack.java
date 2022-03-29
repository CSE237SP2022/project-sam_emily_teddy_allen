package game;
import java.util.Scanner;


public class Blackjack {

	public static void main(String[] args) {
		int player_card1=getCard();
		int player_card2=getCard();
		int house_card1=getCard();
		int house_card2=getCard();
		
		int player_total=player_card1+player_card2;
		int house_total=house_card1+house_card2;
		System.out.println("Your cards are "+player_card1+" and "+player_card2);
		
		//if dealer has blackjack or you bust, dealer automatically wins
		if (player_total>21 || house_total==21) {
			System.out.println("Dealer wins");
			return;
		}
		
		//if dealer busts, you automatically win
		if (house_total>21) {
			System.out.println("You win");
			return;
		}
		
		//prompt user if they want another card
		Scanner scan = new Scanner(System.in);
	    System.out.println("Would you like to hit (y/n)?");
		String hit = scan.nextLine();
		scan.close();
		
		if (hit.equals("y")) { //user wants another card
			int player_card3=getCard();
			player_total=player_total+player_card3;
			System.out.println("Your cards are "+player_card1+", "+player_card2+" and "+player_card3);
			
			if (player_total>house_total & player_total<=21) { //dealer wants to play another card
				int house_card3=getCard();
				house_total=house_total+house_card3;
				if (house_total>player_total & house_total<=21) {//dealer's third card wins
					System.out.println("Dealer cards are "+house_card1+", "+house_card2+" and "+house_card3);
					System.out.println("Dealer wins");
				}
				else { //dealer's third card doesn't win
					System.out.println("Dealer cards are "+house_card1+", "+house_card2+" and "+house_card3);
					System.out.println("You win");
				}
			}
			else {//dealer doesn't want to play another card (dealer knows they win)
				System.out.println("Dealer cards are "+house_card1+" and "+house_card2);
				System.out.println("Dealer wins");
			}
		}
		else {//user wants to stay
			System.out.println("Deal cards are "+house_card1+", "+house_card2);

			if (player_total>house_total & player_total<=21) { //dealer wants to play another card
				int house_card3=getCard();
				house_total=house_total+house_card3;
				if (house_total>player_total & house_total<=21) {//dealer's third card wins
					System.out.println("Dealer cards are "+house_card1+", "+house_card2+" and "+house_card3);
					System.out.println("Dealer wins");
				}
				else { //dealer's third card doesn't win
					System.out.println("Dealer cards are "+house_card1+", "+house_card2+" and "+house_card3);
					System.out.println("You win");
				}
			}
			else {//dealer doesn't want to play another card (dealer knows they win)
				System.out.println("Dealer cards are "+house_card1+" and "+house_card2);
				System.out.println("Dealer wins");
			}
		}
	}

	public static int getCard() {
		return (int) ((Math.random() * (10)) + 1);
	}

}

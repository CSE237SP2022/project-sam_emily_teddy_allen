package game;
import java.util.Scanner;
public class DiceGame {
	private  int humanLives;
	private int cpuDice;
	private int sum;
	private Scanner scan;


	public DiceGame() { //constructor to create dice game and set initial lives/dice
		this.humanLives=3;
		this.cpuDice=6;
		this.sum=0;
		this.scan=new Scanner(System.in);
	}
	
	private int randomNumber(int min, int max) { //generate random number between min and max
		double randomNumber=Math.floor(max*Math.random())+1;
		return (int) randomNumber;
		
	}

	private int [] getDice() { //get set of dice using current number of cpu dice
		int [] diceRoll= new int [cpuDice];
		for(int i=0;i<cpuDice;i++) {
			diceRoll[i]=randomNumber(1,6);
		};
		return diceRoll;
	}
	private int sumDice(int [] dice) { //returns sum of the current dice roll from getDice()
		int sum=0;
		for(int diceValue: dice) {
			sum+=diceValue;
		}
		return sum;
	}
	private int cpuAnswer(int sum) { //return the answer for the cpu if its a lie or true
		if(Math.random()<0.5) {
			int lie=randomNumber(cpuDice,sum);
			return lie;
		}
		else {
			return sum;
		}
		
		
	}
	private Boolean humanChoice(int cpuGuess){ //processes the human turn returning true if they believe the cpu and false if not. Also has help() function if the player needs instructions
		while(true) {
			System.out.println("CPU says sum is "+cpuGuess+". Do you believe them? Enter y for Yes n for No. Type Help! for instructions");
			String humanResponse=scan.nextLine();
			if(humanResponse.equals("y")) {
				return true;
			}
			if(humanResponse.equals("n")) {
				return false;
			}
			if(humanResponse.equals("Help!")) {
				help();
			}
		}


	}
	private void help() {//prints out rules to game
		System.out.println("This is a dice game similar to liars dice or cheat. A cpu will roll dice and provide a sum. A player can choose to believe the CPU or doubt them. If they are correct, the cpu will lose a dice (starting from 6), if not, the player will lose a life (they start with 3).");
	}

	private boolean nextTurn() { //processes a turn and returns true if the player correctly guesses and false if not
		System.out.println("CPU has " + cpuDice + " dice left. Player has " + humanLives + " lives left");
		Boolean humanWin=false;
		int [] cpuDice=getDice();
		sum=sumDice(cpuDice);
		int cpuGuess=cpuAnswer(sum);
		Boolean humanResponse=humanChoice(cpuGuess);
		if(humanResponse) {	
			if(sum==cpuGuess) {
				humanWin=true;
			}
		}
		else {
			if(sum!=cpuGuess) {
				humanWin=true;
			}

		}
		System.out.println("CPU had a sum of "+sum);
		return humanWin;

	}


	public boolean play() { //plays the game by processing turns until either the human is out of lives or cpu out of dice. If the player wins, it returns true, if not it returns false.
		help();
		while(humanLives>0&&cpuDice>0) {
			Boolean resultOfTurn=nextTurn();
			if(resultOfTurn) {
				cpuDice--;
			}
			else {
				humanLives--;
			}
		}
		boolean winner=getWinner();
		
		
		return winner;
	}



	private boolean getWinner() { //gets winner by comparing number of dice to number of lives. Returns true if human wins, false if not.
		if(humanLives>0) {
			return true;
		}
		else {
			return false;
		}
	}


}

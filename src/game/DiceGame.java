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
	

	public int randomNumber(int max) { //generate random number up to max number from 1

		double randomNumber=Math.floor(max*Math.random())+1;
		return (int) randomNumber;
		
	}


	public int [] getDice() { //get set of dice using current number of cpu dice

		int [] diceRoll= new int [cpuDice];
		for(int i=0;i<cpuDice;i++) {
			diceRoll[i]=randomNumber(6);
		};
		return diceRoll;
	}

	public int sumDice(int [] dice) { //returns sum of the current dice roll from getDice()

		int sum=0;
		for(int diceValue: dice) {
			sum+=diceValue;
		}
		return sum;
	}

	private double cpuRisk() {
		double riskCalculation=1;
		if(cpuDice>4) {
			riskCalculation=0.5;
		}
		if(cpuDice<3) {
			riskCalculation=3.0;
		}
		return riskCalculation;
	}
	private double humanFactor() {
		double humanRisk=1;
		if(cpuDice>humanLives) {
			humanRisk=2.0;
		}
		return humanRisk;
	}
	private int cpuAnswer(int sum) { //return the answer for the cpu if its a lie or true
		double cpuRisk=cpuRisk();
		double humanRisk=humanFactor();
		double cpuRoll=(Math.random()*cpuRisk)/humanRisk;
		if(cpuRoll<0.5) {
			int lie=randomNumber(sum);
			return lie;
		}
		else {
			return sum;
		}
		
		
	}
	private Boolean humanChoice(int cpuGuess){ //processes the human turn returning true if they believe the cpu and false if not. Also has help() function if the player needs instructions
		while(true) {
			printBarrier();
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
	private void help() {
		System.out.println("This is a dice game similar to liars dice or cheat. A cpu will roll dice and provide a sum. A player can choose to believe the CPU or doubt them. If they are correct, the cpu will lose a dice (starting from 6), if not, the player will lose a life (they start with 3).");
	}
	
	private boolean processWin(int cpuGuess,boolean humanResponse) {
		if(humanResponse) {	
			if(sum==cpuGuess) {
				return true;
			}
		}
		else {
			if(sum!=cpuGuess) {
				return true;
			}

		}
		return false;
	}
	

	private boolean nextTurn() {
		printBarrier();
		System.out.println("CPU has " + cpuDice + " dice left. Player has " + humanLives + " lives left");
		int [] cpuDice=getDice();
		sum=sumDice(cpuDice);
		int cpuGuess=cpuAnswer(sum);
		Boolean humanResponse=humanChoice(cpuGuess);
		Boolean humanWin=processWin(cpuGuess,humanResponse);
		System.out.println("CPU had a sum of "+sum);
		return humanWin;

	}
	
	private void printBarrier() {
		System.out.println();
		System.out.println("********************");
		System.out.println();
	}


	public boolean play() {
		printBarrier();
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
		
		return getWinner();
	}



	private boolean getWinner() { 
		if(humanLives>0) {
			return true;
		}
		else {
			return false;
		}
	}


}

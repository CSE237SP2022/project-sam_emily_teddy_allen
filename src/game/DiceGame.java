package game;
import java.util.Scanner;
public class DiceGame {
	private  int humanLives;
	private int cpuDice;
	private int sum;
	private Scanner scan;


	public DiceGame() {
		this.humanLives=3;
		this.cpuDice=6;
		this.sum=0;
		this.scan=new Scanner(System.in);
	}

	int [] getDice() {
		int [] diceRoll= new int [cpuDice];
		for(int i=0;i<cpuDice;i++) {
			diceRoll[i]=(int) Math.floor(6*Math.random()+1);
		};
		return diceRoll;
	}
	int sumDice(int [] dice) {
		int sum=0;
		for(int diceValue: dice) {
			sum+=diceValue;
		}
		return sum;
	}
	int cpuAnswer(int sum) {
		if(Math.random()<0.5) {
			int lie= (int) Math.floor(sum*Math.random()+1);
			return lie;
		}
		else {
			return sum;
		}
		
		
	}
	Boolean humanChoice(int cpuGuess){
		while(true) {
			System.out.println("CPU says sum is "+cpuGuess+". Do you believe them? 1 for yes 0 for no. Type Help! for instructions");
			String humanResponse=scan.nextLine();
			if(humanResponse.equals("1")) {
				return true;
			}
			if(humanResponse.equals("0")) {
				return false;
			}
			if(humanResponse.equals("Help!")) {
				help();
			}
		}


	}
	public void help() {
		System.out.println("This is a dice game similar to liars dice or cheat. A cpu will roll dice and provide a sum. A player can choose to believe the CPU or doubt them. If they are correct, the cpu will lose a dice (starting from 6), if not, the player will lose a life (they start with 3).");
	}

	public boolean nextTurn() {
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


	public boolean play() {
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
		
		scan.close();
		return winner;
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

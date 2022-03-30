package game;
import java.util.Scanner;

public class Game {
	
	public Player player;
	
	public Game() {
	
	}
	
	public void createCharacter() {
		Scanner scan = new Scanner(System.in);
	    System.out.println("What is your name?");
		String name = scan.nextLine();
		Player player= new Player(name);
		this.player = player;
		System.out.println("Hello "+ player.getName()+" please enter anything to continue");
		scan.nextLine();
		System.out.println("Starting game");
		System.out.println("");
	}
	
	
	public void intro() {
		createCharacter();
	}
	
	public void battle() {
		Enemy enemy = new Enemy(100,50,"Monster");
		Battle battle = new Battle(player,enemy);
		battle.fight();
	}
	
}

package game;
import java.util.Scanner;

public class Game {
	
	public static void createCharacter() {
		Scanner scan = new Scanner(System.in);
	    System.out.println("What is your name?");
		String name = scan.nextLine();
		Player player= new Player(name);
		System.out.println("Hello "+ player.getName()+" please enter anything to continue");
		scan.nextLine();
		scan.close();
		System.out.println("Starting game");
	}
	
	
	public static void intro() {
		createCharacter();
		
		
	}
	
	public static void main(String[] args) {
		
		intro();
	}
}

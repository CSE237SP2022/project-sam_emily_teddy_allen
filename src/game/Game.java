package game;
import java.util.HashMap;
import java.util.Scanner;

public class Game {
	
	private static Player player1;
	private static int progress;
	
	static Scanner scan = new Scanner(System.in);
	
	public Game() { //create a character with the given player name
		// TODO Auto-generated constructor stub
		player1 = null;
		progress = 0;
	}
	
	public Player getPlayer() //helper to return player
	{
		return player1;
	}
	
	public int getProgress()
	{
		return progress;
	}
	
	public static void createCharacter() {
	    System.out.println("What is your name?");
		String name = scan.nextLine();
		player1 = new Player(name);
		System.out.println("Hello "+ player1.getName()+" please enter anything to continue");
		scan.nextLine();

		System.out.println("Starting game");
	}
	
	
	public static void intro() {
		createCharacter();
//		DiceGame game=new DiceGame();
//		game.play();
	
		
	}
	
	public static int start() {
		System.out.println("You begin your journey in the woods. Trees extend in every direction. "
				+ "Upon closer inspection you notice two trails that seemed to be stamped out "
				+ "across the ground. Do you choose the path to the left or the right?");
		System.out.println("Left (Enter 'L')");
		System.out.println("Right (Enter 'R')");
		String choice = scan.nextLine();
		progress = 0;
		while(progress == 0)
		{
			if(choice.equals("L"))
			{
				return 1;
			}
			else if(choice.equals("R"))
			{
				return 2;
			}
			else
			{
				System.out.println("Please Enter 'L' or 'R'");
				choice = scan.nextLine();
			}
		}
		return 0;
	}
	
	public static int hooded() {
		
		System.out.println("You head down the path and notice a hooded figure "
				+ "in the distance. As the hooded figure becomes more defined, you notice they're "
				+ "facing your direction and their hand is out. Within it, you view two dice and "
				+ "suddenly the figure utters in a high, nasally voice 'Wanna play with my dice'?");
		System.out.println("");
		System.out.println("Yes (Enter 'Y')");
		System.out.println("");
		System.out.println("No (Enter 'N')");
		System.out.println("");
		
		String choice = scan.nextLine();
		while(progress == 1)
		{
			if(choice.equals("Y"))
			{
				return 3;
			}
			else if(choice.equals("N"))
			{
				return 4;
			}
			else
			{
				System.out.println("Please Enter 'Y' or 'N'");
				System.out.println("");
				choice = scan.nextLine();
			}
		}
		return 1;
	}
	
	public static int elf() {
		
		System.out.println("You head down the path. Your hear ruffling in the trees "
				+ "above you. As you look up, an elf-like creature falls down in front of you. "
				+ "'BET YOU CAN'T BEAT ME IN CARDS' he shouts. ");
		System.out.println("");
		System.out.println("'YES I CAN!' (Enter 'Y')");
		System.out.println("");
		System.out.println("Run away (Enter 'N')");
		System.out.println("");
		
		String choice = scan.nextLine();
		while(progress == 2)
		{
			if(choice.equals("Y"))
			{
				return 5;
			}
			else if(choice.equals("N"))
			{
				System.out.println("You run back to the left path. ");
				System.out.println("");
				return 1;
			}
			else
			{
				System.out.println("Please Enter 'Y' or 'N'");
				System.out.println("");
				choice = scan.nextLine();
			}
		}
		return 2;
		
	}
	
	public static int dice() {
		DiceGame game = new DiceGame();
		boolean win = game.play();
		if(win)
		{
			return 7;
		}
		else
		{
			System.out.println("You have lost. You glance towards the hooded figure in "
					+ "defeat.");
			System.out.println("");
			return 4;
		}
	}
	
	public static int combat() {
		System.out.println("They suddenly morph into a monster and attack you!");
		System.out.println("");
		//combat sequence
		
		Player enemy = new Player("Monster");
		Battle battle = new Battle(player1, enemy);
		int endCon = battle.fight();
		if(endCon == 0) // Enemy died
		{
			return 7;
		}
		else if(endCon == 1) // You ran
		{
			return 9;
		}
		else if(endCon == 2) // Enemy ran
		{
			return 2;
		}
		else // You died
		{
			System.out.println("You were slain by your foe. Unfortunately, your journey "
					+ "stops here...");
			System.out.println("");
			return 10;
		}
		
	}
	
	public static int cards() {
		//card game
		String [] cards = new String[10];
		Blackjack.main(cards);
		
		return 6;
	}
	
	public static int happy_elf() {
		System.out.println("After finishing the game, your new friend seems pleased. "
				+ "'Thank you for playing with me!', he grins and gestures for you to "
				+ "follow him. He leads you to a path that seems to lead out of the forest. "
				+ "'Right this way and you'll be free!'");
		System.out.println("");
		return 8;
	}
	
	public static int defeat_enemy() {
		System.out.println("Upon defeat, the enemy screeches in pain and fades "
				+ "away into a dark mist. The mist blows through the tress in front of "
				+ "you revealing a path out of the forest.");
		System.out.println("");
		return 8;
	}
	
	public static int win() {
		System.out.println("After following the path, you "
				+ "are relieved to see you are home. Your journey is now complete. You Win!");
		System.out.println("");
		return 10;
	}
	
	public static int lost() {
		System.out.println("You ran as fast as you could, losing sight of the things around you. "
				+ "After a few minutes, you realize you're no longer able to find the paths that "
				+ "were once in front of you. With no sense of direction you wander the forest, "
				+ "lost, for all eternity...");
		System.out.println("");
		return 10;
	}
	
	public static void story() {
		
		int progress = 0;

		while(progress < 10)
		{
			if(progress == 0) //Start
			{
				progress = start();
			}
			if(progress == 1) //Hooded Figure
			{
				progress = hooded();
			}
			
			if(progress == 2) //Elf
			{
				progress =  elf();
			}
			
			if(progress == 3) //Dice
			{
				progress = dice();
			}
			
			if(progress == 4) //Combat
			{
				progress = combat();
			}
			
			if(progress == 5) //Cards
			{
				progress = cards();
			}
			if(progress == 6) //Happy Elf
			{
				progress = happy_elf();
			}
			if(progress == 7) //Defeat Enemy
			{
				progress = defeat_enemy();
			}
			if(progress == 8) //Win
			{
				progress = win();
			}
			if(progress == 9) //Lost
			{
				progress = lost();
			}
		}
		
		System.out.println("The End");
		scan.close();
	}
	
	public static void main(String[] args) {
		intro();
		story();
	}
}

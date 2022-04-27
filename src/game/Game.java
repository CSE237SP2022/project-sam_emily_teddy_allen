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
		System.out.println("Hello "+ player1.getName());

		System.out.println("Starting game");
		System.out.println("");
	}


	public static void intro() {
		createCharacter();
	}

	public static void choose() {
		System.out.println("");
		System.out.println("Yes (Enter 'Y')");
		System.out.println("");
		System.out.println("No (Enter 'N')");
		System.out.println("");
		System.out.println("Use Items? (Enter 'Items')");
		System.out.println("");
	}

	public static void begin()
	{
		System.out.println("You wake up in the woods. "
				+ "As you open your eyes and notice a building in front of you. "
				+ "The sign says 'Store'. You reach into your pocket and feel a little "
				+ "bit of pocket change. You're not sure where you are, but you figure "
				+ "it might not be a bad idea to stock up on something before you try "
				+ "to find your way out. So you head in.");
		shop();
	}

	public static int start() {
		System.out.println("You begin your journey in the woods. Trees extend in every direction. "
				+ "Upon closer inspection you notice two trails that seemed to be stamped out "
				+ "across the ground. Do you choose the path to travel the path to the left?");
		choose();
		if(scanInput())
		{
			return 1;
		}
		else
		{
			return 2;
		}

	}

	public static int hooded() {

		System.out.println("You head down the path and notice a hooded figure "
				+ "in the distance. As the hooded figure becomes more defined, you notice they're "
				+ "facing your direction and their hand is out. Within it, you view two dice and "
				+ "suddenly the figure utters in a high, nasally voice 'Wanna play with my dice'?");

		choose();
		if(scanInput())
		{
			return 3;
		}
		else
		{
			return 4;
		}
	}

	public static int elf() {

		System.out.println("You head down the path. Your hear ruffling in the trees "
				+ "above you. As you look up, an elf-like creature falls down in front of you. "
				+ "'BET YOU CAN'T BEAT ME IN CARDS' he shouts. Do you want to try?");
		choose();
		if(scanInput())
		{
			return 5;
		}
		else
		{
			System.out.println("You run back to the left path. ");
			System.out.println("");
			return 1;
		}	
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

	public static int battle() {
		Player enemy = new Player("Monster");
		Battle battle = new Battle(player1, enemy);
		return battle.fight();
	}

	public static int combat() {
		System.out.println("They suddenly morph into a monster and attack you!");
		System.out.println("");
		//combat sequence
		int endCon = battle();

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
			return 12;
		}

	}
	public static void blackjack()
	{
		String [] cards = new String[10];
		Blackjack blackjack = new Blackjack();
		blackjack.main(cards);
	}

	public static int cards() {
		//card game
		blackjack();
		return 6;
	}

	public static int happy_elf() {
		System.out.println("After finishing the game, your new friend seems pleased. "
				+ "'Thank you for playing with me!', he grins and gestures for you to "
				+ "follow him. He leads you to a path that seems to lead to and opening in the trees. "
				+ "'Right this way!'");
		System.out.println("");
		return 10;
	}

	public static int defeat_enemy() {
		System.out.println("Upon defeat, the enemy screeches in pain and fades "
				+ "away into a dark mist. The mist blows through the tress in front of "
				+ "you revealing a path towards and opening in the trees.");
		System.out.println("");
		return 10;
	}

	public static int win() {
		System.out.println("After following the path, you "
				+ "are relieved to see you are home. Your journey is now complete. You Win!");
		System.out.println("");
		return 12;
	}

	public static int lost() {
		System.out.println("You ran as fast as you could, losing sight of the things around you. "
				+ "After a few minutes, you realize you're no longer able to find the paths that "
				+ "were once in front of you. With no sense of direction you wander the forest, "
				+ "lost, for all eternity...");
		System.out.println("");
		return 12;
	}

	public static int store() {
		System.out.println("You arrive at an opening and see a small log cabin before you. "
				+ "A dilapidated sign is hanging above a doorway that says 'SHOP'. Interested, "
				+ "you decide to head inside.");
		System.out.println("");
		return 11;
	}

	public static int shop() {
		Store shopping = new Store(player1);
		shopping.enter();
		return 8;
	}

	public static void part1()
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
	}
	
	public static void part2()
	{
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
	}
	
	public static void part3()
	{
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
	}
	
	public static void part4()
	{
		if(progress == 9) //Lost
		{
			progress = lost();
		}
		if(progress == 10) //Store
		{
			progress = store();
		}
		if(progress == 11) //Shop
		{
			progress = shop();
		}
	}
	
	public static void story() {
		while(progress < 12)
		{
			
			if(progress >= 2)
			{
				part1();
			}
			if(progress >= 5 && progress <= 3)
			{
				part2();
			}
			if(progress >= 8 && progress <= 6)
			{
				part3();
			}
			if(progress >= 9 && progress <= 11)
			{
				part4();
			}
		}

		System.out.println("The End");
		end();
		scan.close();
	}
	public static void end() {
		boolean playAgain=playAgain();
		if(playAgain) {
			play();
		}
	}
	public static boolean playAgain() {
		System.out.println("Do you want to play again? Y for yes N for no");
		return scanInput();
		
	}
	public static void getItemChoice(){
		System.out.println("Which item do you want to use?");
		String choice = scan.nextLine();
		player1.checkItem(choice);
	}


	public static void items() {
		player1.showItems();
		getItemChoice();
	}

	public static boolean scanInput()
	{
		boolean valid = false;
		while(valid == false)
		{
			String choice = scan.nextLine();
			if(choice.equals("Y"))
			{
				return true;
			}
			else if(choice.equals("N"))
			
			{
				return false;
			}else if (choice.equals("Items")) {
				items();
			}
			if(!valid) {
				System.out.println("Please Enter 'Y' or 'N'");
			}
		}
		return false;
	}
	
	public static void play() {
		intro();
		begin();
		story();
	}

	public static void main(String[] args) {//let's try separating out more functions to call in here
		//let's make a scanProg function that takes in the progress value, performs scan and returns
		//the new progress accordingly. Then we can call it in here as many times as necessary maybe?
		//Employ a while loop in here with a boolean to check with scanProg is necessary, that way
		//it's called as many times as it's needed. This should separate out our scanner.
		play();
	}
}

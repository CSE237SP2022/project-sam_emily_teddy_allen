package game;
import java.util.Scanner;

public class Game {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void createCharacter() {
	    System.out.println("What is your name?");
		String name = scan.nextLine();
		Player player = new Player(name);
		System.out.println("Hello "+ player.getName()+" please enter anything to continue");
		scan.nextLine();

		System.out.println("Starting game");
	}
	
	
	public static void intro() {
		createCharacter();
//		DiceGame game=new DiceGame();
//		game.play();
	
		
	}
	
	public static void story() {
		
		int progress = 0;

		while(progress < 5)
		{
			if(progress == 0)
			{
				System.out.println("You begin your journey in the woods. Trees extend in every direction. "
						+ "Upon closer inspection you notice two trails that seemed to be stamped out "
						+ "across the ground. Do you choose the path to the left or the right?");
				System.out.println("Left (Enter 'L')");
				System.out.println("Right (Enter 'R')");
				
				String choice = scan.nextLine();
				while(progress == 0)
				{
					if(choice.equals("L"))
					{
						progress = 1;
					}
					else if(choice.equals("R"))
					{
						progress = 2;
					}
					else
					{
						System.out.println("Please Enter 'L' or 'R'");
						choice = scan.nextLine();
					}
				}
				
			}
			if(progress == 1)
			{
				System.out.println("You head down the left path and notice a hooded figure "
						+ "in the distance. As the hooded figure becomes more defined, you notice they're "
						+ "facing your direction and their hand is out. Within it, you view two dice and "
						+ "suddenly the figure utters in a high, nasally voice 'Wanna play with my dice'?");
				System.out.println("Yes (Enter 'Y')");
				System.out.println("No (Enter 'N')");
				
				String choice = scan.nextLine();
				while(progress == 1)
				{
					if(choice.equals("Y"))
					{
						progress = 3;
					}
					else if(choice.equals("N"))
					{
						progress = 4;
					}
					else
					{
						System.out.println("Please Enter 'Y' or 'N'");
						choice = scan.nextLine();
					}
				}
			}
			
			if(progress == 2)
			{
				System.out.println("You start down the right path. Your hear ruffling in the trees "
						+ "above you. As you look up, a elf-like creature falls down in front of you. "
						+ "'BET YOU CAN'T BEAT ME IN CARDS' he shouts. ");
				System.out.println("'YES I CAN!' (Enter 'Y')");
				System.out.println("'You're right. I'm bad at cards' (Enter 'N')");
				System.out.println("Run away to the left (Enter 'R')");
				
				String choice = scan.nextLine();
				while(progress == 2)
				{
					if(choice.equals("Y"))
					{
						progress = 5;
					}
					else if(choice.equals("N"))
					{
						progress = 4;
					}
					else if(choice.equals("R"))
					{
						progress = 3;
					}
					else
					{
						System.out.println("Please Enter 'Y' or 'N'");
						choice = scan.nextLine();
					}
				}
				
			}
			
			if(progress == 3)
			{
				DiceGame game = new DiceGame();
				boolean win = game.play();
				if(win)
				{
					progress = 7;
				}
				else
				{
					System.out.println("You have lost. You glance towards the hooded figure in "
							+ "defeat.");
					progress = 4;
				}
			}
			
			if(progress == 4)
			{
				System.out.println("They suddenly morph into a monster and attack you!");
				//combat sequence
				
				Player enemy = new Player("Monster");
				//Battle battle = new Battle(this.player, enemy);
				//battle.fight();
				progress = 6;
			}
			
			if(progress == 5)
			{
				//play card game
				progress = 6;
			}
			if(progress == 6)
			{
				
			}
			if(progress == 7)
			{
				System.out.println("Upon defeat, the enemy screeches in pain and fades "
						+ "away into a dark mist. The mist blows through the tress in front of "
						+ "you revealing a path out of the forest. After following this path, you "
						+ "are relieved to see you are home. Your journey is now complete. You Win!");
			}
		}
		
		System.out.print("The End");
		scan.close();
	}
	
	public static void main(String[] args) {
		
		intro();
		story();
		
		//combat();
	}
}

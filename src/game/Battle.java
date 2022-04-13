package game;

import java.util.Scanner;

public class Battle {
	
	private Player enemy;
	private Player player;
	private boolean fighting;
	public String winner;
	public int endCon;
	
	public Battle(Player player, Player enemy) {
		this.player = player;
		this.enemy = enemy;
		this.fighting = true;
	}
	
	
	public int fight() {
		System.out.println(player.getName() + " vs. " + enemy.getName());
		playerTurn();
		System.out.println("Battle is over");
		return endCon;
		
	}
	
	
	private void playerTurn() {
	
		while(this.fighting) {
			Scanner scan = new Scanner(System.in);
			System.out.println("********************");
			System.out.println();
			System.out.println("Player has "+ player.getHealth()+" health while monster has " +enemy.getHealth());
			System.out.println(player.getName() + "'s Turn. Will you attack or run?");
			String move = scan.nextLine();
	
			if(move.equals("attack")) {
				System.out.println("You attacked and dealt "+player.getAttackStat()+" damage");
				enemy.health = enemy.health - player.getAttackStat();
				
			} else if(move.equals("run")) {
				System.out.println("You ran.");
				endCon = 1;
				this.winner = "No winner";
				this.fighting = false;
				
			} else {
				System.out.println("You missed your turn");
			}
			
			if(enemy.getHealth() == 0) {
				System.out.println("You win!");
				this.player.levelUp();
				int coins = 10;
				this.player.addMoney(coins);
				System.out.println("You leveled up! You are now level " + player.getLevel());
				System.out.println("Your attack now does " + player.getAttackStat() + " damage.");
				System.out.println("You won " + coins + " coins. You now have " + player.money + " coins");
				scan.close();
				endCon = 0;
				this.winner = player.getName();
				this.fighting = false;
			} else {
				enemyTurn();
			}
		}
	}
	
	private void enemyTurn() {
		while(this.fighting) {
			System.out.println("********************");
			System.out.println();
			System.out.println(enemy.getName() + "'s turn.");
			double move = Math.random();
			if(move < 0.75) {
				System.out.println(enemy.getName() + " attacked.");
				player.health = player.health - 25;
			} else {
				System.out.println(enemy.getName() + " ran away");
				endCon = 2;
				this.winner = "No winner";
				this.fighting = false;
			}
			
			if(player.getHealth() == 0) {
				System.out.println("The monster wins. You lose!");
				System.out.println("");
				endCon = 3;
				this.winner = enemy.getName();
				this.fighting = false;
			} else {
				playerTurn();
			}
		}
		
	}

}

package game;

import java.util.Scanner;

public class Battle {
	
	private Enemy enemy;
	private Player player;
	private boolean fighting;
	public String winner;
	
	public Battle(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
		this.fighting = true;
	}
	
	/*
		TODO: - Get rid of enemy class -> use Player class instead
	*/
	public void fight() {
		System.out.println(player.getName() + " vs. " + enemy.getMonsterName());
		playerTurn();
		System.out.println("Battle is over");
		System.out.println("");
	}
	
	
	private void playerTurn() {
	
		while(this.fighting) {
			Scanner scan = new Scanner(System.in);
			System.out.println("********************");
			System.out.println(player.getName() + "'s Turn. Will you attack or run?");
			String move = scan.nextLine();
	
			if(move.equals("attack")) {
				System.out.println("You attacked.");
				enemy.hp = enemy.hp - player.getAttackStat();
				
			} else if(move.equals("run")) {
				System.out.println("You ran.");
				this.winner = "No winner";
				this.fighting = false;
				
			} else {
				System.out.println("You missed your turn");
			}
			
			if(enemy.getHp() == 0) {
				System.out.println("You win!");
				scan.close();
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
			System.out.println(enemy.getMonsterName() + "'s turn.");
			double move = Math.random();
			if(move < 0.75) {
				System.out.println(enemy.getMonsterName() + " attacked.");
				player.health = player.health - 25;
			} else {
				System.out.println(enemy.getMonsterName() + " ran away");
				this.winner = "No winner";
				this.fighting = false;
			}
			
			if(player.getHealth() == 0) {
				System.out.println("The monster wins. You lose!");
				System.out.println("");
				this.winner = enemy.getMonsterName();
				this.fighting = false;
			} else {
				playerTurn();
			}
		}
		
	}

}

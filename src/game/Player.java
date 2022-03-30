package game;
import java.util.LinkedList; //gonna add magic to this

public class Player {
	private String name;
	private int level;
	private int attackStat;
	public int health;
	

	public Player(String playerName) {
		// TODO Auto-generated constructor stub
		this.name=playerName;
		this.level=1;
		this.attackStat=5;
		this.health=100;
	}
	public String getName() {
		return name;
	}
	public int getLevel() {
		return level;
	}
	public double getHealth() {
		return health;
	}
	public int getAttackStat() {
		return this.level*25;
	}

}

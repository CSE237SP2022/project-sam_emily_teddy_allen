package game;
import java.util.HashMap;
import java.util.LinkedList; //gonna add magic to this

public class Player {
	private String name;
	private int level;
	private int attackStat;
	public double health;
	public int money;
	public HashMap<String,Double> playerItems;


	public Player(String playerName) { //create a character with the given player name
		// TODO Auto-generated constructor stub
		this.name=playerName;
		this.level=1;
		this.attackStat=level*25;
		this.health=100;
		this.money=10;
		this.playerItems=new HashMap<String,Double>();
	}
	public String getName() { //get player name
		return name;
	}
	public int getLevel() {// get current player level
		return level;
	}
	public double getHealth() { //get current player health
		return health;
	}
	public int getAttackStat() { //get current player attack stat
		return attackStat;
	}

	public void loseMoney(int loss) {
		money-=loss;
	}
	public void addItem(String name, double value) {
		playerItems.put(name, value);
	}
	public void addMoney(int gain) {
		money+=gain;
	}
	
	public void levelUp() {
		level += 1;
	}


}

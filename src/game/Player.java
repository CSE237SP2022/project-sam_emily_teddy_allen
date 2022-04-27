package game;
import java.util.HashMap;
import java.util.Map.Entry;


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
		this.playerItems.put("Potion", 10.0);
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
	
	public void heal(double value) {
		health+=value;
		if(health>100) {
			health=100;
		}
		
		
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
	public void useItem(String item) {
		System.out.println("You used "+item);
		heal(this.playerItems.get(item));
		System.out.println("You now have " + getHealth() + " health");
		this.playerItems.remove(item);
	}
	public void checkItem(String item) {
		if(this.playerItems.containsKey(item)) {
			useItem(item);
		}
		else {
			System.out.println("You do not have that item");
		}
	}
	public void showItems() {
		System.out.println("You Have");
		for(Entry<String, Double> item: this.playerItems.entrySet()) {
			System.out.println(item.getKey()+" : "+item.getValue());
		}
	}


}

package game;

public class Enemy {

	private int hp;
	private int attack;
	private String monsterName;

	public Enemy(int health, int attackStat, String name) {
		// TODO Auto-generated constructor stub
		this.monsterName=name;
		this.attack=attackStat;
		this.hp=health;
	}
	public int getHp() {
		return hp;
	}
	public void takeDamage(int damage) {
		hp=hp-damage;
	}
	public int getAttack() {
		return attack;
	}
	public String getMonsterName() {
		return monsterName;
	}

}



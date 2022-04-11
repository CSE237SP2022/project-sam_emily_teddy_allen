package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BattleTests {

	@Test
	void BattleConstructor() {
		Player player = new Player("Player1");
		Player enemy = new Player("Player2");
		Battle battle = new Battle(player, enemy);
		assertNotNull(battle);
	}
	//Potentially need to change this so that it automatically gives input
	@Test
	void FightTest() {
		Player player = new Player("Player1");
		Player enemy = new Player("Player2");
		Battle battle = new Battle(player, enemy);
		battle.fight();
		assertNotNull(battle.winner);
	}
	

}

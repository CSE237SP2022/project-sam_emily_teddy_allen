package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DiceGameTests {

	@Test
	void DiceGameConstructor() {
		DiceGame game=new DiceGame();
		assertNotNull(game);
	}
	@Test
	void DiceGamePlayTest() {
		DiceGame game=new DiceGame();
		Boolean test=game.play();
		assertNotNull(test);
	}
	@Test
	void DiceGamePlayTypeTest() {
		DiceGame game=new DiceGame();
		Boolean test=game.play();
		assertEquals(test.getClass(),Boolean.class);
	}


}

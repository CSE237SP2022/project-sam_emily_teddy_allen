package game;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameTests {
	
	@Test
	void GameConstructor() {
		Game game = new Game();
		assertNotNull(game);
	}
	
	@Test
	void PlayerTest() {
		Game game = new Game();
		assertNull(game.getPlayer());
	}
	
	@Test
	void ProgressTest() {
		Game game = new Game();
		assertTrue(game.getProgress() == 0);
	}
}

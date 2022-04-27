package game;
import java.util.Scanner;


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
		Player test = game.getPlayer();
		assertNull(test);
	}
	
	@Test
	void ProgressTest() {
		Game game = new Game();
		int test = game.getProgress();
		assertEquals(0, test);
	}
	
	void ScannerTest() {
		Game game = new Game();
		Scanner test = game.getScanner();
		assertNotNull(test);
	}
	
	void HappyElfTest()
	{
		Game game = new Game();
		int test = game.happy_elf();
		assertEquals(10, test);
	}
	
	void DefeatTest()
	{
		Game game = new Game();
		int test = game.defeat_enemy();
		assertEquals(10, test);
	}
	
	void WinTest()
	{
		Game game = new Game();
		int test = game.win();
		assertEquals(12, test);
	}
	
	void LostTest()
	{
		Game game = new Game();
		int test = game.lost();
		assertEquals(12, test);
	}
	
	void StoreTest()
	{
		Game game = new Game();
		int test = game.store();
		assertEquals(11, test);
		
	}
}

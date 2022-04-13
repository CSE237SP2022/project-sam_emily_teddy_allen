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
	void DiceGameDiceTest() {
		DiceGame game=new DiceGame();
		int [] dice=game.getDice();
		assertEquals(dice.getClass(),int[].class);
		assertEquals(6,dice.length);
	}
	@Test
	void DiceGameDiceSumTest() {
		DiceGame game=new DiceGame();
		int [] dice=new int[6];
		for(int i=0;i<dice.length;i++) {
			dice[i]=i;
		}
		int sum=game.sumDice(dice);
		assertEquals(15,sum);
	}
	@Test
	void DiceGameRandomTest() {
		DiceGame game=new DiceGame();
		double random=game.randomNumber(100);
		boolean checkRange=false;
		if(random>0&&random<101) {
			checkRange=true;
		}
		assertEquals(checkRange,true);
	}

}

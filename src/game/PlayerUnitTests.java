package game;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerUnitTests {

	@Test
	void ConstructorTest() {
		Player testPlayer=new Player("John");
		assertNotNull(testPlayer);
	}
	@Test
	void nameTest() {
		Player testPlayer=new Player("John");
		assertEquals(testPlayer.getName(),"John");
	}
	@Test
	void initialLevelCheck(){
		Player testPlayer=new Player("John");
		assertEquals(testPlayer.getLevel(),1);
		
	}
	@Test
	void initialHealthCheck(){
		Player testPlayer=new Player("John");
		assertEquals(testPlayer.getHealth(),100);	
	}
	@Test
	void initialAttackCheck(){
		Player testPlayer=new Player("John");
		assertEquals(testPlayer.getAttackStat(),5);	
	}

}

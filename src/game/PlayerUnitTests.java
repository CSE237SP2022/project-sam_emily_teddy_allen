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
		assertEquals(testPlayer.getAttackStat(),25);	
	}
	@Test
	void loseMoneyCheck(){
		Player testPlayer=new Player("John");
		testPlayer.loseMoney(10);
		assertEquals(testPlayer.money,0);	
	}
	@Test
	void gainMoneyCheck(){
		Player testPlayer=new Player("John");
		testPlayer.addMoney(50);
		assertEquals(testPlayer.money,60);	
	}
	@Test
	void addItemCheck(){
		Player testPlayer=new Player("John");
		testPlayer.addItem("TestItem", 10);
		assertEquals(testPlayer.playerItems.size(),2);	
	}
	@Test
	void useItemCheck(){
		Player testPlayer=new Player("John");
		testPlayer.health-=10;
		testPlayer.checkItem("Potion");
		assertEquals(testPlayer.playerItems.size(),0);	
		assertEquals(testPlayer.getHealth(),100);	
	}
	@Test
	void healCheck(){
		Player testPlayer=new Player("John");
		testPlayer.health-=50;
		testPlayer.heal(50.0);
		assertEquals(testPlayer.getHealth(),100);	
	}

}

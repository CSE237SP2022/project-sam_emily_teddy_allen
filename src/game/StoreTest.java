package game;

import static org.junit.jupiter.api.Assertions.*;


import java.util.LinkedList;
import org.junit.jupiter.api.Test;

class StoreTest {

	@Test
	void testBuyEverything() {
		Player tester=new Player("John");
		tester.addMoney(1000);
		Store testStore=new Store(tester);
		testStore.getItems();
		LinkedList<String> items=new LinkedList<String>();
		for(String itemName: testStore.storeItems.keySet()) {
			items.add(itemName);
		}
		for(String name:items) {
			testStore.buy(name);
		}
		assertEquals(0,testStore.storeItems.size());

	}
	@Test
	void testNoMoney() {

		Player tester=new Player("John");
		tester.loseMoney(10);
		Store testStore=new Store(tester);
		testStore.getItems();
		LinkedList<String> items=new LinkedList<String>();
		for(String itemName: testStore.storeItems.keySet()) {
			items.add(itemName);
		}
		for(String name:items) {
			testStore.buy(name);
		}
		assertEquals(4,testStore.storeItems.size());
	}
	@Test
	void testRandomFood() {
		Player tester=new Player("John");
		Store testStore=new Store(tester);
		String [] food=testStore.randomizeFood();
		assertEquals(4,food.length);
	}
	@Test
	void testGetItemss() {
		Player tester=new Player("John");
		Store testStore=new Store(tester);
		testStore.getItems();
		assertEquals(4,testStore.storeItems.size());
	}
	@Test
	void testRandomNumber() {
		Player tester=new Player("John");
		Store testStore=new Store(tester);
		int test=testStore.randomNumber(15);
		boolean greaterThanEqualMin=false;
		if(test>=1) {
			greaterThanEqualMin=true;
		}
		boolean lessThanEqualMax=false;
		if(test<=15) {
			lessThanEqualMax=true;
		}
		assertEquals(lessThanEqualMax,true);
		assertEquals(greaterThanEqualMin,true);
	}


}

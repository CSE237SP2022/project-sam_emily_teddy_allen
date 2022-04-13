package game;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class Store {
	HashMap<String,Integer> storeItems;
	Player player;
	private Scanner scan;

	public Store(Player player) {
		// TODO Auto-generated constructor stub
		this.storeItems=new HashMap<String,Integer>();
		this.player=player;
		this.scan=new Scanner(System.in);
	}

	public int randomNumber(int max) { //generate random number less than max

		double randomNumber=Math.floor(max*Math.random())+1;
		return (int) randomNumber;

	}
	private LinkedList<String> convertArrayToList(String [] array){
		LinkedList<String> list=new LinkedList<String>();
		for(String itemName:array) {
			list.add(itemName);
		}
		return list;
	}
	public String [] randomizeFood() {
		String [] possible={"Apple","Orange", "Hamburger","Steak","Hotdog","Ice Cream","Cake","Cupcake","Pie"};
		LinkedList<String> possibleAsList=convertArrayToList(possible);
		String[] foodChosen=new String[4];
		for(int i=0;i<4;i++) {
			int random=randomNumber(possibleAsList.size()-1);
			foodChosen[i]=possibleAsList.get(random);
			possibleAsList.remove(random);
		}
		return foodChosen;
	}

	public void getItems() {

		String [] food =randomizeFood();
		for(String foodName:food) {
			int cost=randomNumber(50);
			storeItems.put(foodName, cost);
		}


	}
	public void display() {
		for(String itemName:storeItems.keySet()) {
			System.out.println(itemName+" costs "+ storeItems.get(itemName));
			System.out.println();
		}
	}
	public void enter() {
		System.out.println("********************");
		System.out.println();
		System.out.println("Welcome! What do you want to buy?");
		getItems();
		display();
		System.out.println("You have "+ player.money);
		System.out.println();
		String itemToBuy=playerResponse();
		if(itemToBuy!=null) {
			buy(itemToBuy);
		}

	}

	public void buy(String itemToBuy) {
		if(!storeItems.containsKey(itemToBuy))
		{
			System.out.println("The shopkeeper shouts 'We don't have that! Why do people "
					+ "always waste my time!? get outta here!' "
					+ "He proceeds to push you out of the store so "
					+ "you continue on your way.");
			System.out.println("");
			return;
		}
		int cost=storeItems.get(itemToBuy);
		if(player.money>=cost) {
			double itemValue=cost*1.5; //temporary gain for item	
			player.loseMoney(cost);
			player.addItem(itemToBuy, itemValue);
			storeItems.remove(itemToBuy);
			System.out.println("You received " + itemToBuy + "!");
			System.out.println("The shopkeeper shouts 'You finished? Good! Now"
					+ "get outta here!' He proceeds to push you out of the store so "
					+ "you continue on your way.");
			System.out.println("");
			return;
		}
		else
		{
			System.out.println("The shopkeeper shouts 'You don't have enough money for that! "
					+ "Don't waste my time, get outta here!' He proceeds to push you out the of "
					+ "the store so you continue on your way.");
			System.out.println("");
			return;

		}

	}

	private String playerResponse() {		
		String item = scan.nextLine();
		if(item!="nothing") {
			return item;
		}
		else {
			return null;
		}

	}

}

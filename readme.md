*** Battle-system branch readme ***

adventure.java
This is the file I added that I run to start the game. This file has a main method that runs the intro from the Game class and then starts a battle between the main player and a monster.

Run from terminal by using these commands:

	javac adventure.java
	java adventure


Battle.java
This class is used to create an instance of Battle. Battle has three instance variables: 
player (player class), enemy (enemy class), and fighting (boolean - this is just used to run the battle until someone wins).
Battle has methods for the players turn and the enemy's turn. The player's turn prompts the user to either attack (which will subtract hp from the enemy) or run (which will simply end the battle). The enemy's turn method will randomly choose a move for the enemy (either attack or run). These two methods will alternate until either the enemy or player has 0 health, or someone runs.

**I'm thinking that we honestly don't need to have an enemy class, we can just make the "enemy" another player from the player class.
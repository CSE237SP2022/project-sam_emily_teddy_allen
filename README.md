Iterarion 1:

Our group is working on a interactive storyboard like game. This game will develop a character and periodically present events to the player. These events will result in minigames or battling monster. Right now, we have worked on developing the initial battle/minigames along with a basic storyline.

Teddy: I worked on developing a player class to initiate the game. I also worked on one of our current minigames. I made up a dice like minigame similar to liars dice. In this, a CPU presents sum of dice rolls to the player. This sum is either a lie, or it is accurate. It is up to the player to decide. If the player is right, the cpu loses a die, if not the human loses a life out of 3. The game runs until either the player runs out of lives or the cpu runs out of dice. The input for my game is y or n on the keyboard. If you input y denotes you belive the dealer, n denotes that you don't. Next, I'd like to improve the cpu's lying system (right now it's a 50/50). The game would be more interesting with a more complex system. I also want to try and combine the minigame system with the battle system.

Sam: I develped a very simplified version of blackjack (blackjack.java). The full setup for the game can be very comprhensive and I intend to add in the full functionalities in later iterations. Currently, the user is provided two cards between 1 and 11, with an option to take a third card. Onbviously the game can go beyond three cards and I will account for this in the next/later iteration. I also only have one helper method at the moment, getCard(), and I intend to condense other parts of the code into helper methods. I also plan to provide a more clean setup with constructors. To run the game, simply navigate the repository folder and type: java -cp bin game.Blackjack. Right now, the only input the user will have is a y/n for whether they want to draw a third card.

Emily: I developed the battle functionality for the storyline (Battle.java). When the user reaches this point in the story, an instance of Battle will be created between the main player and an enemy monster. The player has the option to either fight the monster or run on each given turn. The CPU monster will also either fight or run during its turn. The player and CPU alternate turns until either one of them reaches 0 health, or someone runs away. Going forward, we want to develop the storyline a little more within the Battle class because it is pretty basic right now. We also want to add a way for the player to level up if the player defeats the monster.

Allen: I worked priarily on making our main story loop. I laid out a multiple path progression that allows our player to move through the story. Once the other parts of our game (like combat and mini-games wered finished), I also consolidated everything together as part of the our basic story setup so story flows into the other parts properly. Next, I would like to continue the story and give the player more options for paths and progression. Plus, I'd like to have add better interactions with the various characters and an item system.

Right now there is nothing currently broken, but things can be improved. There is an issue with eclispe where you have to configure the build path after each pull. However, the code still works in terminal it seems to just be eclispe.

In order to run our game you navigate to the src folder, run 
javac ./game/Game.java
then run 
java ./game/Game.java.

Iterarion 1:

Our group is working on a interactive storyboard like game. This game will develop a character and periodically present events to the player. These events will result in minigames or battling monster. Right now, we have worked on developing the initial battle/minigames along with a basic storyline.

Teddy: I worked on developing a player class to initiate the game. I also worked on one of our current minigames. I made up a dice like minigame similar to liars dice. In this, a CPU presents sum of dice rolls to the player. This sum is either a lie, or it is accurate. It is up to the player to decide. If the player is right, the cpu loses a die, if not the human loses a life out of 3. The game runs until either the player runs out of lives or the cpu runs out of dice. 

Sam: I develped a very simplified version of blackjack (blackjack.java). The full setup for the game can be very comprhensive and I intend to add in the full functionalities in later iterations. Currently, the user is provided two cards between 1 and 11, with an option to take a third card. Onbviously the game can go beyond three cards and I will account for this in the next/later iteration. I also only have one helper method at the moment, getCard(), and I intend to condense other parts of the code into helper methods. I also plan to provide a more clean setup with constructors. To run the game, simply navigate the repository folder and type: java -cp bin game.Blackjack. Right now, the only input the user will have is a y/n for whether they want to draw a third card.

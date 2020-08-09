// This program sets a Lion critter class that defines its behavior. 

import java.awt.*;

/*
   This is a Lion critter class
   - Color: Randomly picks one of three colors (Color.RED, Color.GREEN,
   Color.BLUE) and uses that color for three moves, then randomly picks
   one of those colors again for the next three moves, then randomly picks
   another one of those colors for the next three moves, and so on.
   
   - Move: 
   	+ always infect if an enemy is in front
      + otherwise if a wall is in front or to the right, then turn left
   	+ otherwise if a fellow Lion is in front, then turn right
   	+ otherwise hop
   
   - Name: "L"
*/
public class Lion extends Critter {

	private static final Color[] AVAILABLE_COLORS = {Color.RED, Color.GREEN, Color.BLUE};
	private int moveCounter;
	private Color color;

	public Lion() {
		this.color = this.getRandomColor();
		this.moveCounter = 0;
	}

	// returns a random color in the set of AVAILABLE_COLORS
	private Color getRandomColor() {
		return AVAILABLE_COLORS[(int)(Math.random() * AVAILABLE_COLORS.length)];
	}

	// returns the Lion's name
   public String toString() {
		return "L";
	}

	// returns color
   public Color getColor() {
		return this.color;
	}

	// constructs the action of lion
   // returns infect if the enemy is in front
   // returns turn left if a wall is in front or to the right
   // returns turn right if a fellow Lion is in front, then turn right
   // otherwise returns hop
   public Action getMove(CritterInfo info) {
	   //change to different color after every three moves
		moveCounter++;
		if ((moveCounter % 3) == 0) {
			this.color = this.getRandomColor();
		}
		if (info.frontThreat()) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL){
			return Action.LEFT;
		} else if (info.getFront() == Neighbor.SAME) {
			return Action.RIGHT;
		}
		return Action.HOP;
	}
}

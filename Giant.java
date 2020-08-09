// Anh Kim Huynh
// 6/7/20
// CSE142
// TA: Harshal V Desai
// Assignment #8: Critters

// This program sets a Giant critter class that defines its behavior. 

import java.awt.*;

/*
   This is a Giant critter class
   - Color: Color.GRAY
   
   - Move: 
   	+ always infect if an enemy is in front
   	+ otherwise hop if possible
   	+ otherwise turn right.
   
   - Name: 
   	+ "fee" for 6 moves, then "fie" for 6 moves, then "foe" for 6 moves, then
   	fum" for 6 moves, then repeat.
*/
public class Giant extends Critter {

	private static final String[] POSSIBLE_NAMES = {"fee", "fie", "foe", "fum"};
	private int moveCounter;

	public Giant() {
		this.moveCounter = 0;
	}

   // alternates between the set of POSSIBLE_NAMES every 6 moves
   // returns its names
	public String toString() {
		return POSSIBLE_NAMES[(moveCounter / 6) % POSSIBLE_NAMES.length];
	}

   // returns color of Giant 
	public Color getColor() {
		return Color.GRAY;
	}

   // constructs action of Giant
   // returns infect if an enemy is in front
   // returns hop if the front is empty
   // otherwise returns turn right
	public Action getMove(CritterInfo info) {
		moveCounter++;
		if (info.frontThreat()) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY){
			return Action.HOP;
		}
		return Action.RIGHT;
	}
}
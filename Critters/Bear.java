// Anh Kim Huynh
// 6/7/20
// CSE142
// TA: Harshal V Desai
// Assignment #8: Critters

// This program sets a Bear critter class that defines its behavior. 
 
import java.awt.*;

/*
   This is a Bear critter class
   - Color: Color.WHITE for a polar bear (when polar is true), Color.BLACK
   otherwise (when polar is false)
   
   - Move: 
   	+ always infect if an enemy is in front
   	+ otherwise hop if possible
   	+ otherwise turn left.
   
   - Name: 
   	+ Alternate between / and /\ after every move
*/
public class Bear extends Critter {

	private boolean polar;
	private int moveCounter;

	/*
	  @param polar a boolean indicating whether the bear is polar or not
	*/
	public Bear(boolean polar) {
		this.polar = polar;
		this.moveCounter = 0;
	}

   // returns between / and /\ after every move
	public String toString() {
		if ((this.moveCounter % 2) == 0) {
			return "/";
		}
		return "/\\";
	}
   
   // returns color white if polar, otherwise returns black
	public Color getColor() {
		if (this.polar) {
			return Color.WHITE;
      }
		return Color.BLACK;
	}

   // constructs action of Bear
   // returns infect if an enemy is in front
   // returns hop if the front is empty
   // returns turn left otherwise
	public Action getMove(CritterInfo info) {
		moveCounter++;
		if (info.frontThreat()) {
			return Action.INFECT;
		} else if (info.getFront() == Neighbor.EMPTY) {
			return Action.HOP;
		}
		return Action.LEFT;
	}
}
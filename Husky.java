// This program sets a Husky critter class that defines its behavior. 

import java.awt.*;

/*
   This is a Husky critter class
   - Color: default Color.YELLOW
   
   - Move: 
   	+ always hop if the front is empty
   	+ otherwise turn left if the left is empty
   	+ otherwise turn right
   	+ always infect enemy if possible
   	+ otherwise turn left if enemy is on the left
   	+ otherwise turn right if enemy is on the right
   
   - Name: 
   	+ change based on the evolution of the critter after every 2 defeated enemies
   	+ change name after every EVOLUTION_REQUIREMENT defeated enemies, and cap at 
      the last evolution
*/
public class Husky extends Critter {

	private static final String[] EVOLUTIONS = {"Pichu", "Pikachu", "Raichu"};
	private static final int EVOLUTION_REQUIREMENT = 2; // Has to infect 2 enemies to evolve
	private int moveCounter;
	private int defeatedEnemies;

	public Husky() {
	   this.moveCounter = 0;
	   this.defeatedEnemies = 0;
	}
   
	// returns change name after every EVOLUTION_REQUIREMENT defeated enemies, 
   // and cap at the last evolution
	public String toString() {
		return EVOLUTIONS[Math.min(EVOLUTIONS.length - 1, 
									      this.defeatedEnemies / EVOLUTION_REQUIREMENT)];
	}

	// returns hop or turn action towards empty spot
	// if none are available, this method defaults to return turn RIGHT
	private Action getFreeMoveAction(CritterInfo info) {
		if (info.getFront() == Neighbor.EMPTY)
			return Action.HOP;
		else if (info.getLeft() == Neighbor.EMPTY)
			return Action.LEFT;

		return Action.RIGHT;
	}

   // returns the color of husky class
	public Color getColor() {
		return Color.YELLOW;
	}

   // constructs the action of Husky
   // returns infect enemy if possible
	// returns turn left if enemy is on left
   // returns turn right if enemy is on right
   public Action getMove(CritterInfo info) {
		this.moveCounter++;
		if (info.frontThreat()) {
			this.defeatedEnemies++;
			return Action.INFECT;
		}
		if (info.leftThreat()) {
			return Action.LEFT;
		}
		if (info.rightThreat()) {
			return Action.RIGHT;
		}
		return this.getFreeMoveAction(info);
	}
}

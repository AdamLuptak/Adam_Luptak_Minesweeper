package minesweeper.core;

import minesweeper.core.Tile.State;

/**
 * Mine tile.
 */
public class Mine extends Tile {

	@Override
	public String toString() {
		if(this.getState() == State.CLOSED)
		  {
			 return super.toString();
		  }
			
		  else
		  {
			return "X";
		  }
	}
	
	
	
	
	
	
}

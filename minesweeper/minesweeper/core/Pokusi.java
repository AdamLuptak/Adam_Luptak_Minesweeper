package minesweeper.core;

public class Pokusi {

	/*
			 * 	void floodFill( int x, int y ) {
		   if ( btn( x, y ) isFillable ) {
		       fillBtn(x,y);
		       floodFill( x+1, y );
		       floodFill( x-1, y );
		       floodFill( x, y-1 );
		       floodFill( x, y+1 );
		   } else {
		       return;
		   }
		}
	 * 
	 * 
	 * 
	 * 
	 * */
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Field field = new Field(10, 10, 10);
		 printField(field);
		 System.out.println("");
		 System.out.println("");
		 
		System.out.println(field.toString());
		 
 
	}

	
	
	 static void printField(Field field)
	{
		
	 for (int i = 0; i < field.getRowCount(); i++) {
		for (int j = 0; j < field.getColumnCount(); j++) {
			
			
			if(field.getTiles(i, j) instanceof Mine)
			{
				System.out.print("X");
				
			}
			else if(field.getTiles(i, j) instanceof tileFree)
			{
				System.out.print("-");
			}
			else if(field.getTiles(i, j) instanceof Clue)
			{
				
				Clue clue = new Clue(i);
				clue = (Clue) field.getTiles(i, j);
				System.out.print(clue.getValue());
			}
			
			
		}
		System.out.println("");
	}
		
		
		
	}
	
	
}

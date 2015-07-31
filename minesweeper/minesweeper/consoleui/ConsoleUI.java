package minesweeper.consoleui;

import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.UserInterface;
import minesweeper.WrongFormatException;
import minesweeper.core.Clue;
import minesweeper.core.Field;
import minesweeper.core.GameState;
import minesweeper.core.Mine;
import minesweeper.core.tileFree;

/**
 * Console user interface.
 */
public class ConsoleUI implements UserInterface {
    /** Playing field. */
    private Field field;
    
    /** Input reader. */
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    
    /**
     * Reads line of text from the reader.
     * @return line as a string
     */
    private String readLine() {
        try {
            return input.readLine();
        } catch (IOException e) {
            return null;
        }
    }
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#newGameStarted(minesweeper.core.Field)
	 */
    @Override
	public void newGameStarted(Field field) {
        this.field = field;
        clc(50);
        do { 
        	
        	
        	 
            update();
            printField(field);
            processInput();
           
            
           // throw new UnsupportedOperationException("Resolve the game state - winning or loosing condition.");
        } while(true);
    }
    
    public void clc(int pocet)
    {
    	for (int i = 0; i < pocet; i++) {
			System.out.println("");
		}
    	
    }
    
    
    /* (non-Javadoc)
	 * @see minesweeper.consoleui.UserInterface#update()
	 */
    @Override
	public void update() {
    	
    	System.out.println(field.toString());
    	
    	
    	
    	
    	if(field.getState() == GameState.SOLVED)
    	{
    	    System.out.println("SI VYHRALLLLLLL");
    		System.exit(0);
    	}
    	else if(field.getState() == GameState.FAILED)
    	{
    		clc(200);
    		System.out.println("PREHRALI SI");
    		
    		System.exit(0);
    		
    	}
    	 
    }
    
    /**
     * Processes user input.
     * Reads line from console and does the action on a playing field according to input string.
     */
    private void processInput() {
      
    	String inputText = readline();
    	
		

    	try {
			handlingInput(inputText);
		} catch (WrongFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 clc(50);
    	
    	
    	if(inputText.startsWith("O")){
            int row = (inputText.charAt(1)-65);//65 -65  = 0 cize pre [0,0]
            int col = (inputText.charAt(2)-48);// 48-48 = 0 cize pre [0,0]
            field.openTile(row, col);
        }else if(inputText.startsWith("M")){
            int row = (inputText.charAt(1)-65);
            int col = (inputText.charAt(2)-48);
            field.markTile(row, col);
        }else if(inputText.startsWith("X")){
            System.exit(0);
        }
    	
    	
    	
    	
    	
    }
    
    
    
    
    private String readline()
    {
    	
    	System.out.print("Please enter your selection <X> EXIT, <M+RIADOK+STLPEC> MARK, <O+RIADOK+STLPEC> OPEN: ");
    	System.out.flush();
    	try {
			return input.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
    	
    }
    
    private void handlingInput(String input) throws WrongFormatException{
    	
    	 input = input.toUpperCase();
    	
    	Pattern open = Pattern.compile("O([A-I])([0-8])");
        Matcher openMatcher = open.matcher(input);
        Pattern mark = Pattern.compile("M([A-I])([0-8])");
        Matcher markMatcher = mark.matcher(input);
        Pattern exit = Pattern.compile("X");
        Matcher exitMatcher = exit.matcher(input);
    	
    	if( openMatcher.matches()){}
    	else if(exitMatcher.matches()){}
    	else if(markMatcher.matches()){}
    	else throw new WrongFormatException("Zadali ste spatny vstup");
    	
    	
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

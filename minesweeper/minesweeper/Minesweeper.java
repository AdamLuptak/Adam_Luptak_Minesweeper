package minesweeper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import minesweeper.consoleui.ConsoleUI;
import minesweeper.core.Field;

/**
*Main program here you can choose the type of interface
*/
public class Minesweeper {
	/** User interface. */
	private UserInterface userInterface;

	static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Constructor.
	 */
	private Minesweeper() {

		

		String input = "";
		
		input = getInput("Zadajte typ interfacu ktory chcete pouzit: ");
		
		try {
			handligInput(input);
		} catch (WrongFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		gameInicialisation(input);

	}

	/**
	 * Main method.
	 * 
	 * @param args
	 *            arguments
	 */
	public static void main(String[] args) {

		new Minesweeper();
	}

	private static String getInput(String prompt) {

		System.out.print(prompt);
		System.out.flush();

		try {
			return stdin.readLine();
		} catch (Exception e) {
			return "Error: " + e.getMessage();
		}
	}

	private void handligInput(String input) throws WrongFormatException {

		Pattern open = Pattern.compile("[1-2]");
		Matcher openMatcher = open.matcher(input);
		Pattern koniec = Pattern.compile("end");
		Matcher koniecMatcher = koniec.matcher(input);
		if (openMatcher.matches()) {
		} else if (koniecMatcher.matches()) {
		} else
			throw new WrongFormatException("Zly vstup.");

	}

	private void gameInicialisation(String input) {
		// TODO Auto-generated method stub
		if (input.equals("end")) {
			System.out.println("cav KONIEC");
			System.exit(0);

		} else if (input.equals("1")) {

			userInterface = new ConsoleUI();
			Field field = new Field(9, 9, 10);
			userInterface.newGameStarted(field);
		}
		else if(input.equals("2"))
		{
			
			 throw new UnsupportedOperationException("Method processInput not yet implemented");
		}
	}

}

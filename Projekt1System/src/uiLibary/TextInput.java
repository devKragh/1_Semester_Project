package uiLibary;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TextInput implements ITextInput {

	private Scanner scanner;

	public TextInput() {
		scanner = new Scanner(System.in);
	}
	/**
	 * This method ask the user for input
	 * @param question
	 * 		A string that is printed to prompt the user.
	 */
	@Override
	public String promptString(String question) {
		System.out.println(question);
		return scanner.nextLine();
	}
	
	/**
	 * A method that ask the user for an int input
	 * @param question
	 * 		A string that is printed to prompt the user.
	 * @param complaint
	 * 		A string that is printed if an InputMismatchException is catched
	 */
	@Override
	public int promptInt(String question, String complaint) {

		Scanner scan = new Scanner(System.in);
		System.out.println(question);
		int res = 0;

		try {
			res = scan.nextInt();
			return res;
		} catch (InputMismatchException e) {
			System.out.println(complaint);
			res = promptInt(question, complaint);
			return res;
		}
	}
	/**
	 * The method returns an int between min and max from user input
	 * @param question
	 * 		A string that is printed to prompt the user.
	 * @param complaint
	 * 		A string that is printed if an InputMismatchException is catched.
	 * @param min
	 * 		Minimum int you should be able to input.
	 * @param max
	 * 		Maximum int you should be able to input.
	 */
	@Override
	public int promptIntBetween(String question, String complaint, int min, int max) {
		Scanner scan = new Scanner(System.in);
		System.out.println(question);
		int res = 0;

		try {
			res = scan.nextInt();
			if(res < min || res > max) {
				System.out.println(complaint);
				res = promptIntBetween(question, complaint, min, max);
			}
			return res;
		} catch (InputMismatchException e) {
			System.out.println(complaint);
			res = promptIntBetween(question, complaint, min, max);
			return res;
		}
	}

	/**
	 * This method returns a boolean dependent on user input.
	 * @param question 
	 * 		A string that is printed to prompt the user.
	 */
	@Override
	public boolean promptBoolean(String question) {
		Scanner scan = new Scanner(System.in);
		System.out.println(question + "(y/n)");
		String input = null;
		boolean res = false;

		input = scan.nextLine().toLowerCase();
		if (input.equals("y")) {
			res = true;
		} else if (input.equals("n")) {
			res = false;
		} else {
			promptBoolean(question);
		}
		return res;
	}
	
	/**
	 * This  method returns a double dependent on user input
	 * @param question
	 * 		A string that is printed to prompt the user.
	 * @param complaint
	 * 		A string that is printed if an InputMismatchException is catched.
	 * 
	 */
	@Override
	public double promptDouble(String question, String complaint) {
		Scanner scan = new Scanner(System.in);
		System.out.println(question);
		double res = 0;

		try {
			res = scan.nextDouble();
			return res;
		} catch (InputMismatchException e) {
			System.out.println(complaint);
			res = promptInt(question, complaint);
			return res;
		}
	}
}

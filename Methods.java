import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class Methods {

	public static int displayMenu() {
		int result = 0;
		boolean badInt = true;

		while (badInt) {
			String input;
			String message = "1. Add a new Person\n2. Add a new Actor\n3. Add a new Prisoner\n4. Display all Records\n5. Display Statistics\n6. Quit\n";
			String prompt = "Enter the number of your selection.";
			input = JOptionPane.showInputDialog(message, prompt);
			try {
				result = Integer.parseInt(input);
				badInt = false;
			} catch (NumberFormatException nfe) {
				badInt = true;
				JOptionPane.showMessageDialog(null, prompt);
			}
		} // end of while
		return result;
	}// end of displayMenu

	public static void addPerson(ArrayList<Person> people) {
		Person person = new Person();
		
		people.add(person);
	} // end of addPerson

	public static void addActor(ArrayList<Person> people) {
		Actor actor = new Actor();
		
		people.add(actor);
	} // end of addActor

	public static void addPrisoner(ArrayList<Person> people) {
		Prisoner prisoner = new Prisoner();
		
		people.add(prisoner);
	} // end of addPrisoner

	public static void displayRecords(ArrayList<Person> people) { // still need to make a text file
		String message = "";
		for (int i = 0; i < people.size(); i++)
			message += people.get(i) + "\n";

		JOptionPane.showMessageDialog(null, message);
		try {
			File recordsFile = new File("Records");
			PrintWriter out = new PrintWriter(recordsFile);
			out.print(recordsFile);
			out.close();

			JOptionPane.showMessageDialog(null, "Making a file worked.");
		} catch (FileNotFoundException fnf) {
			JOptionPane.showMessageDialog(null, "Making a file failed.");
		} // end of try catch
	}// end of displayRecords

	public static void displaySummary(ArrayList<Person> people) {
		ArrayList<Prisoner> longestTimeAsPrisoner = new ArrayList<Prisoner>();

		String result = "";
		String message = "";
		int actors = 0, prisoners = 0, longestTimeServed = 0;

		for (int i = 0; i < people.size(); i++) {
			if (people.get(i) instanceof Actor)
				actors++;
			if (people.get(i) instanceof Prisoner) {
				prisoners++;
				if (((Prisoner) people.get(i)).getYearsSentenced()
						- ((Prisoner) people.get(i)).getYearsRemaining() > longestTimeServed) {
					longestTimeServed = ((Prisoner) people.get(i)).getYearsSentenced()
							- ((Prisoner) people.get(i)).getYearsRemaining();
					longestTimeAsPrisoner.clear();
					longestTimeAsPrisoner.add(((Prisoner) people.get(i)));
				} else if (((Prisoner) people.get(i)).getYearsSentenced()
						- ((Prisoner) people.get(i)).getYearsRemaining() == longestTimeServed) {
					longestTimeAsPrisoner.add(((Prisoner) people.get(i)));
				} // end of else if
			} // end of outer if
		} // end of For loop
			// display for exactly one prisoner who has served the longest sentence

		if (longestTimeAsPrisoner.size() == 1)
			message = "The prisoner who has served the longest sentence:\n" + longestTimeAsPrisoner.get(0) + "\n";
		// display for multiple prisoners who have served the longest sentence
		else if (longestTimeAsPrisoner.size() > 1) {
			message += "The prisoners who have served the longest sentence:\n";
			for (int i = 0; i < longestTimeAsPrisoner.size(); i++) {
				message += "#" + (i + 1) + " : \t" + longestTimeAsPrisoner.get(i);
			} // end of for loop
		} // end of else if

		result += "Total number of people: " + people.size() + "\n";
		result += "Total number of actors: " + actors + "\n";
		result += "Total number of prisoners: " + prisoners + "\n";
		result += "\n";
		result += message;
		JOptionPane.showMessageDialog(null, result);
	}// end of displayRecords

	public static void displayGoodbye() {
		String message = "Goodbye!";
		JOptionPane.showMessageDialog(null, message);
	}// end of displayRecords

	public static void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public static String getString(String message, String prompt) {
		String result;
		result = JOptionPane.showInputDialog(message, prompt);
		return result;
	}

	public static boolean validateAlphabetic(String word) {
		boolean result = false;
		for (int i = 0; i < word.length(); i++) {
			if (Character.isAlphabetic(word.charAt(i))) {
				result = true;
			} else {
				i = word.length();
				result = false;
			} // End if statement.
		} // End of for loop.
		return result;
	} // End of validateAlphabetic method.

	public static boolean validateAlphabeticAndPeriod(String word) {
		boolean result = false;
		for (int i = 0; i < word.length(); i++) {
			if (Character.isAlphabetic(word.charAt(i)) || word.charAt(i) == '.') {
				result = true;
			} else {
				i = word.length();
				result = false;
			} // End if statement.
		} // End of for loop.
		return result;
	} // End of validateAlphabetic method.

	public static double inputDouble(String message, double lowerBound, double upperBound) {
		String userStringInput = "";
		double userInput = 0.0; // Return variable.
		boolean validInput = false; // Loop control variable.
		// Input validation loop.
		while (!validInput) {
			try {
				// System.out.print(message);
				userStringInput = JOptionPane.showInputDialog(message);
				userInput = Double.parseDouble(userStringInput);
				// userInput = input.nextDouble();
				// input.nextLine(); // Clear the next line character left over from the nextInt
				// input.
				if (lowerBound == upperBound) {
					displayMessage("\nINVALID ENTRY: You can only enter number " + lowerBound + ".\n");
					validInput = false;
				} else if (userInput < lowerBound || userInput > upperBound) {
					displayMessage("\nINVALID ENTRY: You must enter a number between " + lowerBound + " and "
							+ upperBound + ".\n");
					validInput = false;
				} else {
					validInput = true;
				} // End of if statement.
			} catch (InputMismatchException ime) {
				System.out.println("\nINVALID ENTRY: You must enter a number.\n");
				validInput = false;
			} // End of Try-Catch block.
		} // End of while loop.
		return userInput;
	} // End of getInt method.

	public static int inputInt(String message, int lowerBound, int upperBound) {
		String userStringInput = "";
		int userInput = 0; // Return variable.
		boolean validInput = false; // Loop control variable.
		// Input validation loop.
		while (!validInput) {
			try {
				// System.out.print(message);
				userStringInput = JOptionPane.showInputDialog(message);
				userInput = Integer.parseInt(userStringInput);
				// userInput = input.nextInt();
				// input.nextLine(); // Clear the next line character left over from the nextInt
				// input.
				if (lowerBound == upperBound) {
					// System.out.println("\nINVALID ENTRY: You can only enter number " + lowerBound
					// + ".\n");
					displayMessage("\nINVALID ENTRY: You can only enter number " + lowerBound + ".\n");
					validInput = false;
				} else if (userInput < lowerBound || userInput > upperBound) {
					// System.out.println("\nINVALID ENTRY: You must enter a number between " +
					// lowerBound + " and " + upperBound + ".\n");
					displayMessage("\nINVALID ENTRY: You must enter a number between " + lowerBound + " and "
							+ upperBound + ".\n");
					validInput = false;
				} else {
					validInput = true;
				} // End of if statement.
			} catch (InputMismatchException ime) {
				// System.out.println("\nINVALID ENTRY: You must enter a number.\n");
				displayMessage("\nINVALID ENTRY: You must enter a number.\n");
				validInput = false;
			} // End of Try-Catch block.
		} // End of while loop.
		return userInput;
	} // End of getInt method.

	public static void createFile(String file, ArrayList<Person> arrayList)
            throws IOException {
        FileWriter writer = new FileWriter(file + ".txt");
        int size = arrayList.size();
        for (int i=0;i<size;i++) {
            String str = arrayList.get(i).toString();
            writer.write(str);
            if(i < size-1)
                writer.write("\n");
        }
        writer.close();
    }

	@SuppressWarnings("resource")
	public static void getFileContent(ArrayList<Person> people) throws IOException{
		File file = new File("Records.txt");
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			System.out.println(scan.nextLine());
		}
	}
}

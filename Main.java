//########################################################################################//
//####### Written by..................... :    Henrique Lacerda Delgado De Sa  #######//
//####### Date written:.................. :    01/02/21                            #######//
//####### Purpose.........................:    PersonActorPrisoner Assignment      #######//
//########################################################################################//

import java.io.IOException;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		// create array list of Persons
		ArrayList<Person> people = new ArrayList<Person>();

		// declare variable
		int selection = 0;

		while (selection != 6) {
			selection = Methods.displayMenu();

			switch (selection) {
			case 1:
				// add a Person
				Methods.addPerson(people);
				break;
			case 2:
				// add an Actor
				Methods.addActor(people);
				break;
			case 3:
				// add a Prisoner
				Methods.addPrisoner(people);
				break;
			case 4:
				// display all records to screen and a text file
				Methods.createFile("Records", people);
				Methods.displayRecords(people);
				Methods.getFileContent(people);
				break;
			case 5:
				// display the summary
				Methods.displaySummary(people);
				break;
			case 6:
				// end the program
				Methods.displayGoodbye();
				break;
			} // end of switch

		} // end of while

	} // end of main

} // end of TestClassMain
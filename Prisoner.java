public class Prisoner extends Person {

	private String typeOfCrime;
	private int yearsSentenced;
	private int yearsRemaining;

	public Prisoner() {
		makePrisoner();
	}

	public Prisoner(Name name, double height, double weight, int yearsSentenced, int yearsRemaining) {
		super(name, height, weight);
		this.yearsSentenced = yearsSentenced;
		this.yearsRemaining = yearsRemaining;
	}

	public String getTypeOfCrime() {
		return typeOfCrime;
	}

	public void setTypeOfCrime(String typeOfCrime) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;

		while (repeat) {
			try {
				do {
					message = "1. Murder \n2. Rape \n3. Theft \n4.Assault \n5. White Collar";
					prompt = "Enter the type of crime here.";
					typeOfCrime = Methods.getString(message, prompt).toUpperCase();

					if (typeOfCrime.equals("MURDER") || typeOfCrime.equals("RAPE") || typeOfCrime.equals("THEFT")
							|| typeOfCrime.equals("ASSAULT") || typeOfCrime.equals("WHITE COLLAR")) {
						badValue = false;
					} else {
						badValue = true;
						message = "Enter a valid crime!";
						Methods.displayMessage(message);
					}

					typeOfCrime = typeOfCrime.substring(0, 1).toUpperCase() + typeOfCrime.substring(1).toLowerCase();
					this.typeOfCrime = typeOfCrime;
				} while (badValue == true);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
		}

	}

	public int getYearsSentenced() {
		return yearsSentenced;
	}

	public void setYearsSentenced(int yearsSentenced) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;
		String input;

		while (repeat) {
			try {
				do {
					message = "How many years is your sentence?";
					prompt = "Enter an amount between 1 and 1000.";
					input = Methods.getString(message, prompt);
					yearsSentenced = Integer.parseInt(input);

					if (yearsSentenced > 0 && yearsSentenced <= 1000) {
						badValue = false;
					} else {
						badValue = true;
						message = "Enter between 1 and 1000!";
						Methods.displayMessage(message);
					}
					
					this.yearsSentenced = yearsSentenced;
					
				} while (badValue == true);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
		}
	}

	public int getYearsRemaining() {
		return yearsRemaining;
	}

	public void setYearsRemaining(int yearsRemaining) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;
		String input;
		
		while(repeat) {
			try {
				do {
					message = "How many years remain?";
					prompt = "Make sure it is less than sentence";
					input = Methods.getString(message, prompt);
					yearsRemaining = Integer.parseInt(input);
					
					if (yearsRemaining > 0 && yearsRemaining <= yearsSentenced) {
						badValue = false;
					} else {
						badValue = true;
						message = "Enter a valid remaining sentence!";
						Methods.displayMessage(message);
					}
					
					this.yearsRemaining = yearsRemaining;
					
				}while (badValue == true);
				
				repeat = false;
			}catch(Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
		}
	}

	public String toString() {
		String result = super.toString();
		result += "Type of crime: " + typeOfCrime + "\n";
		result += "Years sentenced: " + yearsSentenced + "\n";
		result += "Years remaining: " + yearsRemaining + "\n";
		return result;
	}

	public void makePrisoner() {
		setTypeOfCrime(typeOfCrime);
		setYearsSentenced(yearsSentenced);
		setYearsRemaining(yearsRemaining);
	}

}
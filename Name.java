public class Name {
	private String fName;
	private char mInitialChar;
	private String mInitial;
	private String lName;
	public static int eSize = 0;

	public Name() {
		getName();
	} // end Name

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;

		while (repeat) {
			try {
				do {
					message = "What is the person\'s first name?";
					prompt = "Please enter first name only";

					fName = Methods.getString(message, prompt);
					
					if (Methods.validateAlphabetic(fName) == true)
						badValue = false;
					else {
						badValue = true;
						message = "INVALID INPUT! PLEASE TRY AGAIN!";
						Methods.displayMessage(message);
					}

					fName = fName.toUpperCase().charAt(0) + fName.substring(1).toLowerCase();
					this.fName = fName;
				} while (badValue == true);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
		}
	}
	
	public String getmInitial() {
		return mInitial;
	}
	
	public void setmInitial(String mInitial) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;

		while (repeat) {
			try {
				do {
					message = "What is the person\'s middle initial?";
					prompt = "Hit ENTER if none";

					mInitial = Methods.getString(message, prompt);
					
					if (Methods.validateAlphabetic(mInitial) == true)
						badValue = false;
					else if (mInitial.equals("Hit ENTER if none"))
						badValue = false;
					else {
						badValue = true;
						message = "INVALID INPUT! PLEASE TRY AGAIN!";
						Methods.displayMessage(message);
					}
					
					this.mInitial = mInitial;
				} while (badValue == true);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
		}		
	}

	public char getmInitialChar() {
		return mInitialChar;
	}

	public void setmInitialChar(char mInitialChar) {
		setmInitial(mInitial);
		
		mInitialChar = mInitial.toUpperCase().charAt(0);
		this.mInitialChar = mInitialChar;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;

		while (repeat) {
			try {
				do {
					message = "What is the person\'s last name?";
					prompt = "Please enter last name only";

					lName = Methods.getString(message, prompt);
					
					if (Methods.validateAlphabetic(lName) == true)
						badValue = false;
					else {
						badValue = true;
						message = "INVALID INPUT! PLEASE TRY AGAIN!";
						Methods.displayMessage(message);
					}
					
					lName = lName.toUpperCase().charAt(0) + lName.substring(1).toLowerCase();
					this.lName = lName;
				} while (badValue == true);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
		}
	}

	public String toString() {
		String result;
		
		if(mInitial.equals("Hit ENTER if none") || mInitial == "")
			result = fName + " " + lName;
		else 
			result = fName + " " + mInitialChar + ". " + lName;
		
		return result;
	} // end toString()

	public void getName() {
		setfName(fName);
		setmInitialChar(mInitialChar);
		setlName(lName);

		eSize++;
	} // end getName

} // end of class Name
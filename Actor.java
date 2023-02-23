public class Actor extends Person {
	private String mainGenre;
	private int totalMoviesMade;

	public Actor() {
		makeActor();
	}
	
	public Actor(String mainGenre, int totalMoviesMade, Name name, double height, double weight ) {
		super(name, height, weight);
		this.mainGenre = mainGenre;
		this.totalMoviesMade = totalMoviesMade;
	}

	public String getMainGenre() {
		return mainGenre;
	}

	public void setMainGenre(String mainGenre) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;

		while (repeat)
			try {
				do {
					message = "Enter the actor\'s genre";
					prompt = "(comedy, horror, or drama)";
					mainGenre = Methods.getString(message, prompt).toUpperCase();

					if (mainGenre.equals("COMEDY") || mainGenre.equals("HORROR") || mainGenre.equals("DRAMA")) {
						badValue = false;
					} else {
						badValue = true;
						message = "Enter a valid genre!";
						Methods.displayMessage(message);
					}

					mainGenre = mainGenre.substring(0, 1).toUpperCase() + mainGenre.substring(1).toLowerCase();
					this.mainGenre = mainGenre;
				} while (badValue == true);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
	}

	public int getTotalMoviesMade() {
		return totalMoviesMade;
	}

	public void setTotalMoviesMade(int totalMoviesMade) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;
		String input;
		
		while (repeat)
			try {
				do {	
					message = "Enter the total movies made";
					prompt = "(number between 0 and 100)";
					input = Methods.getString(message, prompt);
					totalMoviesMade = Integer.parseInt(input);
					
					if (totalMoviesMade >= 0 && totalMoviesMade <= 100)
						badValue = false;
					else {
						badValue = true;
						message = "Enter a valid number!";
						Methods.displayMessage(message);
					}
					
					this.totalMoviesMade = totalMoviesMade;

				} while (badValue == true);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
	}

	public void makeActor() {
		setMainGenre(mainGenre);
		setTotalMoviesMade(totalMoviesMade);
	}

	@Override
	public String toString() {
//		String result = "Actor:";
		String result = super.toString();
		
		result += "Main Genre: " + mainGenre + "\n";
		result += "Movies amount: " + totalMoviesMade + "\n";
		
		return result;
	}

}

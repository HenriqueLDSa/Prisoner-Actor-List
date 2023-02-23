public class Person {
	private Name name;
	private double height;
	private double weight;

	public Person() {
		makePerson();
	} // End of no-args constructor.

	public Person(Name name, double height, double weight) {
		setName(name);
		setHeight(height);
		setWeight(weight);
	} // End of full-args constructor.

	public void setName(Name name) {
		this.name = new Name();
	} // End of setName method.

	public Name getName() {
		return name;
	} // End of getName method.

	public void setWeight(double weight) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;
		String input;

		while (repeat) {
			try {
				do {
					message = "Enter person\'s weight:";
					prompt = "(number between 25 and 1000)";
					input = Methods.getString(message, prompt);
					weight = Double.parseDouble(input);

					if (weight >= 25 && weight <= 1000)
						badValue = false;
					else {
						badValue = true;
						message = "Enter a valid number!";
						Methods.displayMessage(message);
					}

					this.weight = weight;

				} while (badValue);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
		}
	}

	public double getWeight() {
		return weight;
	}

	public void setHeight(double height) {
		boolean badValue = false;
		boolean repeat = true;
		String message;
		String prompt;
		String input;

		while (repeat) {
			try {
				do {
					message = "Enter person\'s height:";
					prompt = "(number between 12 and 144)";
					input = Methods.getString(message, prompt);
					height = Double.parseDouble(input);

					if (height >= 12 && height <= 144)
						badValue = false;
					else {
						badValue = true;
						message = "Enter a valid number!";
						Methods.displayMessage(message);
					}

					this.height = height;

				} while (badValue);

				repeat = false;
			} catch (Exception e) {
				message = "INVALID INPUT! PLEASE TRY AGAIN!";
				Methods.displayMessage(message);
				repeat = true;
			}
		}
	}

	public double getHeight() {
		return height;
	}

	public void makePerson() {
		setName(name);
		setWeight(weight);
		setHeight(height);
	} // End of requestPerson method.

	public String toString() {
		return "Name: " + name + "\n" + "Height: " + height + "\n" + "Weight: " + weight + "\n";
	} // End of toString method.

} // End of Person class.
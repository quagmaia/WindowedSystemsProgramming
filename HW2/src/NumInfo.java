import javafx.scene.layout.GridPane;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class NumInfo extends GridPane {

	public NumInfo() {

		TextField input = new TextField();
		input.setText("");
		add(input, 0, 0);

		ComboBox<String> combo = new ComboBox<String>();
		combo.getItems().addAll("Even", "Prime");
		add(combo, 1, 0);

		TextArea output = new TextArea();
		output.setEditable(false);
		output.setWrapText(true);
		setHgrow(output,Priority.ALWAYS);
		add(output, 0, 1);

		Button run = new Button("Run");
		add(run, 2, 0);
		run.setOnAction((event) -> {
			try {
				int givenInt = checkInput(input.getText());
				Boolean givenIntIsPositive = givenInt >= 0; // if negative, it
															// errored out
				if (givenIntIsPositive) {
					Boolean checkForEven = combo.getValue().equals("Even");
					Boolean checkForPrime = combo.getValue().equals("Prime");
					if (checkForEven) {
						if (isEven(givenInt)) {
							output.appendText(givenInt + " is even. ");
						} else {
							output.appendText(givenInt + " is odd. ");
						}
					} else if (checkForPrime) {
						if (isPrime(givenInt)) {
							output.appendText(givenInt + " is prime. ");
						} else {
							output.appendText(givenInt + " is not prime. ");
						}
					}
				} else {
					output.appendText(input.getText() + " is not a valid number, please enter a valid number! ");
				}
			} catch (Exception e) {
				output.appendText("Please select Even or Prime. ");
			}

		});//setOnAction

	}

	private Boolean isPrime(int value) {
		if (isEven(value))
			return false;
		if (value == 0 || value == 1)
			return false;
		for (int i = 3; i < value; i += 2) {
			if (value % i == 0)
				return false;
		}
		return true;
	}

	private Boolean isEven(int value) {
		if (value % 2 == 0)
			return true;
		else
			return false;
	}

	private int setPositive(int value) {
		if (value < 0)
			value *= -1;
		return value;
	}

	private int checkInput(String input) {
		try {
			int i = Integer.parseInt(input);
			return setPositive(i);

		} catch (Exception e) {
			return -1;
		}
	}
}

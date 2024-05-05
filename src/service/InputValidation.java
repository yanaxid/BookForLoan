package service;

public class InputValidation {

    public boolean isNumber(String number) {
	boolean isValid = false;

	if (number.matches("[0-9]+")) {
	    isValid = true;
	}

	return isValid;
    }

    public boolean isAlphabet( String alphabet) {
	boolean isValid = false;

	if (!alphabet.matches("[a-zA-Z_]+")) {
	    System.out.println("Invalid name");
	}
	
	return isValid;
    }

}

package exceptions;

public class SameCharacterRomanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = " cannot be in a single person romantic relationship!";

	public SameCharacterRomanceException(String name) {
		super(name + MESSAGE);
	}
}

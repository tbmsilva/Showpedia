package exceptions;

/**
 * 
 * @author tbmsilva & m.lami
 *
 */
public class NoVirtualCharactersException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "This is the real thing, this is art!";

	public NoVirtualCharactersException() {
		super(MESSAGE);
	}
}

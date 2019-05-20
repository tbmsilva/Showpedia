package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class InvalidSeasonException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = " does not have season ";

	public InvalidSeasonException(String showName, int season) {
		super(showName + MESSAGE + season + "!");
	}
}

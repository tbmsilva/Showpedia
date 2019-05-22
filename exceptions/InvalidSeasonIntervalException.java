/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class InvalidSeasonIntervalException extends Exception {

	private static final long serialVersionUID = -5817010138384584349L;
	private static final String MESSAGE = "Invalid seasons interval!";

	public InvalidSeasonIntervalException() {
		super(MESSAGE);
	}
}

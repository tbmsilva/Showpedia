/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class UnknownSeasonException extends Exception {

	private static final long serialVersionUID = -187785865513066258L;
	private static final String MESSAGE = "Unknown season!";

	public UnknownSeasonException() {
		super(MESSAGE);
	}
}

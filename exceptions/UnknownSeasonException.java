/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva
 *
 */
public class UnknownSeasonException extends Exception {

	private static final long serialVersionUID = -187785865513066258L;
	private static final String MESSAGE = "Unknown season!";

	public UnknownSeasonException() {
		super(MESSAGE);
	}
}

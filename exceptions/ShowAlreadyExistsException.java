/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva
 *
 */
public class ShowAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 5971155290497082688L;
	private static final String MESSAGE = "Show already exists!";

	public ShowAlreadyExistsException() {
		super(MESSAGE);
	}
}

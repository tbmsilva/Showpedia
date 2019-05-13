/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class ShowAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 5971155290497082688L;
	private static final String MESSAGE = "Show already exists!";

	public ShowAlreadyExistsException() {
		super(MESSAGE);
	}
}

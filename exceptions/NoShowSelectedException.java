/**
 * 
 */
package exceptions;

/**
 * Exception thrown when using currentShow command while no show has been
 * selected yet.
 * 
 * @author tbmsilva & m.lami
 */
public class NoShowSelectedException extends Exception {

	private static final long serialVersionUID = -9080157077104069935L;
	private static final String MESSAGE = "No show is selected!";

	public NoShowSelectedException() {
		super(MESSAGE);
	}
}

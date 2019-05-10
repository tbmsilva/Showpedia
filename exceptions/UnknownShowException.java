/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva
 *
 */
public class UnknownShowException extends Exception {

	private static final long serialVersionUID = -639444554619943553L;
	private static final String MESSAGE = "Unknown show!";
	
	public UnknownShowException() {
		super(MESSAGE);
	}
}

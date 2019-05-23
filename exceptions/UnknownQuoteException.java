/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class UnknownQuoteException extends Exception {

	private static final long serialVersionUID = -4899424011455684424L;
	private static final String MESSAGE = "First time I hear that!";

	public UnknownQuoteException() {
		super(MESSAGE);
	}

}

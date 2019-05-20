/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class RepeatedRelationshipException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = "What else is new? We already know about those two...";

	public RepeatedRelationshipException() {
		super(MESSAGE);
	}

}

/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva
 *
 */
public class UnknownActorException extends Exception {

	private static final long serialVersionUID = -8378934788960543017L;
	private static final String MESSAGE = "Who is ";
	
	public UnknownActorException(String actorName) {
		super(MESSAGE + actorName + "?");
	}

}

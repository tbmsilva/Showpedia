/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva
 *
 */
public class InvalidActorFeeException extends Exception {

	private static final long serialVersionUID = 8908917133272355141L;
	private static final String MESSAGE = "Slavery is long gone and this is outrageous!";
	
	public InvalidActorFeeException() {
		super(MESSAGE);
	}
}

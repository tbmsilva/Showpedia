/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class UnknownActorCategoryException extends Exception {

	private static final long serialVersionUID = -1902355321692445812L;
	private static final String MESSAGE = "Unknown actor category!";

	public UnknownActorCategoryException() {
		super(MESSAGE);
	}
}

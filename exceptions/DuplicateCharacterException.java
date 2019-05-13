/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class DuplicateCharacterException extends Exception {

	private static final long serialVersionUID = -4960779817562258318L;
	private static final String MESSAGE = "Duplicate character names are not allowed!";
	
	public DuplicateCharacterException() {
		super(MESSAGE);
	}
}

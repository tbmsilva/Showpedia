/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class UnknownCharacterException extends Exception {

	private static final long serialVersionUID = -1169661218072398798L;
	private static final String MESSAGE = "Who is ";

	public UnknownCharacterException(String characterName) {
		super(MESSAGE + characterName + "?");
	}
}

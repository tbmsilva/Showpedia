/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class CharacterIsVirtualException extends Exception {

	private static final long serialVersionUID = -3306805923094904528L;
	private static final String MESSAGE = " is played by a virtual actor!";

	public CharacterIsVirtualException(String characterName) {
		super(characterName + MESSAGE);
	}
}

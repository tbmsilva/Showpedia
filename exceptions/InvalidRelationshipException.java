/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class InvalidRelationshipException extends Exception {

	private static final long serialVersionUID = -1480767311436258344L;
	private static final String MESSAGE = " cannot be parent and child at the same time!";

	public InvalidRelationshipException(String characterName) {
		super(characterName + MESSAGE);
	}
}

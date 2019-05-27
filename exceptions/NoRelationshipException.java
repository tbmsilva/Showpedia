/**
 * 
 */
package exceptions;

/**
 * @project ShowPedia
 * @author tbmsilva & m.lami
 * @date 26/05/2019
 * @time 18:38:30
 */
public class NoRelationshipException extends Exception {

	private static final long serialVersionUID = -7049461235011802434L;
	private static final String MESSAGE = "These characters are not related!";

	public NoRelationshipException() {
		super(MESSAGE);
	}
}

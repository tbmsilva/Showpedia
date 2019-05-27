/**
 * 
 */
package exceptions;

/**
 * @project ShowPedia
 * @author tbmsilva & m.lami
 * @date 26/05/2019
 * @time 18:36:27
 */
public class SameCharacterException extends Exception {

	private static final long serialVersionUID = 6937875829729343544L;
	private static final String MESSAGE = "Like... you know, they are THE SAME character! duuuuh...";
	
	public SameCharacterException() {
		super(MESSAGE);
	}
}

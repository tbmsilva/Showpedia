/**
 * 
 */
package exceptions;

/**
 * @author tbmsilva & m.lami
 *
 */
public class NoRomancesException extends Exception {

	private static final long serialVersionUID = 9118432530980015299L;
	private static final String MESSAGE = "Love is not in the air. :-(";

	public NoRomancesException() {
		super(MESSAGE);
	}

}

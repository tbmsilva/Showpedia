package exceptions;

/**
 * @author tbmsilva & m.lami
 * 
 */
public class InvalidEpisodeException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final String MESSAGE = " does not have episode ";

	public InvalidEpisodeException(String showName, int season, int episode) {
		super(showName + " S" + season + MESSAGE + episode + "!");
	}
}

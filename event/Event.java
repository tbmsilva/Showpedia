package event;

public interface Event {

	/**
	 * Returns the description of the event.
	 * 
	 * @return the description of the event.
	 */
	String description();

	/**
	 * Returns the season of the event.
	 * 
	 * @return the season of the event.
	 */
	int season();

	/**
	 * Returns the episode of the event.
	 * 
	 * @return the episode of the event.
	 */
	int episode();

	/**
	 * Checks if a character is present in the event.
	 * 
	 * @param characterName - name of the character.
	 * @return <code>true</code> if character is present, <code>false</code>
	 *         otherwise.
	 */
	boolean isInEvent(String characterName);

}

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

	boolean isInEvent(String characterName);

}

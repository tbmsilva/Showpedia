/**
 * 
 */
package episodes;

import java.util.Iterator;

import characters.ShowCharacter;
import event.Event;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface Episode {

	/**
	 * Returns the episode's name
	 * 
	 * @return the episode's name
	 */
	String getName();

	/**
	 * Adds given event to the list of events of the episode.
	 * 
	 * @param e - event to be added.
	 */
	void addEvent(Event e);

	/**
	 * Returns an iterator for the events in the episode.
	 * 
	 * @return an iterator for the events in the episode.
	 */
	Iterator<Event> getEventIterator();
	
	/**
	 * @param character
	 * @param quote
	 */
	void addQuote(ShowCharacter character, String quote);
}

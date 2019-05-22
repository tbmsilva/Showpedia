/**
 * 
 */
package episodes;

import java.util.Iterator;

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
	 * @param e
	 */
	void addEvent(Event e);
	
	/**
	 * @return
	 */
	Iterator<Event> getEventIterator();
}

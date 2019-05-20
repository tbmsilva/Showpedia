/**
 * 
 */
package episodes;

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
	
	void addEvent(Event e);
}

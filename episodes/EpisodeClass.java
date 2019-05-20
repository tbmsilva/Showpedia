/**
 * 
 */
package episodes;

import java.util.*;

import event.Event;

/**
 * @author tbmsilva & m.lami
 *
 */
public class EpisodeClass implements Episode {
	
	private String name;
	private List<Event> events;
	
	public EpisodeClass(String name) {
		this.name = name;
		events = new LinkedList<>();
	}

	public String getName() {
		return name;
	}
	
	public void addEvent(Event e) {
		events.add(e);
	}
	
}

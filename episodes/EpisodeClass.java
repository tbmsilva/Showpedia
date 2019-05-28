/**
 * 
 */
package episodes;

import java.util.*;

import characters.ShowCharacter;
import event.Event;

/**
 * @author tbmsilva & m.lami
 *
 */
public class EpisodeClass implements Episode {

	private String name;
	private List<Event> events;
	private Map<String, List<ShowCharacter>> quotes;

	public EpisodeClass(String name) {
		this.name = name;
		events = new LinkedList<>();
		quotes = new TreeMap<>();
	}

	public String getName() {
		return name;
	}

	public void addEvent(Event e) {
		events.add(e);
	}

	public Iterator<Event> getEventIterator() {
		return events.iterator();
	}

	public void addQuote(ShowCharacter character, String quote) {
		if (quotes.containsKey(quote))
			quotes.get(quote).add(character);
		else {
			List<ShowCharacter> l = new ArrayList<>();
			l.add(character);
			quotes.put(quote, l);
		}
	}
}

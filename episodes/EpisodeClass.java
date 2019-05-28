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

	public boolean isInEvent(String characterName) {
		boolean exists = false;
		for (int i = 0; i < events.size(); i++)
			if (events.get(i).isInEvent(characterName))
				exists = true;
		return exists;
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

	public boolean saidAQuote(ShowCharacter character) {
		boolean said = false;
		Iterator<String> it = quotes.keySet().iterator();
		while (it.hasNext()) {
			String quote = it.next();
			for (int i = 0; i < quotes.get(quote).size(); i++)
				if (quotes.get(quote).get(i).equals(character))
					said = true;
		}
		return said;
	}
}

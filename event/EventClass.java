package event;

import java.util.Iterator;
import java.util.List;

import characters.ShowCharacter;

/**
 * @author tbmsilva & m.lami
 *
 */
public class EventClass implements Event {

	private String description;
	private int season, episode;
	private List<ShowCharacter> eventCharacters;

	public EventClass(String description, int season, int episode, List<ShowCharacter> eventCharacters) {
		this.description = description;
		this.season = season;
		this.episode = episode;
		this.eventCharacters = eventCharacters;
	}

	public String description() {
		return description;
	}

	public int season() {
		return season;
	}

	public int episode() {
		return episode;
	}
	
	public boolean isInEvent(String characterName) {
		boolean temp = true;
		if(getCharacter(characterName) == null)
			temp = false;
		return temp;
	}

	private ShowCharacter getCharacter(String name) {
		boolean found = false;
		ShowCharacter c = null;
		Iterator<ShowCharacter> it = eventCharacters.iterator();
		while (it.hasNext() && !found) {
			ShowCharacter temp = it.next();
			if (temp.getName().equals(name)) {
				c = temp;
				found = true;
			}
		}
		return c;
	}
}

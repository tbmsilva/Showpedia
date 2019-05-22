/**
 * 
 */
package characters;

import java.util.*;

import event.*;
import exceptions.*;

/**
 * @author tbmsilva & m.lami
 *
 */
public abstract class AbstractCharacter implements ShowCharacter {

	protected String name;
	protected List<ShowCharacter> parents, kids, partners;
	protected List<Event> events;

	public AbstractCharacter(String name) {
		this.name = name;
		parents = new ArrayList<>();
		kids = new ArrayList<>();
		partners = new ArrayList<>();
		events = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void addParent(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException {
		if (character.getName().equals(name))
			throw new InvalidRelationshipException(name);
		else if (parents.contains(character))
			throw new RepeatedRelationshipException();
		else
			parents.add(character);
	}

	public int getParentCount() {
		return parents.size();
	}

	public void addKid(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException {
		if (character.getName().equals(name))
			throw new InvalidRelationshipException(name);
		else if (kids.contains(character))
			throw new RepeatedRelationshipException();
		else
			kids.add(character);
	}

	public int getKidCount() {
		return kids.size();
	}

	public void addRomance(ShowCharacter character)
			throws SameCharacterRomanceException, RepeatedRelationshipException {
		if (character.getName().equals(name))
			throw new SameCharacterRomanceException(name);
		else if (partners.contains(character))
			throw new RepeatedRelationshipException();
		else {
			partners.add(character);
		}
	}

	public void addEvent(Event e) {
		events.add(e);
	}
}

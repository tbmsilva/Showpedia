/**
 * 
 */
package characters;

import java.util.*;

import exceptions.*;

/**
 * @author tbmsilva & m.lami
 *
 */
public abstract class AbstractCharacter implements ShowCharacter {

	protected String name;
	protected List<ShowCharacter> parents, kids;

	public AbstractCharacter(String name) {
		this.name = name;
		parents = new ArrayList<ShowCharacter>();
		kids = new ArrayList<ShowCharacter>();
	}

	public String getName() {
		return name;
	}

	public int addParent(ShowCharacter character) throws InvalidRelationshipException {
		if (character.getName().equals(name))
			throw new InvalidRelationshipException(name);
		else {
			parents.add(character);
			return parents.size();
		}
	}

	public int addKid(ShowCharacter character) throws InvalidRelationshipException {
		if (character.getName().equals(name))
			throw new InvalidRelationshipException(name);
		else {
			kids.add(character);
			return kids.size();
		}
	}
}

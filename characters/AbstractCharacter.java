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
	protected List<ShowCharacter> parents, kids, partners;

	public AbstractCharacter(String name) {
		this.name = name;
		parents = new ArrayList<ShowCharacter>();
		kids = new ArrayList<ShowCharacter>();
		partners = new ArrayList<ShowCharacter>();
	}

	public String getName() {
		return name;
	}

	public int addParent(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException {
		if (character.getName().equals(name))
			throw new InvalidRelationshipException(name);
		else if(parents.contains(character))
			throw new RepeatedRelationshipException();
		else {
			parents.add(character);
			return parents.size();
		}
	}

	public int addKid(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException {
		if (character.getName().equals(name))
			throw new InvalidRelationshipException(name);
		else if(kids.contains(character))
			throw new RepeatedRelationshipException();
		else {
			kids.add(character);
			return kids.size();
		}
	}
	
	public void addRomance(ShowCharacter character) throws SameCharacterRomanceException, RepeatedRelationshipException {
		if(character.getName().equals(name))
			throw new SameCharacterRomanceException(name);
		else if (partners.contains(character))
			throw new RepeatedRelationshipException();
		else {
			partners.add(character);
		}
			
	}
}

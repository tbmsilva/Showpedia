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
		parents = new ArrayList<>();
		kids = new ArrayList<>();
		partners = new ArrayList<>();
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

	public Iterator<ShowCharacter> getParentsIterator() {
		return parents.iterator();
	}

	public Iterator<ShowCharacter> getKids() {
		return kids.iterator();
	}

	public Iterator<ShowCharacter> getPartners() {
		return partners.iterator();
	}

	public int getAmountOfPartners() {
		return partners.size();
	}

	public List<ShowCharacter> isAncestor(ShowCharacter otherCharacter) {
		List<ShowCharacter> path = new Stack<>();
		if (kids.isEmpty())
			return path;
		else if (kids.contains(otherCharacter)) {
			path.add(otherCharacter);
			return path;
		} else {
			for (ShowCharacter k : kids) {
				List<ShowCharacter> temp = k.isAncestor(otherCharacter);
				if (!temp.isEmpty()) {
					path.addAll(temp);
					path.add(k);
				}
			}
			return path;
		}
	}

	public List<ShowCharacter> isDescendant(ShowCharacter otherCharacter) {
		List<ShowCharacter> path = new Stack<>();
		if (parents.isEmpty())
			return path;
		else if (parents.contains(otherCharacter)) {
			path.add(otherCharacter);
			return path;
		} else {
			for (ShowCharacter p : parents) {
				List<ShowCharacter> temp = p.isDescendant(otherCharacter);
				if(!temp.isEmpty()) {
					path.addAll(temp);
					path.add(p);
				}
			}
			return path;
		}
	}
}

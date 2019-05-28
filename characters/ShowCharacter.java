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
public interface ShowCharacter {

	/**
	 * Returns the name of the character
	 * 
	 * @return the name of the character
	 */
	String getName();

	/**
	 * Adds a parent to the character's parent set.
	 * 
	 * @param character - character to be added to parent set.
	 * @throws InvalidRelationshipException
	 * @pre <code>character != null</code>
	 */
	void addParent(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * Returns the number of parents the character has.
	 * 
	 * @return the number of parents the character has.
	 */
	int getParentCount();

	/**
	 * Adds a kid to the character's kid set.
	 * 
	 * @param character - character to be added to kid set.
	 * @throws InvalidRelationshipException
	 * @pre <code>character != null</code>
	 */
	void addKid(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * Returns the number of kids the character has.
	 * 
	 * @return the number of kids the character has.
	 */
	int getKidCount();

	/**
	 * Adds a character to the list of partners of the character.
	 * 
	 * @param character - character to be added to the list of partners.
	 * @throws SameCharacterRomanceException
	 * @throws RepeatedRelationshipException
	 * @pre <code>character != null</code>
	 */
	void addRomance(ShowCharacter character) throws SameCharacterRomanceException, RepeatedRelationshipException;

	/**
	 * Returns an iterator for the parents of the character.
	 * 
	 * @return an iterator for the parents of the character.
	 */
	Iterator<ShowCharacter> getParentsIterator();

	/**
	 * Returns an iterator for the kids of the character.
	 * 
	 * @return an iterator for the kids of the character.
	 */
	Iterator<ShowCharacter> getKids();

	/**
	 * Returns an iterator for the partners of the character.
	 * 
	 * @return an iterator for the partners of the character.
	 */
	Iterator<ShowCharacter> getPartners();

	/**
	 * Returns the amount of partners the character has.
	 * 
	 * @return the amount of partners the character has.
	 */
	int getAmountOfPartners();

	/**
	 * If the character has kids, or kids of kids (and so on) that contain the given
	 * character (c2), it returns a list containing the path to the given character.
	 * If not, it returns an empty list.
	 * 
	 * @param c2 - character that may be descendant.
	 * @return list containing the path to the character c2.
	 */
	List<ShowCharacter> isAncestor(ShowCharacter c2);

	/**
	 * If the character has parents, or parents of parents (and so on) that contain
	 * the given character (c2), it returns a list containing the path to the given
	 * character. If not, it returns an empty list.
	 * 
	 * @param c2 - character that may be ancestor.
	 * @return list containg the path to the character c2.
	 */
	List<ShowCharacter> isDescendant(ShowCharacter c2);

}

/**
 * 
 */
package characters;

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
	 * @param character
	 * @return
	 * @throws InvalidRelationshipException
	 */
	int addParent(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException;
	
	/**
	 * @param character
	 * @return
	 * @throws InvalidRelationshipException
	 */
	int addKid(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException;

	void addRomance(ShowCharacter character) throws SameCharacterRomanceException, RepeatedRelationshipException;
}

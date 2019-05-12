/**
 * 
 */
package characters;

import exceptions.InvalidRelationshipException;

/**
 * @author tbmsilva
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
	int addParent(ShowCharacter character) throws InvalidRelationshipException;
	
	/**
	 * @param character
	 * @return
	 * @throws InvalidRelationshipException
	 */
	int addKid(ShowCharacter character) throws InvalidRelationshipException;
}

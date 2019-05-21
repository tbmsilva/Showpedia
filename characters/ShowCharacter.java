/**
 * 
 */
package characters;

import event.Event;
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
	 * @throws InvalidRelationshipException
	 */
	void addParent(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException;
	
	/**
	 * @return
	 */
	int getParentCount();
	
	/**
	 * @param character
	 * @throws InvalidRelationshipException
	 */
	void addKid(ShowCharacter character) throws InvalidRelationshipException, RepeatedRelationshipException;
	
	/**
	 * @return
	 */
	int getKidCount();

	/**
	 * @param character
	 * @throws SameCharacterRomanceException
	 * @throws RepeatedRelationshipException
	 */
	void addRomance(ShowCharacter character) throws SameCharacterRomanceException, RepeatedRelationshipException;
	
	void addEvent(Event e);
}

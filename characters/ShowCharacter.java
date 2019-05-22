/**
 * 
 */
package characters;

import java.util.*;

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
	
	/**
	 * 
	 * @param e
	 */
	void addEvent(Event e);
	
	/**
	 * 
	 * @return
	 */
	Iterator<ShowCharacter> getParents();
	
	/**
	 * 
	 * @return
	 */
	Iterator<ShowCharacter> getKids();
	
	/**
	 * 
	 * @return
	 */
	Iterator<ShowCharacter> getPartners();
	
	/**
	 * 
	 * @return
	 */
	Iterator<Event> getEvents();
	
}

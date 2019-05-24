/**
 * 
 */
package actors;

import java.util.Iterator;

import characters.Real;
import exceptions.DuplicateCharacterException;
import shows.Show;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface Actor {

	/**
	 * @return
	 */
	String getName();

	/**
	 * @return
	 */
	int getRoleCount();
	
	/**
	 * @return
	 */
	int getNumberOfShows();

	/**
	 * Adds a character to the list of characters of the actor.
	 * 
	 * @param character - character to be added.
	 * @throws DuplicateCharacterException
	 */
	void addCharacter(Real character) throws DuplicateCharacterException;
	
	/**
	 * @param show
	 */
	void addShow(Show show);
	
	/**
	 * @return
	 */
	Iterator<Show> getShowIterator();

	/**
	 * @return
	 */
	int getTotalRomances();
	
	/**
	 * @return
	 */
	int getShowsWithRomances();
}

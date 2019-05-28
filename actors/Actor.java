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
	 * Returns the name of the actor.
	 * 
	 * @return the name of the actor.
	 */
	String getName();

	/**
	 * Returns the number of roles this actor has.
	 * 
	 * @return the number of roles this actor has.
	 */
	int getRoleCount();

	/**
	 * Returns the number of shows this actor participates in.
	 * 
	 * @return the number of shows this actor participates in.
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
	 * Adds a new show to the list of the shows the actor participates in.
	 * 
	 * @param show - show to be added.
	 */
	void addShow(Show show);

	/**
	 * Returns an iterator for list of shows the actor participates in.
	 * 
	 * @return an iterator for list of shows the actor participates in.
	 */
	Iterator<Show> getShowIterator();

	/**
	 * Returns the number of partners an actor has, in all the shows.
	 * 
	 * @return the number of partners an actor has, in all the shows.
	 */
	int getTotalRomances();

	/**
	 * Returns the number of shows an actor participates and has romances in.
	 * 
	 * @return the number of shows an actor participates and has romances in.
	 */
	int getShowsWithRomances();
}

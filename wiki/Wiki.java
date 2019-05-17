/**
 * 
 */
package wiki;

import exceptions.*;
import shows.Show;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface Wiki {

	/**
	 * Returns the current selected show, unless no show is selected
	 * 
	 * @return the current selected show
	 * @throws NoShowSelectedException
	 */
	public Show getCurrentShow() throws NoShowSelectedException;

	/**
	 * Creates and adds a show
	 * 
	 * @param name - show's name
	 * @throws ShowAlreadyExistsException
	 */
	void addShow(String name) throws ShowAlreadyExistsException;

	/**
	 * Sets show with given name as current show
	 * 
	 * @param name - show's name
	 * @throws UnknownShowException
	 */
	void switchToShow(String name) throws UnknownShowException;

	/**
	 * Adds a season to the current show
	 * 
	 * @throws NoShowSelectedException
	 */
	void addSeason() throws NoShowSelectedException;

	/**
	 * Adds an episode to a particular season of the show. The new episode is added
	 * to the corresponding season, in first available serial number.
	 * 
	 * @param season - season number
	 * @param name   - name of the episode
	 * @throws NoShowSelectedException
	 * @throws UnknownSeasonException
	 */
	void addEpisode(int season, String name) throws NoShowSelectedException, UnknownSeasonException;

	/**
	 * @param category
	 * @param characterName
	 * @param actorOrCompanyName
	 * @param cost
	 * @throws NoShowSelectedException
	 * @throws UnknownActorCategoryException
	 * @throws DuplicateCharacterException
	 * @throws InvalidActorFeeException
	 */
	void addCharacter(String category, String characterName, String actorOrCompanyName, int cost)
			throws NoShowSelectedException, UnknownActorCategoryException, DuplicateCharacterException,
			InvalidActorFeeException;

	/**
	 * Returns the number of role an actor has been in
	 * 
	 * @param actor - actor's name
	 * @return actor's number of roles
	 */
	int getActorRoleCount(String actor);

	/**
	 * @param parentName
	 * @param kidName
	 * @return
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	String addRelationship(String parentName, String kidName)
			throws UnknownCharacterException, InvalidRelationshipException;

}

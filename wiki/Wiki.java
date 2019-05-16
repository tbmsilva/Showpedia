/**
 * 
 */
package wiki;

import exceptions.*;

/**
 * @author tbmsilva & m.lami
 *
 */
public interface Wiki {

	/**
	 * Returns the selected show's name
	 * 
	 * @return the selected show's name
	 * @throws NoShowSelectedException
	 */
	public String getCurrentShowName() throws NoShowSelectedException;

	/**
	 * Returns the selected show's season count
	 * 
	 * @return the selected show's season count
	 * @throws NoShowSelectedException
	 */
	public int getCurrentShowSeasonCount() throws NoShowSelectedException;

	/**
	 * Returns the selected show's episode count
	 * 
	 * @return the selected show's episode count
	 * @throws NoShowSelectedException
	 */
	public int getCurrentShowEpisodeCount() throws NoShowSelectedException;

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
	 * @return String with show and episode info
	 * @throws NoShowSelectedException
	 * @throws UnknownSeasonException
	 */
	String addEpisode(int season, String name) throws NoShowSelectedException, UnknownSeasonException;

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
	 * @param category
	 * @param characterName
	 * @param actorOrCompanyName
	 * @return
	 */
	String getCharacterInfo(String category, String characterName, String actorOrCompanyName);

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

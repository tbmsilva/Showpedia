/**
 * 
 */
package wiki;

import java.util.List;

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
	 * @throws UnknownCharacterException
	 * @throws InvalidRelationshipException
	 */
	void addRelationship(String parentName, String kidName) throws NoShowSelectedException, UnknownCharacterException,
			InvalidRelationshipException, RepeatedRelationshipException;

	/**
	 * @param character1
	 * @param character2
	 * @throws NoShowSelectedException
	 * @throws UnknownCharacterException
	 * @throws SameCharacterRomanceException
	 * @throws RepeatedRelationshipException
	 */
	void addRomance(String character1, String character2) throws NoShowSelectedException, UnknownCharacterException,
			SameCharacterRomanceException, RepeatedRelationshipException;
<<<<<<< HEAD
	
	void addEvent(String description, int season, int episode, int totalCharacters, List<String> characters)
			throws NoShowSelectedException, InvalidSeasonException, InvalidEpisodeException, UnknownCharacterException,
			DuplicateCharacterException;
=======

	/**
	 * @param parentName
	 * @return
	 * @pre <code>currentShow.getCharacter(parentName) != null</code>
	 */
	int getKidCount(String parentName);

	/**
	 * @param kidName
	 * @return
	 * @pre <code>currentShow.getCharacter(kidName) != null</code>
	 */
	int getParentCount(String kidName);
>>>>>>> 6438353bad21c4c7a2a4e18268e622fd8557854a
}
